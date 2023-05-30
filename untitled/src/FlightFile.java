import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FlightFile {
protected RandomAccessFile flightfile;

    {
        try {
            flightfile = new RandomAccessFile("Flight.dat","rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected final int SIZE_R=116;
int number;

    public void stiringOnFile(int atribiut, int record, String s)throws IOException {
        //System.out.println(((record*SIZE_R)+atribiut));
        flightfile.seek(((record*SIZE_R)+atribiut));
        flightfile.writeChars(fixWrite(s));
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
    public void doubleinfile(int atribiut,int record,double charge) throws IOException{
        flightfile.seek(((record*SIZE_R)+atribiut));
        flightfile.writeDouble(charge);
    }
    public void intinfile(int atribiut,int record,int a) throws IOException{
        flightfile.seek(((record*SIZE_R)+atribiut));
        flightfile.writeInt(a);
    }
    public boolean findflight(String name)throws IOException{
        for (int i = 0; i < flightfile.length()/SIZE_R; i++) {
            if(readfix(i,0).equals(name)){
                number=i;
                return true;
            }
        }
        return false;
    }
    public String readfix(int i,int atribiut ) throws IOException{
        flightfile.seek((i*SIZE_R)+atribiut);
        String name="";
        for (int j = 0; j < 10; j++) {
            name+= flightfile.readChar();
        }
        return name.trim();
    }
    public void addFlight(Flight flight)throws IOException{
        int n= (int) (flightfile.length()/SIZE_R);
        stiringOnFile(0,n,flight.getId());
        stiringOnFile(20,n,flight.getOrigin());
        stiringOnFile(40,n,flight.getDestination());
        stiringOnFile(60,n,flight.getDate());
        stiringOnFile(80,n,flight.getTime());
        doubleinfile(100,n,flight.getPrice());
        intinfile(108,n,flight.getSeats());
        intinfile(112,n, flight.getTotalCapacity());
    }

    public void remove() throws IOException {
        for (int i = number+1; i <flightfile.length()/SIZE_R ; i++) {
            flightfile.seek(i*SIZE_R);
            stiringOnFile(0,i-1,readfix(i,0));
            stiringOnFile(20,i-1,readfix(i,20));
            stiringOnFile(40,i-1,readfix(i,40));
            stiringOnFile(60,i-1,readfix(i,60));
            stiringOnFile(80,i-1,readfix(i,80));
            flightfile.seek(i*SIZE_R+100);
            doubleinfile(100,i-1,flightfile.readDouble());
            flightfile.seek(i*SIZE_R+108);
            intinfile(108,i-1,flightfile.readInt());
            flightfile.seek(i*SIZE_R+112);
            intinfile(112,i-1,flightfile.readInt());

        }
        flightfile.setLength(flightfile.length()-SIZE_R);
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String printFlight(int i) throws IOException {
        return "Flight{" +
                "id='" + readfix(i,0) + '\'' +
                ", origin='" + readfix(i,20) + '\'' +
                ", destination='" + readfix(i,40) + '\'' +
                ", date='" + readfix(i,60) + '\'' +
                ", time='" + readfix(i,80) + '\'' +
                ", price=" + flightfile.readDouble() +
                ", seats=" + flightfile.readInt() +
                '}';
    }
}
