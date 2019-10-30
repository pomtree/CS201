package reservation;

public class ReservationBinarySearchTree {


    private Reservation data;
    private double key;

    private ReservationBinarySearchTree left;
    private ReservationBinarySearchTree right;

    public boolean insert(Reservation r) {
        return insert(r.time, r);
    }


    public Reservation findPredecessor(double t) {


        // If the key is t, return data


        // If key is larger than t
        // Then the predecessor must be in the left branch
        // Recurse on left if possible, otherwise return null


        // If the key is smaller than t
        // Find the predecessor in the right
        // If the return value is not null, return it
        // Otherwise there were no predecessors in the right tree
        // so the current node must be the predecessor, so return that


        return null;

    }

    public Reservation findSuccessor(double t) {


        // If the key is t, return data
        if (key == t) {
            return data;
        }

        if (key < t) {
            if (right == null) {
                return null;
            }
            return right.findSuccessor(t);

        }

        if (key > t) {
            if (left == null) {
                return data;
            } else {
                Reservation r = left.findSuccessor(t);
                if (r != null) {
                    return r;
                } else {
                    return data;
                }
            }
        }


        return null;

    }

    public Reservation findMin() {
        if (left == null) {
            return data;
        }
        return left.findMin();
    }

    public Reservation findMax() {
        if (right == null) {
            return data;
        }
        return right.findMax();
    }


    public boolean insert(double k, Reservation r) {
        if (this.data == null) {
            this.data = r;
            this.key = k;
            return true;
        }


        if (!r.validWith(key)) {
            return false;
        }

        if (k < this.key) {
            if (left == null) {
                left = new ReservationBinarySearchTree();
            }
            return left.insert(k, r);
        } else {
            if (right == null) {
                right = new ReservationBinarySearchTree();
            }
            return right.insert(k, r);
        }

    }


    public void visitInOrder(ReservationVisitor rv) {
        if (left != null) {
            left.visitInOrder(rv);
        }
        rv.visit(data);
        if (right != null) {
            right.visitInOrder(rv);
        }
    }

    public String toString() {
        ReservationToStringVisitor visitor = new ReservationToStringVisitor();
        visitInOrder(visitor);
        return visitor.toString();
    }

    public String indexedToString() {
        ReservationIndexedToStringVisitor visitor = new ReservationIndexedToStringVisitor();
        visitInOrder(visitor);
        return visitor.toString();
    }


}
