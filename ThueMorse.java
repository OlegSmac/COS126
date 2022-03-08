import java.util.Scanner;

public class ThueMorse {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[][] matrix = new boolean[n][n];
        matrix[0][0] = true;
        double x = 1.0;
        for (int j = 0; j < n; j++) {
            if ((j + 1.0) == Math.pow(2.0, (x))) {
                int k = (j + 1) / 2 - 1;
                int point = j;
                while (k >= 0) {
                    matrix[point][0] = !matrix[k][0];
                    k--;
                    point--;
                }
                x += 1.0;
            }
        }
        for(int i = 0; i < n; i++) {
            x = 1.0;
            for (int j = 1; j < n; j++) {
                if ((j + 1.0) == Math.pow(2.0, (x))) {
                    int k = (j + 1) / 2 - 1;
                    int point = j;
                    while (k >= 0) {
                        matrix[i][point] = !matrix[i][k];
                        k--;
                        point--;
                    }
                    x += 1.0;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]) System.out.print("+ ");
                else System.out.print("- ");
            }
            System.out.println();
        }
    }
}