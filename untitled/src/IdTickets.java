import java.util.ArrayList;

public class IdTickets {
    ArrayList<IdTicket> idTicketArrayList = new ArrayList<>();
    //****************
    private static IdTickets obj = new IdTickets();

    private IdTickets() {
    }

    public static IdTickets getIdTickets() {
        return obj;
    }
}
