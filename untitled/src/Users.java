import java.util.ArrayList;
import java.util.Scanner;

public class Users  {
    private User[] usersArray = new User[100];
    private int numberOfUser=0;
   private Scanner input=new Scanner(System.in);
   private int number=0;
    public int menu1(){
        System.out.println("1-Sing in");
        System.out.println("2-Sing up");
       int n= input.nextInt();
       input.nextLine();
       return n;
    }
    public void singUp(){
        usersArray[numberOfUser]=new User();
        String name="";
        boolean flag=true;
        System.out.println("Enter your username");
         name=input.nextLine();
        if(name.equals("Admin")){
            System.out.println("Choose another name");
        }else {
            //checking repetitive name
        for (int i = 0; i < numberOfUser; i++) {
        if (usersArray[i].getUsername().equals(name)){
            System.out.println("Your username is repeated");
            flag=false;
        }}
        while (flag){
        usersArray[numberOfUser].setUsername(name);
        System.out.println("Enter your password");
        String password=input.nextLine();
        usersArray[numberOfUser].setPassword(password);
        ++numberOfUser;
        flag=false;
        }}
    }
    public int singIn(){
        int n=0;
        //( n==0 Wrong) (n==1 user) (n==2 admin)
        System.out.println("Enter your username");
        String name=input.nextLine();
        if(name.equals("Admin")){
            return singInAdmin();

        }else{
            for (int i = 0; i < numberOfUser; i++) {
                if(usersArray[i].getUsername().equals(name)){
                    System.out.println("Enter your password");
                    String password=input.nextLine();
                    if(usersArray[i].getPassword().equals(password)){ number=i;i=numberOfUser; return 1;}
                     else {
                        System.out.println("Wrong password!");
                        return 0;
                    }
                } else if (i==numberOfUser-1) {
                    System.out.println("Your username does not exist");
                }

            }
        }
        return n;
    }
    public int adminMenu(){
        System.out.println("1-Add");
        System.out.println("2-Update");
        System.out.println("3-Remove");
        System.out.println("4-Flight schedules");
        System.out.println("0-Sing out ");
         int n=input.nextInt();
         input.nextLine();
        return n;
    }
    public int userMenu(){
        System.out.println("1-Change password");
        System.out.println("2-Search flight tickets");
        System.out.println("3-Booking ticket");
        System.out.println("4-Add charge");
        System.out.println("5-Ticket cancellation");
        System.out.println("6-Booked tickets");
        System.out.println("0-Sing out");
        int n= input.nextInt();
        input.nextLine();
        return n;
    }
    public void changePassword(){
        System.out.println("Enter your new password");
        String password=input.nextLine();
        usersArray[number].setPassword(password);
    }
    public void booking(ArrayList<Flight> flightsArrayList){
        System.out.println("Enter id flight");
       String id=input.nextLine();
        for (int i = 0; i < flightsArrayList.size(); i++) {
            String idFlight=flightsArrayList.get(i).getId();
            if(id.equals(idFlight)){
                int seat=flightsArrayList.get(i).getSeats();
                double price= flightsArrayList.get(i).getPrice();
                double charge = usersArray[number].getCharge();
                if (seat > 0 && charge>=price) {
                    flightsArrayList.get(i).setSeats(--seat);
                    usersArray[number].setCharge(charge-price);
                    usersArray[number].bookingFlight.add(flightsArrayList.get(i));
                    System.out.println("Flight"+id+" booked");
                    i=flightsArrayList.size();
                }else {
                    System.out.println("You cant book ticket\n check the charge or seats");
                    i=flightsArrayList.size();
                }
            } else if (i==(flightsArrayList.size()-1) ) {
                System.out.println("Id does not exist");
            }
        }
    }
    public void charge (){
        System.out.println("Enter charge");
        double charge = input.nextLong();
        input.nextLine();
        usersArray[number].setCharge(charge+ usersArray[number].getCharge());
        System.out.println("your charge:"+(usersArray[number].getCharge()));
    }
    public void print(){
        for (int i = 0; i < usersArray[number].bookingFlight.size(); i++) {
            System.out.println(usersArray[number].bookingFlight.get(i));
        }
    }
    public void ticketCancellation (ArrayList<Flight> flightsArrayList){
        System.out.println("Enter id flight");
        String id=input.nextLine();
        for (int i = 0; i < usersArray[number].bookingFlight.size(); i++) {
            if(id.equals(usersArray[number].bookingFlight.get(i).getId())){
                int seat= usersArray[number].bookingFlight.get(i).getSeats();
                double price=usersArray[number].bookingFlight.get(i).getPrice();
                double charge= usersArray[number].getCharge();
                    usersArray[number].bookingFlight.remove(i);
                    flightsArrayList.get(i).setSeats(++seat);
                    usersArray[number].setCharge(charge + price);
                    System.out.println("Flight"+id+" cancelled");
            } else if (i==(usersArray[number].bookingFlight.size()-1)) {
                System.out.println("Id does not exist");
            }
        }
    }
    public int singInAdmin (){
        System.out.println("Enter your password");
        String password=input.nextLine();
        if(password.equals("Admin")){
            return 2;
        }
        else {
            System.out.println("Wrong password");return 0;}
    }

}
