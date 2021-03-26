public class ActivationFunction {
    public static double heaviside(double x) {
        if (x == Double.NaN)  {
            return Double.NaN;
        }
        double h = 0;
        if (x < 0) { h = 0; }
        if (x == 0) { h = 0.5; }
        if (x > 0) { h = 1; }
        return h;
    }

    public static double sigmoid(double x) {
        double sigma = (1/(1 + Math.pow(Math.E, -x)));
        return sigma;
    }

    public static double tanh(double x) {
        if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        if (x == Double.MAX_VALUE) {
            return 1.0;
        }
        if (x == -Double.MAX_VALUE) {
            return -1.0;
        }
        double t = (Math.pow(Math.E, x) - Math.pow(Math.E, -x)) / (Math.pow(Math.E, x) + Math.pow(Math.E, -x));
        return t;
    }

    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        double f = x / (1 + Math.abs(x));
        return f;
    }

    public static double sqnl(double x) {
        if (x == Double.NaN) {
            return Double.NaN;
        }
        if (x == Double.NaN) return x;
        double s = 0;
        if (x <= -2) {
            s = -1;
        }
        if (-2 < x && x < 0) {
            s = x + (Math.pow(x, 2) / 4);
        }
        if (0 <= x && x < 2) {
            s = x - (Math.pow(x, 2) / 4);
        }
        if (x >= 2) {
            s = 1;
        }
        return s;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
