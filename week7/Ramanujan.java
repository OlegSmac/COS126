public class Ramanujan {
    public static boolean isRamanujan(long n) {
        int k = 0;
        long c = Math.round(Math.pow(n, 1.0/3));
        for (int i = 1; i <= c; i++) {
            long j = Math.round(Math.pow(n - Math.pow(i, 3), 1.0/3));
            if (Math.pow(i, 3) + Math.pow(j, 3) == n && i < j) {
                k += 1;
            }
            if (k == 2) break;
        }
        return k == 2;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
