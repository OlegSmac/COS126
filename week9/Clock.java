public class Clock {
    private int hour;
    private int min;

    public Clock(int h, int m) {
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException();
        }
        if (m < 0 || m > 59) {
            throw new IllegalArgumentException();
        }
        hour = h;
        min = m;
    }

    public Clock(String s) { //проблема сложения int
        String[] time = s.split(":");
        if (time[0].length() == 2) {
            hour = Integer.parseInt(time[0]);
        }
        else {
            throw new IllegalArgumentException();
        }
        if (time[1].length() == 2) {
            min = Integer.parseInt(time[1]);
        }
        else {
            throw new IllegalArgumentException();
        }
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException();
        }
        if (min < 0 || min > 59) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        String h = String.valueOf(hour);
        String m = String.valueOf(min);
        if (hour < 10) {
            h = "0" + h;
        }
        if (min < 10) {
            m = "0" + m;
        }
        return h + ":" + m;
    }

    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) {
            return true;
        }
        else if (hour == that.hour) {
            if (min < that.min) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public void tic() {
        if (hour < 0 && min < 0) {
            throw new IllegalArgumentException();
        }
        if (min < 59) {
           min += 1;
        }
        else if (min == 59) {
            if (hour < 23) {
                hour += 1;
                min = 0;
            }
            else if (hour == 23) {
                hour = 0;
                min = 0;
            }
        }
    }

    public void toc(int delta) {
        if (hour < 0 || min < 0 || delta < 0) {
            throw new IllegalArgumentException();
        }
        min += delta;
        if (min > 59) {
            int h = min / 60;
            min = min % 60;
            hour += h;
        }
        if (hour > 23) {
            hour = hour % 24;
        }
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Clock clock = new Clock(h, m);
        Clock clock2 = new Clock("12:45");
        StdOut.println(clock);
        StdOut.println(clock2.toString());
        StdOut.println(clock.isEarlierThan(clock2));
        clock.tic();
        clock.toc(121);
        StdOut.println(clock.toString());
    }
}
