import java.util.ArrayList;
import java.util.Scanner;

public class Flights {


     private ArrayList<Flight> flightArrayList=new ArrayList<>();
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
                  if( id.equals(flightArrayList1.get(i).getId())){//print}
                      }else {flightArrayList1.remove(i);i--;}
                 }
                 break;
             case 2:
                 System.out.println("Enter origin:");
                 String origin=input.nextLine();
                 origin=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( origin.equals(flightArrayList1.get(i).getOrigin())){//print}
                     }else {flightArrayList1.remove(i);i--;}
                 }
                 break;
             case 3:
                 System.out.println("Enter Destination:");
                 String Destination=input.nextLine();
                 Destination=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( Destination.equals(flightArrayList1.get(i).getDestination())){//print}
                     }else {flightArrayList1.remove(i);i--;}
                 }
                 break;
             case 4:
                 System.out.println("Enter Date:");
                 String Date=input.nextLine();
                 Date=input.nextLine();
                 for (int i = 0; i < flightArrayList1.size(); i++) {
                     if( Date.equals(flightArrayList1.get(i).getDate())){//print}
                     }else {flightArrayList1.remove(i);i--;}
                 }
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
                     if((min<=price)&&(max>=price)){//print}
                     }else {flightArrayList1.remove(i);i--;}
                 }
                 break;
             default:

         }
             for (int i = 0; i < flightArrayList1.toArray().length; i++) {
                 System.out.println(flightArrayList1.get(i).getId());
             }
         }
     }
     private int searchFlightTicketFilters(){
         System.out.println("Choose filter");
         System.out.println("Your filter:");
         System.out.println("1-Id");
         System.out.println("2-Origin");
         System.out.println("3-Destination");
         System.out.println("4-Date");
         System.out.println("5-Price");
         System.out.println("0-sing out");
         return input.nextInt();
     }
}
