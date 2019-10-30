package reservation;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ReservationSystem {


    ReservationHashMap lookupTable = new ReservationHashMap();
    ReservationBinarySearchTree schedule = new ReservationBinarySearchTree();

    private static String getRandomString() {
        String candidates = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random randomGenerator = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(candidates.charAt(randomGenerator.nextInt(26)));
        }
        return sb.toString();

    }

    public static void runExperiment(int numAdditions, int numTrials) {
        List<ReservationHashMap> tables = new LinkedList<>();

        for (int trial = 0; trial < numTrials; trial++) {
            tables.add(new ReservationHashMap());
        }

        for (int i = 0; i < numAdditions; i++) {
            System.out.print(tables.get(0).getLoadFactor());
            for (ReservationHashMap table : tables) {
                int probeCount = table.put(new Reservation(0, getRandomString()));
                System.out.print(", " + probeCount);
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        ReservationSystem openTable = new ReservationSystem();
        openTable.addReservation(new Reservation(11, "Sam"));

        System.out.println(openTable.getNextAvailableTime(9)); // Should print 9
        System.out.println(openTable.getNextAvailableTime(10.5)); // Should print 12
        System.out.println(openTable.getNextAvailableTime(13)); // Should print 13
        System.out.println("---");
        System.out.println(openTable.schedule.toString());
        // Should print
        // 11.0 Sam

        System.out.println("----");
        System.out.println(openTable.addReservation(new Reservation(13.5, "Anna"))); //Should print true
        System.out.println(openTable.getNextAvailableTime(14)); // Should print 14.5
        System.out.println(openTable.addReservation(new Reservation(14, "Layla"))); // Should print false
        System.out.println(openTable.addReservation(new Reservation(openTable.getNextAvailableTime(14), "Layla"))); // Should print true
        System.out.println(openTable.getNextAvailableTime(14)); // Should print 15.5
        System.out.println("----");



        System.out.println(openTable.schedule.toString());
        // Should print
        // 11.0 Sam
        // 13.5 Anna
        // 14.5 Layla

        System.out.println("----");
        System.out.println(openTable.schedule.indexedToString());

        // Should print
        // 0 11.0 Sam
        // 1 13.5 Anna
        // 2 14.5 Layla


        System.out.println("----");
        System.out.println(openTable.lookupTable.getLoadFactor()); // Should print 0.002932551319648094
        openTable.addReservation(new Reservation(15, "Layla"));
        openTable.addReservation(new Reservation(15, "Layla"));
        openTable.addReservation(new Reservation(15, "Layla"));
        openTable.addReservation(new Reservation(15, "Layla"));
        System.out.println(openTable.lookupTable.getLoadFactor()); // Should print 0.002932551319648094

        System.out.println("----");
        // runExperiment(1022, 30);

    }

    public double getNextAvailableTime(double t) {
        Reservation r = schedule.findPredecessor(t);
        double endTime;
        if (r == null) {
            endTime = t;
        } else {
            endTime = r.endTime();
        }

        return getNextAvailableNonOverlapping(Math.max(endTime, t)); // Return either the current time, or an hour after the previous reservation, whichever is later
    }

    public double getNextAvailableNonOverlapping(double t) {
        //Find the next appt
        Reservation r = schedule.findSuccessor(t);
        // If I can schedule return current time
        if (r == null || r.validWith(t)) {
            return t;

        }
        // Otherwise return the nextAvailable time starting at r's end time
        // Modify this to call getNextAvailableNonOverlapping recursively
        return 0;
    }

    public boolean addReservation(Reservation r) {
        boolean added = schedule.insert(r);
        if (added) {
            lookupTable.put(r);
        } else {
            return false;
        }
        return true;
    }

    public Reservation getReservation(String name) {
        return lookupTable.get(name);
    }


}
