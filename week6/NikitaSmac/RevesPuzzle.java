public class RevesPuzzle {
    private static long getK(long n) {
        double k = n + 1 - Math.sqrt(2 * n + 1);
        return Math.round(k);
    }

    private static void hanoi(long n, long k, String fr, String x, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, fr, to, x);
        System.out.println("Move disc " + (n + k) + " from " + fr + " to " + to);
        hanoi(n - 1, k, x, fr, to);
    }

    private static void solution(long n, String fr, String x1, String x2, String to) {
        if (n == 0) return;
        long k = getK(n);
        solution(k, fr, to, x2, x1);
        hanoi(n - k, k, fr, x2, to);
        solution(k, x1, fr, x2, to);
    }

    public static void main(String[] args) {
        long x = Integer.parseInt(args[0]);
        solution(x,"A","B","C","D");
    }
}
