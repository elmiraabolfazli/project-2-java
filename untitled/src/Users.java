import java.util.ArrayList;
import java.util.Scanner;

public class Users  {
    private User[] usersArry= new User[100];
    private int numberOfUser=0;
   private Scanner input=new Scanner(System.in);
   private int number=0;
    private Admin admin= new Admin();
    public int menu1(){
        System.out.println("1-Sing in");
        System.out.println("2-Sing up");
       return input.nextInt();
    }
    public void singUp(){
        usersArry[numberOfUser]=new User();
        System.out.println("Enter your username");
        String name=input.nextLine();
        name=input.nextLine();
        usersArry[numberOfUser].setUsername(name);
        System.out.println("Enter your password");
        String password=input.nextLine();
        usersArry[numberOfUser].setPassword(password);
        ++numberOfUser;
    }
    public int singIn(){
        int n=0;
        System.out.println("Enter your username");
        String name=input.nextLine();
        name=input.nextLine();

        if(name.equals("Admin")){
            return admin.singInAdmin();

        }else{
            for (int i = 0; i < numberOfUser; i++) {
                if(usersArry[i].getUsername().equals(name)){
                    System.out.println("Enter your password");
                    String password=input.nextLine();
                    if(usersArry[i].getPassword().equals(password)){ number=i;i=numberOfUser; return 1;}
                     else {
                        System.out.println("Wrong password!");
                        return 0;
                    }
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
        return input.nextInt();

    }
    public int userMenu(){
        System.out.println("1-Change password");
        System.out.println("2-Search flight tickets");
        System.out.println("3-Booking ticket");
        System.out.println("4-Ticket cancellation");
        System.out.println("5-Booked tickets");
        System.out.println("6-Add charge");
        System.out.println("0-Sing out");
        return input.nextInt();

    }
    public void changePassword(){
        System.out.println("Enter your new password");
        String password=input.nextLine();
        password=input.nextLine();
        usersArry[number].setPassword(password);
    }
    public void booking(ArrayList<Flight> flightsArrayList){
        System.out.println("Enter id flight");
       String id=input.nextLine();
        id=input.nextLine();
        for (int i = 0; i < flightsArrayList.size(); i++) {
            String idFlight=flightsArrayList.get(i).getId();
            if(id.equals(idFlight)){
                int seat=flightsArrayList.get(i).getSeats();
                long price= (long)flightsArrayList.get(i).getPrice();
                long charch=usersArry[number].getCharch();
                if (seat > 0 && charch>=price) {
                    usersArry[number].bookingFlight.add(flightsArrayList.get(i));
                    flightsArrayList.get(i).setSeats(--seat);
                    usersArry[number].setCharch(charch - price);
                    System.out.println("Flight"+id+" booked");
                }else {
                    System.out.println("You cant book ticket\n check the charch or seats");
                    i=flightsArrayList.size();
                }
            }
        }
    }
    public void church(){
        System.out.println("Enter church");
        long church = input.nextLong();
        usersArry[number].setCharch(church);
    }


}
