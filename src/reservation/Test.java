package reservation;

public class Test {
    public static void main(String[] args) {
        ReservationBinarySearchTree tree = new ReservationBinarySearchTree();
        tree.insert(new Reservation(1, "a"));
        tree.insert(new Reservation(1.1, "b"));
        tree.insert(new Reservation(1.12, "c"));
        tree.insert(new Reservation(2, "d"));
        tree.insert(new Reservation(3.3, "e"));
        tree.insert(new Reservation(5, "f"));
        System.out.println(tree.findSuccessor(1.1));
        System.out.println(tree.findPredecessor(1.1));
    }
}
