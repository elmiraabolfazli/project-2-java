import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    //public User[] usersArray = new User[100];
    private User user=new User();
    private int numberOfUser = 0;
    private Scanner input = new Scanner(System.in);
    private IdTickets idTickets = IdTickets.getIdTickets();
    private ArrayList<IdTicket> idTicketArrayList = idTickets.idTicketArrayList;
    //*******************************
    private final int SIZE_S=40;
    private final int SIZE_R=88;
    private int number;
   public RandomAccessFile userFile;

    {
        try {
            userFile = new RandomAccessFile("user.dat","rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //******************************


    //******************************
   /* private User checkUsername(String name) {
        for (int i = 0; i <getNumberOfUser(); i++) {
            if (usersArray[i].getUsername().equals(name)) {
                return usersArray[i];
            }
        }
        return null;
    }*/

    public void singUp()throws IOException {
       // usersArray[numberOfUser] = new User();
        System.out.println("Enter your username");
        String name = input.nextLine();
        if (name.equals("Admin")) {
            System.out.println("Choose another name");
        } else {
           // user =findUser(name);
            if (findUser(name)) {
                System.out.println("Your username is repeated");
            } else {
               // usersArray[numberOfUser].setUsername(name);
                int n= (int) (userFile.length()/SIZE_R);
                stiringOnFile(0,n,name);
                System.out.println("Enter your password");
                String password = input.nextLine();
                //usersArray[numberOfUser].setPassword(password);
                stiringOnFile(40,n,password);
                userFile.writeDouble(0);
                ++numberOfUser;
            }
        }
    }

    public int singIn()throws IOException {
       // System.out.println(userFile.length());
        Admin admin = new Admin();
        int n = 0;
        //( n==0 Wrong) (n==1 user) (n==2 admin)
        System.out.println("Enter your username");
        String name = input.nextLine();
        if (name.equals("Admin")) {
            return admin.singInAdmin();
        } else {
           // user = findUser(name);
            if (findUser(name)) {
                System.out.println("Enter your password");
                String password = input.nextLine();
                if (readfix(number,40).equals(password)) {
                    return 1;
                } else {
                    System.out.println("Wrong password!");
                    return 0;
                }
            } else {
                System.out.println("Your username does not exist");
            }
        }
        return n;
    }

    public void changePassword() throws IOException{
        System.out.println("Enter your new password");
        String password = input.nextLine();
      //  userFile.seek(number*88+40);
       // userFile.writeChars(fixWrite(password));
        stiringOnFile(40,number,password);
        System.out.println("your password changed");
    }

    public void booking(ArrayList<Flight> flightsArrayList) throws IOException {
        Flights flights=Flights.getFlights();
        System.out.println("Enter id flight");
        IdTicket idTicket = new IdTicket();
        String id = input.nextLine();
            if (flights.findflight(id)) {
                flights.flightfile.seek(flights.number*flights.SIZE_R+100);
                double price = flights.flightfile.readDouble();
                int seat = flights.flightfile.readInt();
                userFile.seek(number*SIZE_R+80);
                double charge =userFile.readDouble();
                        //user.getCharge();
                if (seat > 0 && charge >= price) {
                    flights.intinfile(108,flights.number,--seat);
                   // user.setCharge(charge - price);
                    numberinfile(80,number,charge-price);
                    //user.bookingFlight.add(flightsArrayList.get(i));
                   // idTicket.setUser(user);
                    idTicket.setNumberofuser(number);
                    //idTicket.setFlight(flightsArrayList.get(i));
                    idTicket.setIdFlight(id);
                    idTicket.setIdTicket(id + seat);
                    //idTicketArrayList.add(idTicket);
                    idTickets.addTicket(idTicket);
                    System.out.println("Flight " + id + seat + " booked");
                } else {
                    System.out.println("You cant book ticket\n check the charge or seats");
                }
            } else {
                System.out.println("Id does not exist");
            }

    }

    public void charge()throws IOException {
        double charge = Check.checkPrice();
        userFile.seek(number*88+80);
       // userFile.writeDouble(charge+userFile.readDouble());
        numberinfile(80,number,userFile.readDouble()+charge);
        //userFile.seek(number*88+80);
        //user.setCharge(charge+userFile.readDouble());
        userFile.seek(number*88+80);
        System.out.println("your charge:" + userFile.readDouble());
    }

    public void print() throws IOException {
        Flights flights=Flights.getFlights();
        for (int i = 0; i < idTickets.idTicketFile.length()/44; i++) {
            idTickets.idTicketFile.seek(i*44+20);
            if (idTickets.idTicketFile.readInt()==number) {
                System.out.println(idTickets.readfix(i,0) + ":");
                String idFlight=idTickets.readfix(i,24);
                flights.findflight(idFlight);
                System.out.println(flights.printFlight(flights.number));
            }
        }
    }

    public void ticketCancellation(ArrayList<Flight> flightsArrayList) throws IOException {
        Flights flights=Flights.getFlights();
        System.out.println("Enter id flight");
        String id = input.nextLine();
        if (idTickets.findticket(id)) {
            idTickets.idTicketFile.seek(idTickets.number*44+20);
            if (idTickets.idTicketFile.readInt()==number) {
                String flightid=idTickets.readfix(idTickets.number,24);
                if (flights.findflight(flightid)) {
                    flights.flightfile.seek(flights.number*flights.SIZE_R+100);
                    double price = flights.flightfile.readDouble();
                    int seat =flights.flightfile.readInt();
                    flights.intinfile(108,flights.number,++seat);
                    idTickets.remove();
                    userFile.seek(number * SIZE_R + 80);
                    numberinfile(80, number, userFile.readDouble() + price);
                    System.out.println("Flight" + id + " cancelled");
                }
            }
            }else{
            System.out.println("Id does not exist");
        }
    }

    private int getNumberOfUser() {
        return numberOfUser;
    }
    //****************
    public void stiringOnFile(int atribiut,int record,String s)throws IOException {
        //System.out.println(((record*SIZE_R)+atribiut));
        userFile.seek(((record*SIZE_R)+atribiut));
        userFile.writeChars(fixWrite(s));
    }

    private String fixWrite(String s)  {
        if(s.length()>20){
            return s.substring(0,20);
        } else if (s.length()<20) {
            int n=20-s.length();
            for (int i = 0; i < n; i++) {
                s+=" ";
            }
        }
        return s;
    }
    public void numberinfile(int atribiut,int record,double charge) throws IOException{
        userFile.seek(((record*SIZE_R)+atribiut));
        userFile.writeDouble(charge);
    }
    public boolean findUser(String name)throws IOException{
        for (int i = 0; i <userFile.length()/SIZE_R; i++) {
            if(readfix(i,0).equals(name)){
                number=i;
                return true;
                //User user=new User();
              //  user.setUsername(name);
              // user.setPassword(readfix(i,40));
              // user.setCharge(userFile.readDouble());
             //  return user;
            }
        }
        return false;
    }
    public String readfix(int i,int atribiut ) throws IOException{
        userFile.seek((i*SIZE_R)+atribiut);
        String name="";
        for (int j = 0; j < 20; j++) {
            name+=userFile.readChar();
        }
        return name.trim();
    }
}
