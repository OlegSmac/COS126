public class Birthday {
    public static void main(String[] args){
        int days = Integer.parseInt(args[0]);
        int experimentCount = Integer.parseInt(args[1]);
        int[] m = new int[days];//m[i] - number of experiments, that have duplicate on i'th person
        for(int i = 0; i < experimentCount; i++) {
            boolean[] check = new boolean[days];
            for (int j = 0; j < days; j++) {
                int x = (int) (Math.random() * days);
                if (check[x]) {
                    m[j]++;
                    break;
                }
                else {
                    check[x] = true;
                }
            }
        }
        double sum = 0;
        for(int i = 0; i < m.length; i++){
            sum += m[i]*1.0 / experimentCount;
            System.out.println(i+1 + " " + m[i] + " " + sum);
            if(sum >= 0.5){
                break;
            }
        }
    }
}
