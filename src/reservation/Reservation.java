package reservation;

public class Reservation {

    double time;
    String name;

    public Reservation(double t, String n) {
        time = t;
        name = n;
    }

    public double endTime() {
        return time + 1;
    }


    public boolean validWith(double t) {
        return validWith(t, 1);
    }

    public boolean validWith(double t, double range) {
        if (t == time) {
            return false;
        }
        if (t + range > time && t < time) {
            return false;
        }
        if (time + 1 > t && time < t) {
            return false;
        }
        return true;
    }

    public String toString() {
        return time + " " + name;
    }


}