public class Inversions {
    public static long count(int[] a) {
        int res = 0;
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
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        int i = 1;
        while (k != 0) {
            if (res[i] > res[i - 1]) {
                int tmp = res[i];
                res[i] = res[i - 1];
                res[i - 1] = tmp;
                k--;
            }
            i++;
            if (i == n) {
                i = 1;
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
