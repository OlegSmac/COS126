public class Ramanujan {
    private static long n3(long n) {
        return n * n * n;
    }

    public static boolean isRamanujan(long n) {
        int k = 0;
        long last = 0;
        long c = Math.round(Math.pow(n, 1.0/3));
        for (int i = 1; i <= c; i++) {
            long j = Math.round(Math.pow(n - Math.pow(i, 3), 1.0/3));
            if (n3(i) + n3(j) == n && i != last) {
                k += 1;
                last = j;
            }
            if (k == 2) break;
        }
        if (k == 2) return true;
        else return false;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
