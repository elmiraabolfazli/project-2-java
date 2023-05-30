/**
 * This class has an arraylist from flight class to remove,ets
 *
 * @author Fatemeh Abolfazli
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Flights extends FlightFile {
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



    public void flightInitialize() throws IOException {
        if(flightfile.length()==0) {
            Flight flight = new Flight("w.1", "Yazd", "Kerman", "1402/2/20", "3:30", 700000, 40, 40);
            // flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.2", "Yazd", "Tehran", "1402/3/30", "5:45", 800000, 66, 66);
            //flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.3", "Ahvaz", "Kerman", "1402/12/2", "6:30", 900000, 20, 20);
            //flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.4", "Shiraz", "Tabriz", "1402/3/30", "5:45", 800000, 66, 66);
            //flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.5", "Mashhad", "Ahvaz", "1402/2/21", "3:30", 700000, 40, 40);
            // flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.6", "Tehran", "yazd", "1402/7/3", "5:45", 800000, 66, 66);
            //flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.7", "Tabriz", "Shiraz", "1402/1/2", "6:30", 900000, 20, 20);
            //flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.8", "Ahvaz", "Mashhad", "1402/11/30", "5:45", 800000, 66, 66);
            // flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.9", "Isfahan", "Fars", "1402/11/2", "6:30", 900000, 20, 20);
            //flightArrayList.add(flight);
            addFlight(flight);
            flight = new Flight("w.10", "Semnan", "Golestan", "1402/1/30", "5:45", 800000, 66, 66);
            //flightArrayList.add(flight);
            addFlight(flight);
        }
    }

    public void searchFlightTicket() throws IOException {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < flightfile.length()/SIZE_R; i++) {
            integerArrayList.add(i);
        }
        int n = 1;
        ArrayList<String> filter = new ArrayList<>();
        while (n != 0) {
            n = searchFlightTicketFilters(filter);
            switch (n) {
                case 1:
                    searchId(integerArrayList, filter);
                    break;
                case 2:
                    searchOrigin(integerArrayList, filter);
                    break;
                case 3:
                    searchDestination(integerArrayList, filter);
                    break;
                case 4:
                    searchDate(integerArrayList, filter);
                    break;
                case 5:
                    searchPrice(integerArrayList, filter);
                    break;
                case 6:
                    searchTime(integerArrayList, filter);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong number");

            }
        }
    }

    public void print() throws IOException {
        System.out.println("Available flights:");
        for (int i = 0; i <flightfile.length()/SIZE_R; i++) {
            System.out.println(printFlight(i));
        }
    }
    public void print(ArrayList<Integer> integerArrayList) throws IOException {
        for (int i = 0; i < integerArrayList.size(); i++) {
           int j= integerArrayList.get(i);
            System.out.println(printFlight(j));
        }
    }

    //*******************************
    private void searchPrice(ArrayList<Integer> flightArrayList1, ArrayList<String> filter) throws IOException {
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
            flightfile.seek(i*SIZE_R+100);
            double price = flightfile.readDouble();
            if (!((min <= price) && (max >= price))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchDate(ArrayList<Integer> flightArrayList1, ArrayList<String> filter) throws IOException {
        filter.add("date");
        String date = Check.checkDate();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(date.equals(readfix(i,60)))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchDestination(ArrayList<Integer> flightArrayList1, ArrayList<String> filter) throws IOException {
        filter.add("destination");
        System.out.println("Enter destination:");
        String destination = input.nextLine();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(destination.equals(readfix(i,40)))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchOrigin(ArrayList<Integer> flightArrayList1, ArrayList<String> filter) throws IOException {
        filter.add("origin");
        System.out.println("Enter origin:");
        String origin = input.nextLine();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(origin.equals(readfix(i,20)))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchId(ArrayList<Integer> flightArrayList1, ArrayList<String> filter) throws IOException {
        filter.add("id");
        System.out.println("Enter id:");
        String id = input.nextLine();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(id.equals(readfix(i,0)))) {
                flightArrayList1.remove(i);
                i--;
            }
        }
        print(flightArrayList1);
    }

    private void searchTime(ArrayList<Integer> flightArrayList1, ArrayList<String> filter) throws IOException {
        filter.add("Time");
        String time = Check.checkTime();
        for (int i = 0; i < flightArrayList1.size(); i++) {
            if (!(time.equals(readfix(i,80)))) {
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
