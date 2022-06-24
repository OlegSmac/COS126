public class TrinomialDP {
    public static long trinomial(int n, int k){
        long[][] dp = new long[n+1][n+2];
        dp[0][0] = 1;
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if (j > i) {
                    dp[i][j] = 0;
                }
                else {
                    if (j == 0) {
                        dp[i][0] = dp[i - 1][0] + (2 * dp[i - 1][j + 1]);
                    }
                    else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1];
                    }
                }
            }
        }
        return dp[n][Math.abs(k)];
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
