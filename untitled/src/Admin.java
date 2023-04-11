import java.util.Scanner;

public class Admin {
    Flights flights=Flights.getFlights();
    private Scanner input =new Scanner(System.in);
    public int singInAdmin (){
        System.out.println("Enter your password");
        String password=input.nextLine();
        if(password.equals("Admin")){
            return 2;
        }
        else {
            System.out.println("Wrong password");return 0;}
    }
    public void add(){
        Flight flight=new Flight();
        String id="";
        while (flight!=null){
            System.out.println("Enter flight id");
            id=input.nextLine();
            flight=flights.checkId(id);}
        System.out.println("Enter origin");
        String origin=input.nextLine();
        System.out.println("Enter destination ");
        String destination=input.nextLine();
        String date=flights.checkDate();
        String time=flights.checkTime();
        System.out.println("Enter Price");
        double price=input.nextDouble();
        System.out.println("Enter seats");
        int seats=input.nextInt();
        input.nextLine();
        System.out.println("Flight "+id+" add");
        flight=new Flight(id,origin,destination,date,time,price,seats);
        flights.flightArrayList.add(flight);
    }
    public void remove(){
        System.out.println("Enter the id");
        String id=input.nextLine();
        Flight flight=flights.checkId(id);
        if (flight!=null){
            flights.flightArrayList.remove(flight);
            System.out.println("Flight "+id+" removed");
        } else {
            System.out.println("Id does not exist");
        }
    }
    public void update(){
       int n=1;
        System.out.println("Enter the id");
        String id=input.nextLine();
        Flight flight=flights.checkId(id);
        if (flight!=null){
            while (n!=0){
                n=Menu.updateMenue();
                switch (n){
                    case 1:
                        System.out.println("Enter flight id");
                        id=input.nextLine();
                        if (flights.checkId(id)==null){
                            flight.setId(id);
                        }else {
                            System.out.println("Id is repetitive");
                        }
                        break;
                    case 2:
                        System.out.println("Enter origin");
                        flight.setOrigin(input.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter Destination");
                        flight.setDestination(input.nextLine());
                        break;
                    case 4:
                        flight.setDate(flights.checkDate());
                        break;
                    case 5:
                        flight.setTime(flights.checkTime());
                        break;
                    case 6:
                        System.out.println("Enter price");
                        flight.setPrice(input.nextDouble());
                        input.nextLine();
                        break;
                    case 7:
                        System.out.println("Enter seats");
                        flight.setSeats(input.nextInt());
                        input.nextLine();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong number");
                }
            }
        } else  {
            System.out.println("Id does not exist");
        }



    }

}
