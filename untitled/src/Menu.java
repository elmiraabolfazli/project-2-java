import java.util.Scanner;

public class  Menu {
    private static Scanner input=new Scanner(System.in);
    private static Flights flights=Flights.getFlights();
    private static Users users=Users.getUsers();
    //**********************************
    public static void menu1(){
        System.out.println("1-Sing in");
        System.out.println("2-Sing up");
        int n= input.nextInt();
        input.nextLine();
        switch (n){
            case 1:
                n=users.singIn();
                switch (n){
                    case 1:
                        while (n!=0){
                            n= userMenu();
                        }
                        break;
                    case 2:
                        while (n!=0){
                            n= adminMenu();
                        }
                        break;
                }
                break;
            case 2:
                users.singUp();
                break;
            default:
                System.out.println("Wrong number");
        }
    }
    private static int adminMenu(){
        Admin admin=new Admin();
        System.out.println("1-Add");
        System.out.println("2-Update");
        System.out.println("3-Remove");
        System.out.println("4-Flight schedules");
        System.out.println("0-Sing out ");
        int n=input.nextInt();
        input.nextLine();
        switch (n){
            case 1:
                admin.add();
                break;
            case 2:
                admin.update();
                break;
            case 3:
                admin.remove();
                break;
            case 4:
                flights.print(flights.flightArrayList);
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong number");
        }
        return n;
    }
    private static int userMenu(){
        System.out.println("1-Change password");
        System.out.println("2-Search flight tickets");
        System.out.println("3-Booking ticket");
        System.out.println("4-Add charge");
        System.out.println("5-Ticket cancellation");
        System.out.println("6-Booked tickets");
        System.out.println("0-Sing out");
        int n= input.nextInt();
        input.nextLine();
        switch (n) {
            case 1:
                users.changePassword();
                break;
                case 2:
                    flights.searchFlightTicket();
                    break;
                    case 3:
                            users.booking(flights.flightArrayList);
                            break;
                        case 4:
                            users.charge();
                            break;
                        case 5:
                            users.ticketCancellation(flights.flightArrayList);
                            break;
                        case 6:
                            users.print();
                        case 0:
                            break;
                        default:
                            System.out.println("Wrong number");
                    }
        return n;
    }
}
