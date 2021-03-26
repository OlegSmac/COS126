public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        StdDraw.setPenColor(StdDraw.BLUE);
                        StdDraw.filledSquare(0.5 + i, 0.5 + j, 0.5);
                    }
                    else {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.filledSquare(0.5 + i, 0.5 + j, 0.5);
                    }
                }
                if (i % 2 != 0) {
                    if (j % 2 != 0) {
                        StdDraw.setPenColor(StdDraw.BLUE);
                        StdDraw.filledSquare(0.5 + i, 0.5 + j, 0.5);
                    }
                    else {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.filledSquare(0.5 + i, 0.5 + j, 0.5);
                    }
                }
            }
        }
    }
}
