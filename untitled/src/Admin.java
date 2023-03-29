import java.util.Scanner;

public class Admin {
   private Scanner input=new Scanner(System.in);
    public int singInAdmin (){
        System.out.println("Enter your password");
        String password=input.nextLine();
        if(password.equals("Admin")){
            return 2;
        }
        else {
            System.out.println("Wrong password");return 0;}
    }


}
