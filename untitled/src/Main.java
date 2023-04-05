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
                           while (n!=0){
                          n= users.userMenu();
                          switch (n) {
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
                                  users.ticketCancellation(flights.flightArrayList);
                                  break;
                              case 6:
                                  users.print();


                          }}
                           break;
                       case 2:
                           while (n!=0){
                          n= users.adminMenu();
                          switch (n){
                              case 1:
                                  flights.add();
                                  break;
                              case 2:
                                  flights.update();
                                  break;
                              case 3:
                                  flights.remove();
                                  break;
                              case 4:
                                  flights.print();
                                  break;
                          }
                           }
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