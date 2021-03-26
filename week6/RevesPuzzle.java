public class RevesPuzzle {
    private static long findK(long n) {
        double k = n + 1 - Math.sqrt(2 * n + 1);
        return Math.round(k);
    }

    private static void hanoi(long n, long k, String from, String tmp, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, tmp);
        System.out.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, tmp, from, to);
    }

    private static void puzzle(long n, String from, String tmp1, String tmp2, String to) {
        if (n == 0) return;
        long k = findK(n);
        puzzle(k, from, to, tmp2, tmp1);
        hanoi(n - k, k, from, tmp2, to);
        puzzle(k, tmp1, from, tmp2, to);
    }

    public static void main(String[] args) {
        long n = Integer.parseInt(args[0]);
        puzzle(n,"A","B","C","D");
    }
}
