import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); // 'm' is number of indices, that I must return
        int n = 6;
        int[] w;
        w = new int[n]; // 'w' is array, that was given by condition
        for(int i = 0; i < n; i++){
            int x = in.nextInt();
            w[i] = x;
        }
        int[] sums;
        sums = new int[w.length];
        sums[0] = w[0];
        for(int i = 1; i < w.length; i++){
            sums[i] = sums[i-1] + w[i];
        }

        Random random = new Random();
        for(int i = 0; i < m; i++) {
            int target = random.nextInt(sums[sums.length-1]);
            int low_ind = 0;
            int high_ind = sums.length - 1;
            while(low_ind <= high_ind) {
                int mid_ind = low_ind + (high_ind - low_ind) / 2;
                if (sums[mid_ind] <= target) low_ind = mid_ind + 1;
                else high_ind = mid_ind - 1;
            }
            System.out.print((low_ind + 1) + " ");
        }
    }
}
