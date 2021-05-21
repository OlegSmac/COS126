import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private final String n, c;
    private final int v;

    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) {
            throw new IllegalArgumentException();
        }
        n = name;
        v = value;
        c = category;
    }

    public String getName() {
        return n;
    }

    public int getValue() {
        return v;
    }

    public String getCategory() {
        return c;
    }

    public int compareTo(Bar that) {
        if (v < that.v) {
            return -1;
        }
        else if (v == that.v) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",    22674, "East Asia");
        bars[0] = new Bar("Cairo",      19850, "Middle East");
        bars[0] = new Bar("Delhi",      27890, "South Asia");
        bars[0] = new Bar("Dhaka",      19633, "South Asia");
        bars[0] = new Bar("Mexico City",21520, "Latin America");
        bars[0] = new Bar("Mumbai",     22120, "South Asia");
        bars[0] = new Bar("Osaka",      20409, "East Asia");
        bars[0] = new Bar("Sao Paulo",  21698, "Latin America");
        bars[0] = new Bar("Shanghai",   25779, "East Asia");
        bars[0] = new Bar("Tokyo",      38194, "East Asia");

        Arrays.sort(bars);
    }
}
