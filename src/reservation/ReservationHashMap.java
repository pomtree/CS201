package reservation;

public class ReservationHashMap {

    int count = 0;
    private Reservation[] table = new Reservation[1023];

    public int put(Reservation r) {
        int hashCode = r.name.hashCode();
        int i = 0;
        while (table[getIndexForProbe(hashCode, i)] != null) {
            i = i + 1;
        }
        table[getIndexForProbe(hashCode, i)] = r;
        count++;
        return i + 1;

    }

    private int expand() {
        Reservation[] oldTable = table;
        table = new Reservation[table.length * 2];
        count = 0;
        int totalProbes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                totalProbes += put(oldTable[i]);
            }
        }
        return totalProbes;
    }

    private int getIndexForProbe(int hashCode, int i) {
        //Currently doing Linear Probing
        return Math.abs((hashCode + i) % table.length);
    }

    public double getLoadFactor() {
        return count / (double) table.length;
    }

    public Reservation get(String name) {
        int hashCode = name.hashCode();
        int i = 0;
        while (table[getIndexForProbe(hashCode, i)] != null) {
            if (table[getIndexForProbe(hashCode, i)].name.equals(name)) {
                return table[getIndexForProbe(hashCode, i)];
            }
            i = i + 1;
        }
        return null;
    }
}
