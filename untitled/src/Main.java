public class Main {
    public static void main(String[] args) {
        Flights flights = Flights.getFlights();
        flights.flightInitialize();
        while (true) {
            Menu.menu1();
        }
    }
}