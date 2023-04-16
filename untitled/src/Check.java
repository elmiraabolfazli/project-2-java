import java.util.Scanner;

public class Check {
    private static Scanner input=new Scanner(System.in);
    public static String checkTime(){
        int hour=0;
        boolean t=false;
        while (t==false){
            t=true;
            System.out.println("Enter hour");
            hour=input.nextInt();
            if (hour>24 ||hour<0){
                System.out.println("Wrong number");t=false;}
        }
        int minutes=0;
        while (t==true){
            t=false;
            System.out.println("Enter minutes");
            minutes=input.nextInt();
            input.nextLine();
            if (minutes>60||minutes<0){System.out.println("Wrong number");t=true;}
        }
        return Integer.toString(hour)+":"+Integer.toString(minutes);
    }
    public static String checkDate(){
        int month=0;
        boolean t=false;
        while(t==false) {
            t=true;
            System.out.println("Enter the month");
            month = input.nextInt();
            if(month>12||month<1){System.out.println("Wrong number");t=false;}
        }
        int day=0;
        while(t==true) {
            t=false;
            System.out.println("Enter the day");
            day = input.nextInt();
            input.nextLine();
            if(day>30||day<1){System.out.println("Wrong number");t=true;}
        }
        return "1402/"+ Integer.toString(month)+"/"+ Integer.toString(day);
    }
    public static double checkPrice(){
        double price=0;
        boolean t=false;
        while(t==false) {
            t=true;
            System.out.println("Enter the price");
            price = input.nextDouble();
            input.nextLine();
            if(price<0){System.out.println("Wrong number");t=false;}
        }
        return price;
    }
    public static int checkSeats() {
        int seats=0;
        boolean t=false;
        while(t==false) {
            t=true;
            System.out.println("Enter the seats");
            seats = input.nextInt();
            input.nextLine();
            if(seats<0){System.out.println("Wrong number");t=false;}
        }
        return seats;
    }
}
