public class Ramanujan {
    public static boolean isRamanujan(long n) {
        int k = 0;
        for (long i = 1; i < Math.cbrt(n/2.0); i++) {
            long i_1 = i * i * i;
            long j = (long) Math.cbrt(n - i_1);
            long j_1 = j * j * j;

            if (i_1 + j_1 == n) {
                k += 1;
            }
            if (k == 2) {
                break;
            }
        }
        return k == 2;
    }

    public static void main(String[] args) {
        long answer = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(answer));
    }
}
