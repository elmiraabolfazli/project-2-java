/**
 * This class has an arraylist from flight class to remove,ets
 * @author Fatemeh Abolfazli
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Flights {
     public ArrayList<Flight> flightArrayList= new ArrayList<>();
   private Scanner input =new Scanner(System.in);
   private static Flights obj= new Flights();
   private Flights(){}
    public static Flights getFlights(){
       if(obj==null){
           obj=new Flights();
       }
       return obj;
    }
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
            n=Menu.searchFlightTicketFilters(filter);
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
    public void print(ArrayList<Flight> flightArrayList){
        System.out.println("Available flights:");
        for (int i = 0; i < flightArrayList.size(); i++) {
            System.out.println(flightArrayList.get(i));
        }
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
