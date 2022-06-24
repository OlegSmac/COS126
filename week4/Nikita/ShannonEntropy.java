public class ShannonEntropy {
    public static void main(String[] args) {
        int k = 0;
        int m = Integer.parseInt(args[0]);
        double[] p = new double[m];
        while (!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            if (num >= 1 && num <= m) {
                p[num - 1] += 1.0;
                k += 1; // all numbers
            }
        }
        double sum = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != 0) {
                p[i] = p[i] / k;
                p[i] = -p[i] * (Math.log(p[i]) / Math.log(2));
                sum += p[i];
            }
        }
        StdOut.printf("%.4f\n", sum);
    }
}