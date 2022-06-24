public class Divisors {
    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == b) {
            return a;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static int lcm(int a, int b){
        if (gcd(a, b) == 0) {
            return 0;
        }
        return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }
    public static boolean areRelativelyPrime(int a, int b){
        return gcd(a, b) == 1;
    }
    public static int totient(int n){
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if (areRelativelyPrime(i, n)) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
