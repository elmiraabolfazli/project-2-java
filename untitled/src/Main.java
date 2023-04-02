public class Main {
    public static void main(String[] args) {
        Users users=new Users();
        Flights flights=new Flights();
        flights.flightInitialize();
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
                              case 2:
                                  flights.searchFlightTicket();
                                  break;
                              case 3:
                                  users.booking(flights.flightArrayList);
                                  break;
                              case 4:
                                  users.church();
                                  break;
                              case 5:


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