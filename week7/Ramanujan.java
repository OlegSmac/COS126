public class Ramanujan {
    public static boolean isRamanujan(long n) {
        int k = 0;
        for (long i = 1; i < Math.cbrt(n/2.0); i++) {
            long i3 = i * i * i;
            long j = (long) Math.cbrt(n - i3);
            long j3 = j * j * j;

            if (i3 + j3 == n) {
                k += 1;
            }
            if (k == 2) {
                break;
            }
        }
        return k == 2;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
