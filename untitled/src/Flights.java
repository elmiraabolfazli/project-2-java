/**
 * This class has an arraylist from flight class to remove,ets
 * @author Fatemeh Abolfazli
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Flights {
     public ArrayList<Flight> flightArrayList=new ArrayList<>();
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
        // flightArrayList1=flightArrayList;
         for (int i = 0; i < flightArrayList.size(); i++) {
             flightArrayList1.add(flightArrayList.get(i));
         }
         int n=1;
         ArrayList<String> filter=new ArrayList<>();
         while (n!=0){
            n=searchFlightTicketFilters(filter);
         switch (n){
             case 1:
                 filter.add("id");
                 System.out.println("Enter id:");
                 String id=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                  if(!(id.equals(flightArrayList1.get(i).getId())))
                  {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 2:
                 filter.add("origin");
                 System.out.println("Enter origin:");
                 String origin=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( !(origin.equals(flightArrayList1.get(i).getOrigin())))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 3:
                 filter.add("destination");
                 System.out.println("Enter destination:");
                 String destination=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( !(destination.equals(flightArrayList1.get(i).getDestination())))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 4:
                 filter.add("date");
                 String date=checkDate();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( !(date.equals(flightArrayList1.get(i).getDate())))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             case 5:
                 filter.add("price");
                 System.out.println("Enter Price rang:");
                 System.out.println("Min");
                 long min =input.nextLong();
                 System.out.println("Max");
                 long max =input.nextLong();
                 input.nextLine();
                 if(min>max){
                     System.out.println("Wrong rang");
                     break;
                 }
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     double price=flightArrayList1.get(i).getPrice();
                     if(!((min<=price)&&(max>=price)))
                     {flightArrayList1.remove(i);i--;}
                 }
                 print (flightArrayList1);
                 break;
             default:
                 System.out.println("Wrong number");

         }}}
     private int searchFlightTicketFilters(ArrayList<String> filter){
         System.out.println("Choose filter");
         System.out.println("Your filter:"+filter);
         System.out.println("1-Id");
         System.out.println("2-Origin");
         System.out.println("3-Destination");
         System.out.println("4-Date");
         System.out.println("5-Price");
         System.out.println("0-sing out");
         int n= input.nextInt();
         input.nextLine();
         return n;
     }
    public void print(ArrayList<Flight> flightArrayList){
        System.out.println("Available flights:");
        for (int i = 0; i < flightArrayList.size(); i++) {
            System.out.println(flightArrayList.get(i));
        }
    }
    public void add(){
        Flight flight=new Flight();
        String id="";
         while (flight!=null){
        System.out.println("Enter flight id");
         id=input.nextLine();
          flight=checkId(id);}
        System.out.println("Enter origin");
        String origin=input.nextLine();
        System.out.println("Enter destination ");
         String destination=input.nextLine();
        String date=checkDate();
        String time=checkTime();
        System.out.println("Enter Price");
        double price=input.nextDouble();
        System.out.println("Enter seats");
        int seats=input.nextInt();
        input.nextLine();
        System.out.println("Flight "+id+" add");
         flight=new Flight(id,origin,destination,date,time,price,seats);
        flightArrayList.add(flight);
    }
    public void remove(){
        System.out.println("Enter the id");
        String id=input.nextLine();
        Flight flight=checkId(id);
            if (flight!=null){
                flightArrayList.remove(flight);
                System.out.println("Flight "+id+" removed");
            } else {
                System.out.println("Id does not exist");
            }
        }
    public void update(){
         int n=1;
        System.out.println("Enter the id");
        String id=input.nextLine();
        Flight flight=checkId(id);
            if (flight!=null){
                while (n!=0){
                    n=updateMenue();
                    switch (n){
                        case 1:
                            System.out.println("Enter flight id");
                            id=input.nextLine();
                            if (checkId(id)==null){
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
                            flight.setDate(checkDate());
                            break;
                        case 5:
                            flight.setTime(checkTime());
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
    public Flight checkId(String id){
        for (int i = 0; i < flightArrayList.size(); i++) {
            if (id.equals(flightArrayList.get(i).getId())){
                return flightArrayList.get(i);
    }} return null;
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
             input.nextLine();
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
             input.nextLine();
             if (minutes>60){t=false;}
         }
         return Integer.toString(hour)+":"+Integer.toString(minutes);
     }
}
