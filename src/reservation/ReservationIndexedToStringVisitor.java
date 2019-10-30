package reservation;

public class ReservationIndexedToStringVisitor implements ReservationVisitor {

    StringBuilder sb = new StringBuilder();
    // Create count

    @Override
    public void visit(Reservation t) {
        // Prepend count
        sb.append(t.toString());
        sb.append("\n");

        // Increment count
    }

    public String toString() {
        return sb.toString();
    }
}
