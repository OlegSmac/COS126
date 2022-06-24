public class ActivationFunction {
    public static double heaviside(double x){
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        if (x < 0) {
            return 0.0;
        } else if (x == 0){
            return 0.5;
        } else {
            return 1.0;
        }
    }
    public static double sigmoid(double x){
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else return 1 / (1 + Math.pow(Math.E, -x));
    }
    public static double tanh(double x){
        if(Double.isNaN(x)) return Double.NaN;
        if(x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE){
            return 1.0;
        }
        if(x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE){
            return -1.0;
        }
        else return (Math.pow(Math.E, x) - Math.pow(Math.E, -x)) / (Math.pow(Math.E, x) + Math.pow(Math.E, -x));
    }
    public static double softsign(double x){
        if(Double.isNaN(x)) return Double.NaN;
        if(x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE){
            return 1.0;
        }
        if(x == Double.NEGATIVE_INFINITY){
            return -1.0;
        }
        else return x / (1 + Math.abs(x));
    }
    public static double sqnl(double x){
        if(Double.isNaN(x)) return Double.NaN;
        if(x <= -2) return -1.0;
        else if(x > -2 && x < 0) return x + x * x / 4;
        else if(x >= 0 && x < 2) return x - x * x / 4;
        else return 1.0;
    }
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ")" + " = " + heaviside(x));
        System.out.println("sigmoid(" + x + ")" + " = " + sigmoid(x));
        System.out.println("tanh(" + x + ")" + " = " + tanh(x));
        System.out.println("softsign(" + x + ")" + " = " + softsign(x));
        System.out.println("sqnl(" + x + ")" + " = " + sqnl(x));
    }
}
