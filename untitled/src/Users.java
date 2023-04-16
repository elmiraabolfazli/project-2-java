import java.util.ArrayList;
import java.util.Scanner;

public class Users  {
    public User[] usersArray = new User[100];
    private User user=new User();
    private int numberOfUser=0;
    private Scanner input=new Scanner(System.in);
    private IdTickets idTickets=IdTickets.getIdTickets();
    private IdTicket idTicket=new IdTicket();
    //******************************
    private static Users obj= new Users();
    private Users(){}
    public static Users getUsers(){
        if(obj==null){
            obj=new Users();
        }
        return obj;
    }
    //******************************
    private  User checkUsername(String name){
       Users users= getUsers();
       for (int i = 0; i < users.getNumberOfUser(); i++) {
           if (users.usersArray[i].getUsername().equals(name)){
               return users.usersArray[i];
           }}
       return null;
   }
    public void singUp(){
        usersArray[numberOfUser]=new User();
        System.out.println("Enter your username");
         String name=input.nextLine();
        if(name.equals("Admin")){
            System.out.println("Choose another name");
        }else {
             user= checkUsername(name);
        if (user!=null){
            System.out.println("Your username is repeated");
        }else {
        usersArray[numberOfUser].setUsername(name);
        System.out.println("Enter your password");
        String password=input.nextLine();
        usersArray[numberOfUser].setPassword(password);
        ++numberOfUser;
        }}
    }
    public int singIn(){
        Admin admin=new Admin();
        int n=0;
        //( n==0 Wrong) (n==1 user) (n==2 admin)
        System.out.println("Enter your username");
        String name=input.nextLine();
        if(name.equals("Admin")){
            return admin.singInAdmin();
        }else{
             user= checkUsername(name);
                if(user!=null){
                    System.out.println("Enter your password");
                    String password=input.nextLine();
                    if(user.getPassword().equals(password)){return 1;}
                     else {
                        System.out.println("Wrong password!");
                        return 0;
                    }
                } else{
                    System.out.println("Your username does not exist");
                }
        }
        return n;
    }
    public void changePassword(){
        System.out.println("Enter your new password");
        String password=input.nextLine();
        user.setPassword(password);
    }
    public void booking(ArrayList<Flight> flightsArrayList){
        System.out.println("Enter id flight");
       String id="w.1";//input.nextLine();
        for (int i = 0; i < flightsArrayList.size(); i++) {
            String idFlight=flightsArrayList.get(i).getId();
            if(id.equals(idFlight)){
                int seat=flightsArrayList.get(i).getSeats();
                double price= flightsArrayList.get(i).getPrice();
                double charge = user.getCharge();
                if (seat > 0 && charge>=price) {
                    flightsArrayList.get(i).setSeats(--seat);
                    user.setCharge(charge-price);
                    //user.bookingFlight.add(flightsArrayList.get(i));
                    idTicket.setUser(user);
                    idTicket.setFlight(flightsArrayList.get(i));
                    idTicket.setIdTicket(id+seat);
                    idTickets.idTicketArrayList.add(idTicket);
                    System.out.println("Flight"+id+seat+" booked");
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
        double charge = Check.checkPrice();
        user.setCharge(charge+ user.getCharge());
        System.out.println("your charge:"+(user.getCharge()));
    }
    public void print(){
        for (int i = 0; i < user.bookingFlight.size(); i++) {
            System.out.println(user.bookingFlight.get(i));
        }
    }
    public void ticketCancellation (ArrayList<Flight> flightsArrayList){
        System.out.println("Enter id flight");
        String id=input.nextLine();
        for (int i = 0; i < user.bookingFlight.size(); i++) {
            if(id.equals(user.bookingFlight.get(i).getId())){
                int seat= user.bookingFlight.get(i).getSeats();
                double price=user.bookingFlight.get(i).getPrice();
                double charge= user.getCharge();
                    user.bookingFlight.remove(i);
                    flightsArrayList.get(i).setSeats(++seat);
                    user.setCharge(charge + price);
                    System.out.println("Flight"+id+" cancelled");
            } else if (i==(user.bookingFlight.size()-1)) {
                System.out.println("Id does not exist");
            }
        }
    }
    private int getNumberOfUser() {
        return numberOfUser;
    }
}
