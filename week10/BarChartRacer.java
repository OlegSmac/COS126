public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        In in = new In(args[0]);
        int k = Integer.parseInt(args[1]);
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String source = in.readLine();
        BarChart bars = new BarChart(title, xAxisLabel, source);
        String b = in.readLine();
        for (int i = 0; i < k; i++) {
            bars.reset();
            b = in.readLine();
            int n = Integer.parseInt(b);
            for (int j = 0; j <= n; j++) {
                String s = in.readLine();
                if (!in.hasNextLine() || s.length() == 0) {
                    break;
                }
                String[] data = s.split(",");
                String year = data[0];
                String name = data[1];
                String country = data[2];
                int value = Integer.parseInt(data[3]);
                String category = data[4];

                bars.setCaption(year);
                bars.add(name, value, category);
            }
            bars.draw();
            StdDraw.pause(100);
        }
    }
}
/*
                StdOut.print("y = " + year);
                StdOut.print(" n = " + name);
                StdOut.print(" c = " + country);
                StdOut.print(" v = " + value);
                StdOut.println(" cat = " + category);
                */