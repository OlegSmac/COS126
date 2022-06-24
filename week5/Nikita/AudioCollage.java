public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }

    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        int j = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            b[j] = a[i];
            j++;
        }
        return b;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        return c;
    }

    public static double[] mix(double[] a, double[] b) {
        int len = Math.max(a.length, b.length);
        double[] c = new double[len];
        double first = 0;
        double second = 0;
        for (int i = 0; i < len; i++) {
            if (i < a.length) {
                first = a[i];
            }
            else first = 0;
            if (i < b.length) {
                second = b[i];
            }
            else second = 0;
            c[i] = first + second;
        }
        return c;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        int len = a.length;
        double[] b = new double[len];
        for (int i = 0; i < len; i++) {
            b[i] = a[i * (int) alpha];
        }
        return b;
    }

    public static void main(String[] args) {
        double[] singer = StdAudio.read("singer.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] scratch = StdAudio.read("scratch.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        StdAudio.play(changeSpeed(dialup, 5.0));
        StdAudio.play(merge(scratch, beatbox));
        StdAudio.play(amplify(harp, 3.0));
        StdAudio.play(reverse(singer));
        StdAudio.play(exposure);
        StdAudio.play(reverse(beatbox));
        StdAudio.play(amplify(harp, 3.0));
        StdAudio.play(reverse(exposure));
        StdAudio.play(mix(scratch, harp));
    }
}