public class ColorHSB {
    private final int hue, sat, brig;

    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) {
            throw new IllegalArgumentException();
        }
        if (s < 0 || s > 100) {
            throw new IllegalArgumentException();
        }
        if (b < 0 || b > 100) {
            throw new IllegalArgumentException();
        }
        hue = h;
        sat = s;
        brig = b;
    }

    public String toString() {
        return "(" + hue + ", " + sat + ", " + brig + ")";
    }

    public boolean isGrayscale() {
        if (sat == 0 && brig == 0 || sat == 0 || brig == 0) {
            return true;
        }
        return false;
    }

    public int distanceSquaredTo(ColorHSB that) {
        int res = (int) Math.min(Math.pow(hue - that.hue, 2), Math.pow(360 - Math.abs(hue - that.hue), 2)) +
                (int) Math.pow(sat - that.sat, 2) +
                 (int) Math.pow(brig - that.brig, 2);
        return res;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(h, s, b);
        ColorHSB res = color;
        int min = Integer.MAX_VALUE;
        String res_name = "";
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            h = StdIn.readInt();
            s = StdIn.readInt();
            b = StdIn.readInt();
            ColorHSB color2 = new ColorHSB(h, s, b);
            int num = color.distanceSquaredTo(color2);
            if (num < min) {
                res = color2;
                min = num;
                res_name = name;
            }
        }
        StdOut.print(res_name + " " + res.toString());
    }
}
