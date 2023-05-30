import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Flights flights = Flights.getFlights();
        try {
            flights.flightInitialize();
            while (true) {
                Menu.menu1();
            }
        }catch(IOException e){
            System.out.println("end");
        }
    }
    
}