import java.util.Scanner;

public class Check {
    private static Scanner input=new Scanner(System.in);
    public static String checkTime(){
        int hour=0;
        boolean t=false;
        while (t==false){
            t=true;
            System.out.println("Enter hour");
            hour=input.nextInt();
            if (hour>24){t=false;}
        }
        int minutes=0;
        while (t==true){
            t=false;
            System.out.println("Enter minutes");
            minutes=input.nextInt();
            input.nextLine();
            if (minutes>60){t=false;}
        }
        return Integer.toString(hour)+":"+Integer.toString(minutes);
    }
    public static String checkDate(){
        int month=0;
        boolean t=false;
        while(t==false) {
            t=true;
            System.out.println("Enter the month");
            month = input.nextInt();
            if(month>12){t=false;}
        }
        int day=0;
        while(t==true) {
            t=false;
            System.out.println("Enter the day");
            day = input.nextInt();
            input.nextLine();
            if(day>30){t=true;}
        }
        return "1402/"+ Integer.toString(month)+"/"+ Integer.toString(day);
    }
    public static Flight checkId(String id){
        Flights flights=Flights.getFlights();
        for (int i = 0; i < flights.flightArrayList.size(); i++) {
            if (id.equals(flights.flightArrayList.get(i).getId())){
                return flights.flightArrayList.get(i);
            }} return null;
    }
    public static User checkUsername(String name){
        Users users=Users.getUsers();
        for (int i = 0; i < users.getNumberOfUser(); i++) {
            if (users.usersArray[i].getUsername().equals(name)){
                return users.usersArray[i];
            }}
        return null;
    }
}
