import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class IdTickets {
    ArrayList<IdTicket> idTicketArrayList = new ArrayList<>();
    RandomAccessFile idTicketFile;
    int number;

    {
        try {
            idTicketFile = new RandomAccessFile("idTicket.dat","rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //****************
    private static IdTickets obj = new IdTickets();

    private IdTickets() {
    }

    public static IdTickets getIdTickets() {
        return obj;
    }
    //*******************************************************
    public void stiringOnFile(int atribiut, int record, String s)throws IOException {
        //System.out.println(((record*SIZE_R)+atribiut));
        idTicketFile.seek(((record*44)+atribiut));
        idTicketFile.writeChars(fixWrite(s));
    }

    private String fixWrite(String s)  {
        if(s.length()>10){
            return s.substring(0,10);
        } else if (s.length()<10) {
            int n=10-s.length();
            for (int i = 0; i < n; i++) {
                s+=" ";
            }
        }
        return s;
    }
    public void intinfile(int atribiut,int record,int a) throws IOException{
        idTicketFile.seek(((record*44)+atribiut));
        idTicketFile.writeInt(a);
    }
    public boolean findticket(String name)throws IOException{
        for (int i = 0; i <idTicketFile.length()/44; i++) {
            if(readfix(i,0).equals(name)){
                number=i;
                return true;
            }
        }
        return false;
    }
    public String readfix(int i,int atribiut ) throws IOException{
        idTicketFile.seek((i*44)+atribiut);
        String name="";
        for (int j = 0; j < 10; j++) {
            name+= idTicketFile.readChar();
        }
        return name.trim();
    }
    public void addTicket(IdTicket idTicket)throws IOException{
        int n= (int) (idTicketFile.length()/44);
        stiringOnFile(0,n,idTicket.getIdTicket());
        intinfile(20,n,idTicket.getNumberofuser());
        stiringOnFile(24,n,idTicket.getIdFlight());
    }

    public void remove() throws IOException {
        for (int i = number+1; i <idTicketFile.length()/44 ; i++) {
            idTicketFile.seek(i*44);
            stiringOnFile(0,i-1,readfix(i,0));
            idTicketFile.seek(i*44+108);
            intinfile(20,i-1,idTicketFile.readInt());
            stiringOnFile(40,i-1,readfix(i,40));
        }
        idTicketFile.setLength(idTicketFile.length()-44);
    }
}
