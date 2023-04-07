import java.util.ArrayList;
public class User {
private String username;
private String password;
private double charge = (double) 0;
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

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
