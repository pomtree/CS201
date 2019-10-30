package reservation;

public class ReservationToStringVisitor implements ReservationVisitor {

    StringBuilder sb = new StringBuilder();

    @Override
    public void visit(Reservation t) {
        sb.append(t.toString());
        sb.append("\n");
    }

    public String toString() {
        return sb.toString();
    }
}
