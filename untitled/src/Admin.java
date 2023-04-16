import java.util.Scanner;

public class Admin {
    Flights flights=Flights.getFlights();
    private Scanner input =new Scanner(System.in);
    //**************************************
    private Flight checkId(String id){
        Flights flights=Flights.getFlights();
        for (int i = 0; i < flights.flightArrayList.size(); i++) {
            if (id.equals(flights.flightArrayList.get(i).getId())){
                return flights.flightArrayList.get(i);
            }} return null;
    }
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
            flight= checkId(id);
            if(flight!=null){
                System.out.println("Flight "+id+" is exist");
            }
        }
        System.out.println("Enter origin");
        String origin=input.nextLine();
        System.out.println("Enter destination ");
        String destination=input.nextLine();
        String date=Check.checkDate();
        String time=Check.checkTime();
        double price=Check.checkPrice();
        int seats=Check.checkSeats();
        System.out.println("Flight "+id+" add");
        flight=new Flight(id,origin,destination,date,time,price,seats,seats);
        flights.flightArrayList.add(flight);
    }
    public void remove(){
        System.out.println("Enter the id");
        String id=input.nextLine();
        Flight flight= checkId(id);
        if (flight!=null ){
            if (flight.getSeats()==flight.getTotalCapacity()){
            flights.flightArrayList.remove(flight);
            System.out.println("Flight "+id+" removed");}
            else {
                System.out.println("Flight "+id+" is reserved");
            }
        } else {
            System.out.println("Id does not exist");
        }
    }
    public void update(){
       int n=1;
        System.out.println("Enter the id");
        String id=input.nextLine();
        Flight flight= checkId(id);
        if (flight!=null){
            if(flight.getSeats()==flight.getTotalCapacity()){
            while (n!=0){
                n= updateMenue();
                switch (n){
                    case 1:
                        updateId(flight);
                         id=flight.getId();
                        System.out.println("Flight "+id+" update");
                        break;
                    case 2:
                        System.out.println("Enter origin");
                        flight.setOrigin(input.nextLine());
                        System.out.println("Flight "+id+" update");
                        break;
                    case 3:
                        System.out.println("Enter Destination");
                        flight.setDestination(input.nextLine());
                        System.out.println("Flight "+id+" update");
                        break;
                    case 4:
                        flight.setDate(Check.checkDate());
                        System.out.println("Flight "+id+" update");
                        break;
                    case 5:
                        flight.setTime(Check.checkTime());
                        System.out.println("Flight "+id+" update");
                        break;
                    case 6:
                        flight.setPrice(Check.checkPrice());
                        System.out.println("Flight "+id+" update");
                        break;
                    case 7:
                      int seats= Check.checkSeats();
                       flight.setSeats(seats);
                        flight.setTotalCapacity(seats);
                        System.out.println("Flight "+id+" update");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Wrong number");
                }
            }}else {
                System.out.println("Flight "+id+" is reserved");}
        } else  {
            System.out.println("Id does not exist");
        }
    }
    private void updateId(Flight flight) {
        String id;
        System.out.println("Enter flight id");
        id=input.nextLine();
        if (checkId(id)==null){
            flight.setId(id);
        }else {
            System.out.println("Id is repetitive");
        }
    }
    public int updateMenue(){
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
}
