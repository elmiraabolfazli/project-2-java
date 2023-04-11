public class Main {
    public static void main(String[] args) {
        Users users=new Users();
        Flights flights=Flights.getFlights();
        flights.flightInitialize();
        Admin admin=new Admin();
        while (true){
           int n= Menu.menu1();
           switch (n){
               case 1:
                   n=users.singIn();
                   switch (n){
                       case 1:
                           while (n!=0){
                          n= Menu.userMenu();
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
                                  users.charge();
                                  break;
                              case 5:
                                  users.ticketCancellation(flights.flightArrayList);
                                  break;
                              case 6:
                                  users.print();
                              case 0:
                                  break;
                              default:
                                  System.out.println("Wrong number");


                          }}
                           break;
                       case 2:
                           while (n!=0){
                          n= Menu.adminMenu();
                          switch (n){
                              case 1:
                                  admin.add();
                                  break;
                              case 2:
                                  admin.update();
                                  break;
                              case 3:
                                  admin.remove();
                                  break;
                              case 4:
                                  flights.print(flights.flightArrayList);
                                  break;
                              case 0:
                                  break;
                              default:
                                  System.out.println("Wrong number");
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