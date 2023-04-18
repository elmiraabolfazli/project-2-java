/**
 * This class has an arraylist from flight class to remove,ets
 *
 * @author Fatemeh Abolfazli
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Flights {
    public ArrayList<Flight> flightArrayList = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);
    //*********************************
    private static Flights obj = new Flights();

    private Flights() {
    }

    public static Flights getFlights() {
        if (obj == null) {
            obj = new Flights();
        }
        return obj;
    }

    //*******************************
    public void flightInitialize() {
        Flight flight = new Flight("w.1", "Yazd", "Kerman", "1402/2/20", "3:30", 700000, 40, 40);
        flightArrayList.add(flight);
        flight = new Flight("w.2", "Yazd", "Tehran", "1402/3/30", "5:45", 800000, 66, 66);
        flightArrayList.add(flight);
        flight = new Flight("w.3", "Ahvaz", "Kerman", "1402/12/2", "6:30", 900000, 20, 20);
        flightArrayList.add(flight);
        flight = new Flight("w.4", "Shiraz", "Tabriz", "1402/3/30", "5:45", 800000, 66, 66);
        flightArrayList.add(flight);
        flight = new Flight("w.5", "Mashhad", "Ahvaz", "1402/2/21", "3:30", 700000, 40, 40);
        flightArrayList.add(flight);
        flight = new Flight("w.6", "Tehran", "yazd", "1402/7/3", "5:45", 800000, 66, 66);
        flightArrayList.add(flight);
        flight = new Flight("w.7", "Tabriz", "Shiraz", "1402/1/2", "6:30", 900000, 20, 20);
        flightArrayList.add(flight);
        flight = new Flight("w.8", "Ahvaz", "Mashhad", "1402/11/30", "5:45", 800000, 66, 66);
        flightArrayList.add(flight);
        flight = new Flight("w.9", "Isfahan", "Fars", "1402/11/2", "6:30", 900000, 20, 20);
        flightArrayList.add(flight);
        flight = new Flight("w.10", "Semnan", "Golestan", "1402/1/30", "5:45", 800000, 66, 66);
        flightArrayList.add(flight);
    }

    public void searchFlightTicket() {
        ArrayList<Flight> flightArrayList1 = new ArrayList<>();
        for (int i = 0; i < flightArrayList.size(); i++) {
            flightArrayList1.add(flightArrayList.get(i));
        }
        int n = 1;
        ArrayList<String> filter = new ArrayList<>();
        while (n != 0) {
            n = searchFlightTicketFilters(filter);
            switch (n) {
                case 1:
                    searchId(flightArrayList1, filter);
                    break;
                case 2:
                    searchOrigin(flightArrayList1, filter);
                    break;
                case 3:
                    searchDestination(flightArrayList1, filter);
                    break;
                case 4:
                    searchDate(flightArrayList1, filter);
                    break;
                case 5:
                    searchPrice(flightArrayList1, filter);
                    break;
                case 6:
                    searchTime(flightArrayList1, filter);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong number");

            }
        }
    }

    public void print(ArrayList<Flight> flightArrayList) {
        System.out.println("Available flights:");
        for (int i = 0; i < flightArrayList.size(); i++) {
            System.out.println(flightArrayList.get(i));
        }
    }

    //*******************************
    private void searchPrice(ArrayList<Flight> flightArrayList1, ArrayList<String> filter) {
        filter.add("price");
        System.out.println("Enter Price rang:");
        System.out.println("Min");
        long min = input.nextLong();
        System.out.println("Max");
        long max = input.nextLong();
        input.nextLine();
        if (min > max) {
            System.out.println("Wrong rang");
            return;
        }
        for (int i = 0; i < flightArrayList1.size(); i++) {
            double price = flightArrayList1.get(i).getPrice();
            if (!((min <= price) && (max >= price))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchDate(ArrayList<Flight> flightArrayList1, ArrayList<String> filter) {
        filter.add("date");
        String date = Check.checkDate();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(date.equals(flightArrayList1.get(i).getDate()))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchDestination(ArrayList<Flight> flightArrayList1, ArrayList<String> filter) {
        filter.add("destination");
        System.out.println("Enter destination:");
        String destination = input.nextLine();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(destination.equals(flightArrayList1.get(i).getDestination()))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchOrigin(ArrayList<Flight> flightArrayList1, ArrayList<String> filter) {
        filter.add("origin");
        System.out.println("Enter origin:");
        String origin = input.nextLine();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(origin.equals(flightArrayList1.get(i).getOrigin()))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchId(ArrayList<Flight> flightArrayList1, ArrayList<String> filter) {
        filter.add("id");
        System.out.println("Enter id:");
        String id = input.nextLine();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(id.equals(flightArrayList1.get(i).getId()))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchTime(ArrayList<Flight> flightArrayList1, ArrayList<String> filter) {
        filter.add("Time");
        String time = Check.checkTime();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(time.equals(flightArrayList1.get(i).getTime()))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private int searchFlightTicketFilters(ArrayList<String> filter) {
        System.out.println("Choose filter");
        System.out.println("Your filter:" + filter);
        System.out.println("1-Id");
        System.out.println("2-Origin");
        System.out.println("3-Destination");
        System.out.println("4-Date");
        System.out.println("5-Price");
        System.out.println("6-Time");
        System.out.println("0-sing out");
        int n = input.nextInt();
        input.nextLine();
        return n;
    }
}
