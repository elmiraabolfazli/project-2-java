import java.util.Scanner;

public class Users {
    private User[] usersArry= new User[100];
    private int numberOfUser=0;
   private Scanner input=new Scanner(System.in);
   private int number=0;
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
                    if(usersArry[i].getPassword().equals(password)){ number=i;i=numberOfUser; return 1;}
                     else {
                        System.out.println("Wrong password!");
                        return 0;
                    }
                }

            }
        }
        return n;
    }

    public int adminMenu(){
        System.out.println("1-Add");
        System.out.println("2-Update");
        System.out.println("3-Remove");
        System.out.println("4-Flight schedules");
        System.out.println("0-Sing out ");
        return input.nextInt();

    }
    public int userMenu(){
        System.out.println("1-Change password");
        System.out.println("2-Search flight tickets");
        System.out.println("3-Booking ticket");
        System.out.println("4-Ticket cancellation");
        System.out.println("5-Booked tickets");
        System.out.println("6-Add charge");
        System.out.println("0-Sing out");
        return input.nextInt();

    }
    public void changePassword(){
        System.out.println("Enter your new password");
        String password=input.nextLine();
        password=input.nextLine();
        usersArry[number].setPassword(password);
    }

}
