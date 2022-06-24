public class Minesweeper {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]); int m = Integer.parseInt(args[1]); int k = Integer.parseInt(args[2]);
        int[][] miner = new int[n][m];
        int[][] dpp = {{0, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}, {-1, 0}, {0, 1}, {0, 0}, {-1, -1}};
        if(k > n * m){
            k = n * m;
        }
        for(int i = 0; i < k; i++){
            int w = 0; int h = 0;
            do {
                w = (int) (Math.random() * n);
                h = (int) (Math.random() * m);
            }
            while (miner[w][h] < 0);
            miner[w][h] = -1;
            for(int[] dp : dpp){
                int wn = w + dp[0];
                int hn = h + dp[1];
                if(wn >= 0 && wn < n && hn >= 0 && hn < m && miner[wn][hn] >= 0){
                    miner[wn][hn]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (miner[i][j] < 0) {
                    System.out.print("*");
                } else {
                    System.out.print(miner[i][j]);
                }
                if (j < m - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
