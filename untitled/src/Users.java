import java.util.Scanner;

public class Users {
    int menu1(){
        System.out.println("1-Sing in");
        System.out.println("2-Sing up");
        Scanner input=new Scanner(System.in);
       return input.nextInt();
    }
}
