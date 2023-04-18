import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    public User[] usersArray = new User[100];
    private User user = new User();
    private int numberOfUser = 0;
    private Scanner input = new Scanner(System.in);
    private IdTickets idTickets = IdTickets.getIdTickets();
    private ArrayList<IdTicket> idTicketArrayList = idTickets.idTicketArrayList;

    //******************************
    private static Users obj = new Users();

    private Users() {
    }

    public static Users getUsers() {
        if (obj == null) {
            obj = new Users();
        }
        return obj;
    }

    //******************************
    private User checkUsername(String name) {
        Users users = getUsers();
        for (int i = 0; i < users.getNumberOfUser(); i++) {
            if (users.usersArray[i].getUsername().equals(name)) {
                return users.usersArray[i];
            }
        }
        return null;
    }

    public void singUp() {
        usersArray[numberOfUser] = new User();
        System.out.println("Enter your username");
        String name = input.nextLine();
        if (name.equals("Admin")) {
            System.out.println("Choose another name");
        } else {
            user = checkUsername(name);
            if (user != null) {
                System.out.println("Your username is repeated");
            } else {
                usersArray[numberOfUser].setUsername(name);
                System.out.println("Enter your password");
                String password = input.nextLine();
                usersArray[numberOfUser].setPassword(password);
                ++numberOfUser;
            }
        }
    }

    public int singIn() {
        Admin admin = new Admin();
        int n = 0;
        //( n==0 Wrong) (n==1 user) (n==2 admin)
        System.out.println("Enter your username");
        String name = input.nextLine();
        if (name.equals("Admin")) {
            return admin.singInAdmin();
        } else {
            user = checkUsername(name);
            if (user != null) {
                System.out.println("Enter your password");
                String password = input.nextLine();
                if (user.getPassword().equals(password)) {
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

    public void changePassword() {
        System.out.println("Enter your new password");
        String password = input.nextLine();
        user.setPassword(password);
        System.out.println("your password changed");
    }

    public void booking(ArrayList<Flight> flightsArrayList) {
        System.out.println("Enter id flight");
        IdTicket idTicket = new IdTicket();
        String id = input.nextLine();
        for (int i = 0; i < flightsArrayList.size(); i++) {
            String idFlight = flightsArrayList.get(i).getId();
            if (id.equals(idFlight)) {
                int seat = flightsArrayList.get(i).getSeats();
                double price = flightsArrayList.get(i).getPrice();
                double charge = user.getCharge();
                if (seat > 0 && charge >= price) {
                    flightsArrayList.get(i).setSeats(--seat);
                    user.setCharge(charge - price);
                    //user.bookingFlight.add(flightsArrayList.get(i));
                    idTicket.setUser(user);
                    idTicket.setFlight(flightsArrayList.get(i));
                    idTicket.setIdTicket(id + seat);
                    idTicketArrayList.add(idTicket);
                    System.out.println("Flight" + id + seat + " booked");
                    i = flightsArrayList.size();
                } else {
                    System.out.println("You cant book ticket\n check the charge or seats");
                    i = flightsArrayList.size();
                }
            } else if (i == (flightsArrayList.size() - 1)) {
                System.out.println("Id does not exist");
            }
        }
    }

    public void charge() {
        double charge = Check.checkPrice();
        user.setCharge(charge + user.getCharge());
        System.out.println("your charge:" + (user.getCharge()));
    }

    public void print() {
        for (int i = 0; i < idTicketArrayList.size(); i++) {
            if (user.equals(idTicketArrayList.get(i).getUser())) {
                System.out.println(idTicketArrayList.get(i).idTicket + ":");
                System.out.println(idTicketArrayList.get(i).flight);
            }
        }
    }

    public void ticketCancellation(ArrayList<Flight> flightsArrayList) {
        System.out.println("Enter id flight");
        String id = input.nextLine();
        for (int i = 0; i < idTicketArrayList.size(); i++) {
            if (user.equals(idTicketArrayList.get(i).getUser())) {
                if (id.equals(idTicketArrayList.get(i).getIdTicket())) {
                    int seat = idTicketArrayList.get(i).getFlight().getSeats();
                    double price = idTicketArrayList.get(i).getFlight().getPrice();
                    double charge = user.getCharge();
                    idTicketArrayList.get(i).getFlight().setSeats(++seat);
                    idTicketArrayList.remove(i);
                    user.setCharge(charge + price);
                    System.out.println("Flight" + id + " cancelled");
                }
            } else if (i == (idTicketArrayList.size() - 1)) {
                System.out.println("Id does not exist");
            }
        }
    }

    private int getNumberOfUser() {
        return numberOfUser;
    }
}
