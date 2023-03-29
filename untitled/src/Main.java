public class Main {
    public static void main(String[] args) {
        Users users=new Users();
        while (true){
           int n= users.menu1();
           switch (n){
               case 1:
                   n=users.singIn();
                   switch (n){
                       case 1:
                          n= users.userMenu();
                          switch (n){
                              case 1:
                                  users.changePassword();
                                  break;

                          }
                           break;
                       case 2:
                          n= users.adminMenu();
                           break;
                   }
                   break;
               case 2:
                  users.singUp();

                  break;
               default:
                   System.out.println("Wrong number");
           }


        }
    }
}