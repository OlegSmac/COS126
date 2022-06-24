public class ThueMorse {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int n1 = (int)(Math.pow(0, 2));
        int x = 0;
        while(n1 < n){
            x++;
            n1 = (int)(Math.pow(2, x));
        }
        boolean[] ThueMorse = new boolean[n1];
        ThueMorse[0] = true;
        int z = 1;
        while(z < n1){
            int mid = (z+1) / 2;
            for (int i = 0; i < mid; i++){
                ThueMorse[mid+i] = !ThueMorse[i];
            }
            z += 2 * mid;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(ThueMorse[i] == ThueMorse[j]){
                    System.out.print("+");
                }
                else {
                    System.out.print("-");
                }
                if(j < n-1){
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}