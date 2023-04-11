import java.util.ArrayList;
import java.util.Scanner;

public class  Menu {
    private static Scanner input=new Scanner(System.in);
    public static int  updateMenue(){
        System.out.println("1-id");
        System.out.println("2-origin");
        System.out.println("3-destination");
        System.out.println("4-date");
        System.out.println("5-time");
        System.out.println("6-price");
        System.out.println("7-seats");
        System.out.println("0-sing out");
        int n= input.nextInt();
        input.nextLine();
        return n;
    }
    public static int searchFlightTicketFilters(ArrayList<String> filter){
        System.out.println("Choose filter");
        System.out.println("Your filter:"+filter);
        System.out.println("1-Id");
        System.out.println("2-Origin");
        System.out.println("3-Destination");
        System.out.println("4-Date");
        System.out.println("5-Price");
        System.out.println("0-sing out");
        int n= input.nextInt();
        input.nextLine();
        return n;
    }
    public static int menu1(){
        System.out.println("1-Sing in");
        System.out.println("2-Sing up");
        int n= input.nextInt();
        input.nextLine();
        return n;
    }
    public static int adminMenu(){
        System.out.println("1-Add");
        System.out.println("2-Update");
        System.out.println("3-Remove");
        System.out.println("4-Flight schedules");
        System.out.println("0-Sing out ");
        int n=input.nextInt();
        input.nextLine();
        return n;
    }
    public static int userMenu(){
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
}
