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
                           break;
                       case 2:
                           break;
                   }
                   break;
               case 2:
                  users.singUp();
                   break;
           }


        }
    }
}