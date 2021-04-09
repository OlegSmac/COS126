public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    if (i == a.length - 1 || j == a[i].length - 1) {
                        if (res == 0) {
                            res = 1;
                        }
                    }
                    else {
                        int y = i;
                        int x;
                        int k = 1;
                        for (x = j; y < a.length &&
                                x < a[i].length; y++, x++) {
                            k = 0;
                            for (int c1 = i; c1 <= y; c1++) {
                                for (int c2 = j; c2 <= x; c2++) {
                                    if (a[c1][c2] == 0) {
                                        k = -1;
                                        break;
                                    }
                                }
                                if (k == -1) {
                                    k = 1;
                                    break;
                                }
                                k += 1;
                            }
                            if (k > res) { res = k; }
                        }
                    }
                }
            }
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
