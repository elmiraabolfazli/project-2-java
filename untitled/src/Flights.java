import java.util.ArrayList;

public class Flights {


     private ArrayList<Flight> flightArrayList=new ArrayList<>();
     private int numberOfFlight=0;
     public void flightInitialize (){
         Flight flight =new Flight("w.1","Yazd","Kerman","1402/2/20","3:30",700.000,40);
         flightArrayList.add(flight);
        flight=new Flight("w.2","Yazd","Tehran","1402/3/30","5:45",800.000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.3","Ahvaz","Kerman","1402/12/2","6:30",900.000,20);
         flightArrayList.add(flight);
         flight=new Flight("w.4","Shiraz","Tabriz","1402/3/30","5:45",800.000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.5","Mashhad","Ahvaz","1402/2/21","3:30",700.000,40);
         flightArrayList.add(flight);
         flight=new Flight("w.6","Tehran","yazd","1402/7/3","5:45",800.000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.7","Tabriz","Shiraz","1402/1/2","6:30",900.000,20);
         flightArrayList.add(flight);
         flight=new Flight("w.8","Ahvaz","Mashhad","1402/11/30","5:45",800.000,66);
         flightArrayList.add(flight);
         flight=new Flight("w.9","Isfahan","Fars","1402/11/2","6:30",900.000,20);
         flightArrayList.add(flight);
         flight=new Flight("w.10","Semnan","Golestan","1402/1/30","5:45",800.000,66);
         flightArrayList.add(flight);
     }
     public void searchFlightTicket(){


     }
}
