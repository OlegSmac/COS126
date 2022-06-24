public class Inversions {
    public static long count(int[] a) {
        long answer = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static int[] generate(int n, long k) {
        int[] result = new int[n];
        for (int i = 0; i < n && k > 0; i++) {
            long idx = Math.max(i, n - 1 - k);
            resylt[(int) idx] = n - 1 - i;
            k -= n - 1 - idx;
        }
        int x = 0;
        for (int j = 0; j < n; j++) {
            if (answer[j] == 0) {
                answer[j] = x;
                x++;
            }
        }
        return answer;
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

