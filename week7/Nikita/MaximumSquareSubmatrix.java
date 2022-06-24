public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int result = 0;
        int pr = 0;
        int rows = a.length, cols = rows > 0 ? a[0].length : 0;
        int[] dp = new int[cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (a[i - 1][j - 1] == 1) {
                    int tmp = dp[j];
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pr) + 1;
                    result = Math.max(dp[j], result);
                    pr = tmp;
                }
                else {
                    dp[j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] x = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = StdIn.readInt();
            }
        }
        int result = size(x);
        StdOut.println(result);
    }
}
