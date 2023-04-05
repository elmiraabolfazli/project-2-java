import java.util.ArrayList;
import java.util.Scanner;

public class Flights {


     public ArrayList<Flight> flightArrayList=new ArrayList<>();
     private int numberOfFlight=10;
   private Scanner input =new Scanner(System.in);
     public void flightInitialize (){
         Flight flight =new Flight("w.1","Yazd","Kerman","1402/2/20","3:30",700000,40);
         flightArrayList.add(flight);
        flight=new Flight("w.2","Yazd","Tehran","1402/3/30","5:45",800000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.3","Ahvaz","Kerman","1402/12/2","6:30",900000,20);
         flightArrayList.add(flight);
         flight=new Flight("w.4","Shiraz","Tabriz","1402/3/30","5:45",800000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.5","Mashhad","Ahvaz","1402/2/21","3:30",700000,40);
         flightArrayList.add(flight);
         flight=new Flight("w.6","Tehran","yazd","1402/7/3","5:45",800000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.7","Tabriz","Shiraz","1402/1/2","6:30",900000,20);
         flightArrayList.add(flight);
         flight=new Flight("w.8","Ahvaz","Mashhad","1402/11/30","5:45",800000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.9","Isfahan","Fars","1402/11/2","6:30",900000,20);
         flightArrayList.add(flight);
         flight=new Flight("w.10","Semnan","Golestan","1402/1/30","5:45",800000,66);
         flightArrayList.add(flight);
     }
     public void searchFlightTicket(){
         ArrayList<Flight> flightArrayList1=new ArrayList<>();
         flightArrayList1=flightArrayList;
         int n=1;
         while (n!=0){
            n=searchFlightTicketFilters();
         switch (n){
             case 1:
                 System.out.println("Enter id:");
                 String id=input.nextLine();
                 id=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                  if(!(id.equals(flightArrayList1.get(i).getId())))
                  {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 2:
                 System.out.println("Enter origin:");
                 String origin=input.nextLine();
                 origin=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( !(origin.equals(flightArrayList1.get(i).getOrigin())))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 3:
                 System.out.println("Enter Destination:");
                 String Destination=input.nextLine();
                 Destination=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( !(Destination.equals(flightArrayList1.get(i).getDestination())))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 4:
                 System.out.println("Enter Date:");
                 String Date=input.nextLine();
                 Date=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( !(Date.equals(flightArrayList1.get(i).getDate())))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 5:
                 System.out.println("Enter Price rang:");
                 System.out.println("Min");
                 long min =input.nextLong();
                 System.out.println("Max");
                 long max =input.nextLong();
                 if(min>max){
                     System.out.println("Wrong rang");
                     break;
                 }
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     long price= (long) flightArrayList1.get(i).getPrice();
                     if(!((min<=price)&&(max>=price)))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             default:

         }}}
     private int searchFlightTicketFilters(){
         System.out.println("Choose filter");
         System.out.println("Your filter:");
         System.out.println("1-Id");
         System.out.println("2-Origin");
         System.out.println("3-" +
                 "");
         System.out.println("4-Date");
         System.out.println("5-Price");
         System.out.println("0-sing out");
         return input.nextInt();
     }
     public void print(){
         for (int i = 0; i < flightArrayList.size(); i++) {
             System.out.println(flightArrayList.get(i));
         }
     }
    public void print(ArrayList<Flight> flightArrayList1){
        for (int i = 0; i < flightArrayList1.size(); i++) {
            System.out.println(flightArrayList1.get(i));
        }
    }
    public void add(){
         boolean t=false;
        String id="";
         while (t==false){
        System.out.println("Enter flight id");
         id=input.nextLine();
         t=checkId(id);}
        System.out.println("Enter origin");
        String orgin="";
         orgin=input.nextLine();
        String destination="";
        while (t==true){
        System.out.println("Enter destination ");
        t=false;
         destination=input.nextLine();
        if (destination.equals(orgin)){t=true;}
        }
        String date=checkDate();
        String time=checkTime();
        System.out.println("Enter Price");
        long price=input.nextLong();
        System.out.println("Enter seats");
        int seats=input.nextInt();
        Flight flight=new Flight(id,orgin,destination,date,time,price,seats);
        flightArrayList.add(flight);
    }
    public void remove(){
        System.out.println("Enter the id");
        String id=input.nextLine();
        for (int i = 0; i < flightArrayList.size(); i++) {
            if (id.equals(flightArrayList.get(i).getId())){
                flightArrayList.remove(i);
            }}}
    public void update(){
         int n=1;
         boolean t=false;
        System.out.println("Enter the id");
        String id=input.nextLine();
        for (int i = 0; i < flightArrayList.size(); i++) {
            if (id.equals(flightArrayList.get(i).getId())){
                while (n!=0){
                    n=updateMenue();
                    switch (n){
                        case 1:
                            while (t==false){
                                System.out.println("Enter flight id");
                                id=input.nextLine();
                                t=checkId(id);}
                            flightArrayList.get(i).setId(input.nextLine());
                            t=false;
                            break;
                        case 2:
                            String origin="";
                            while (t==false){
                                System.out.println("Enter origin");
                                t=true;
                                 origin=input.nextLine();
                                origin=input.nextLine();
                                if (origin.equals(flightArrayList.get(i).getDestination())){t=false;}
                            }
                            flightArrayList.get(i).setOrigin(origin);
                            t=false;
                            break;
                        case 3:
                            String Destination ="";
                            while (t==false){
                                System.out.println("Enter Destination");
                                t=true;
                                Destination=input.nextLine();
                                Destination=input.nextLine();
                                if (Destination.equals(flightArrayList.get(i).getOrigin())){t=false;}
                            }
                            flightArrayList.get(i).setOrigin(Destination);
                            t=false;
                            break;
                        case 4:
                            flightArrayList.get(i).setDate(checkDate());
                            break;
                        case 5:
                            flightArrayList.get(i).setTime(checkTime());
                            break;
                        case 6:
                            flightArrayList.get(i).setPrice(input.nextLong());
                            break;
                        case 7:
                            flightArrayList.get(i).setSeats(input.nextInt());
                            break;
                        default:

                    }
                }
            }}

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
        return input.nextInt();
    }
    public boolean checkId(String id){
        for (int i = 0; i < flightArrayList.size(); i++) {
            if (id.equals(flightArrayList.get(i).getId())){
                System.out.println("Id is");
                return false;
    }} return true;
     }
     public String checkDate(){
         int month=0;
         boolean t=false;
         while(t==false) {
             t=true;
             System.out.println("Enter the month");
             month = input.nextInt();
             if(month>12){t=false;}
         }
         int day=0;
         while(t==true) {
             t=false;
             System.out.println("Enter the day");
             day = input.nextInt();
             if(day>30){t=true;}
         }
         return "1402/"+ Integer.toString(month)+"/"+ Integer.toString(day);
     }
     public String checkTime(){
         int hour=0;
         boolean t=false;
         while (t==false){
             t=true;
             System.out.println("Enter hour");
             hour=input.nextInt();
             if (hour>24){t=false;}
         }
         int minutes=0;
         while (t==true){
             t=false;
             System.out.println("Enter minutes");
             minutes=input.nextInt();
             if (minutes>60){t=false;}
         }
         return Integer.toString(hour)+":"+Integer.toString(minutes);
     }
}
