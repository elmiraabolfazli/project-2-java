import java.util.Scanner;

public class Users {
    private User[] usersArry= new User[100];
    private int numberOfUser=0;
    Scanner input=new Scanner(System.in);
    Admin admin= new Admin();
    public int menu1(){
        System.out.println("1-Sing in");
        System.out.println("2-Sing up");
       return input.nextInt();
    }
    public void singUp(){
        usersArry[numberOfUser]=new User();
        System.out.println("Enter your username");
        String name=input.nextLine();
        name=input.nextLine();
        usersArry[numberOfUser].setUsername(name);
        System.out.println("Enter your password");
        String password=input.nextLine();
        usersArry[numberOfUser].setPassword(password);
        ++numberOfUser;
    }
    public int singIn(){
        int n=0;
        System.out.println("Enter your username");
        String name=input.nextLine();
        name=input.nextLine();

        if(name.equals("Admin")){
            return admin.singInAdmin();

        }else{
            for (int i = 0; i < numberOfUser; i++) {
                if(usersArry[i].getUsername().equals(name)){
                    System.out.println("Enter your password");
                    String password=input.nextLine();
                    if(usersArry[i].getPassword().equals(password)){i=numberOfUser; return 1;}
                     else {
                        System.out.println("Wrong password!");
                        //return 0;
                    }
                }else{
                    System.out.println("Wrong username !");
                    //return 0;
                }

            }
        }
        return n;
    }

}
