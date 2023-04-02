import java.util.ArrayList;
import java.util.Scanner;

public class User {
private String username;
private String password;
private long charch=0;
public ArrayList<Flight> bookingFlight=new ArrayList<>();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getCharch() {
        return charch;
    }

    public void setCharch(long charch) {
        this.charch = charch;
    }
}
