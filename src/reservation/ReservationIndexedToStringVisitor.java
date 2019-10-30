package reservation;

public class ReservationIndexedToStringVisitor implements ReservationVisitor {

    StringBuilder sb = new StringBuilder();
    // Create count
    int count;

    @Override
    public void visit(Reservation t) {
        sb.append(count + " ");
        sb.append(t.toString());
        sb.append("\n");
        ++count;
        // Increment count
    }

    public String toString() {
        return sb.toString();
    }
}
