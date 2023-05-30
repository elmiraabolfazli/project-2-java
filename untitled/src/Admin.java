import java.io.IOException;
import java.util.Scanner;

public class Admin {
    Flights flights = Flights.getFlights();
    private Scanner input = new Scanner(System.in);

    //**************************************
    public int singInAdmin() {
        System.out.println("Enter your password");
        String password = input.nextLine();
        if (password.equals("Admin")) {
            return 2;
        } else {
            System.out.println("Wrong password");
            return 0;
        }
    }

    public void add() throws IOException {
        Flight flight = new Flight();
        boolean t=true;
        String id ="";
        while (t) {
            System.out.println("Enter flight id");
            id = input.nextLine();
             t= flights.findflight(id);
            if (t) {
                System.out.println("Flight " + id + " is exist");
            }
        }
        System.out.println("Enter origin");
        String origin = input.nextLine();
        System.out.println("Enter destination ");
        String destination = input.nextLine();
        String date = Check.checkDate();
        String time = Check.checkTime();
        double price = Check.checkPrice();
        int seats = Check.checkSeats();
        System.out.println("Flight " + id + " add");
        flight = new Flight(id, origin, destination, date, time, price, seats, seats);
        flights.addFlight(flight);
       // flights.flightArrayList.add(flight);
    }

    public void remove() throws IOException {
        System.out.println("Enter the id");
        String id = input.nextLine();
        boolean t= flights.findflight(id);
        if (t) {
            flights.flightfile.seek(flights.number*116+108);
            if (flights.flightfile.readInt() == flights.flightfile.readInt()) {
                //flights.flightArrayList.remove(flight);
                flights.remove();
                System.out.println("Flight " + id + " removed");
            } else {
                System.out.println("Flight " + id + " is reserved");
            }
        } else {
            System.out.println("Id does not exist");
        }
    }

    public void update() throws IOException {
        int n = 1;
        System.out.println("Enter the id");
        String id = input.nextLine();
        boolean t= flights.findflight(id);
        if (t) {
            flights.flightfile.seek(flights.number*116+108);
            if (flights.flightfile.readInt() == flights.flightfile.readInt()) {
                while (n != 0) {
                    n = updateMenue();
                    switch (n) {
                        case 1:
                            updateId();
                            id = flights.readfix(flights.number, 0);
                            System.out.println("Flight " + id + " update");
                            break;
                        case 2:
                            System.out.println("Enter origin");
                            flights.stiringOnFile(20, flights.number, input.nextLine());
                            System.out.println("Flight " + id + " update");
                            break;
                        case 3:
                            System.out.println("Enter Destination");
                            flights.stiringOnFile(40, flights.number, input.nextLine());
                            System.out.println("Flight " + id + " update");
                            break;
                        case 4:
                            flights.stiringOnFile(60, flights.number, Check.checkDate());
                            System.out.println("Flight " + id + " update");
                            break;
                        case 5:
                            flights.stiringOnFile(80, flights.number, Check.checkTime());
                            System.out.println("Flight " + id + " update");
                            break;
                        case 6:
                            flights.doubleinfile(100, flights.number,Check.checkPrice());
                            System.out.println("Flight " + id + " update");
                            break;
                        case 7:
                            int seats = Check.checkSeats();
                            flights.intinfile(108, flights.number,seats);
                            flights.intinfile(112, flights.number,seats);
                            System.out.println("Flight " + id + " update");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Wrong number");
                    }
                }
            } else {
                System.out.println("Flight " + id + " is reserved");
            }
        } else {
            System.out.println("Id does not exist");
        }
    }

    private void updateId() throws IOException {
        String id;
        int n= flights.number;
        System.out.println("Enter flight id");
        id = input.nextLine();
        if (!flights.findflight(id)) {
            flights.stiringOnFile(0,flights.number,id);
        } else {
            System.out.println("Id is repetitive");
            flights.setNumber(n);
        }
    }

    public int updateMenue() {
        System.out.println("1-id");
        System.out.println("2-origin");
        System.out.println("3-destination");
        System.out.println("4-date");
        System.out.println("5-time");
        System.out.println("6-price");
        System.out.println("7-seats");
        System.out.println("0-sing out");
        int n = input.nextInt();
        input.nextLine();
        return n;
    }
}
