public class MatrixMultiplication {
    private static int[][] Init(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        return a;
    }

    public static int[][] mult(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int column = 0; column < b[0].length; column++) {
                int sum = 0;
                for (int j = 0; j < a[i].length; j++) {
                    int num = b[j][column] * a[i][j];
                    sum += num;
                }
                res[i][column] = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int m1 = StdIn.readInt();
        int n1 = StdIn.readInt();
        int[][] a = Init(m1, n1);

        int m2 = StdIn.readInt();
        int n2 = StdIn.readInt();
        int[][] b = Init(m2, n2);

        if (n1 == m2) {
            int[][] res = mult(a, b);
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    StdOut.print(res[i][j] + " ");
                }
                StdOut.println();
            }
        }
        else {
            StdOut.println("It is impossible");
        }
    }
}
