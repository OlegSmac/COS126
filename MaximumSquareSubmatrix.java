public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int res = 0;
        int prev = 0;
        int rows = a.length, cols = rows > 0 ? a[0].length : 0;
        int[] dp = new int[cols];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (a[i - 1][j - 1] == 1) {
                    int tmp = dp[j];
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                    res = Math.max(dp[j], res);
                    prev = tmp;
                }
                else {
                    dp[j] = 0;
                }
                StdOut.print(dp[j] + " ");
            }
            StdOut.println();
        }
        return res;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        int res = size(a);
        StdOut.println(res);
    }
}
