public class Inversions {
    public static long count(int[] a) {
        long res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    res += 1;
                }
            }
        }
        return res;
    }

    public static int[] generate(int n, long k) {
        int[] res = new int[n];

        for (int i = 0; i < n && k > 0; i++) {
            long idx = Math.max(i, n - 1 - k);
            res[(int) idx] = n - 1 - i;
            k -= n - 1 - idx;
        }

        int val = 0;
        for (int j = 0; j < n; j++) {
            if (res[j] == 0) {
                res[j] = val;
                val++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] array = generate(n, k);
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                StdOut.print(array[i] + " ");
            }
            else {
                StdOut.print(array[i]);
            }

        }
    }
}
