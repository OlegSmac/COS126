public class Huntingtons {
    public static int maxRepeats(String dna) {
        int res = 0;
        String s = "CAG";
        for (int i = 0; i < dna.length() - 2; i++) {
            int j = i;
            while (i < dna.length() - 2 && dna.substring(i, i + 3).equals(s)) {
                i += 3;
            }
            res = Math.max(res, (i - j) / s.length());
        }
        return res;
    }

    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace(System.lineSeparator(), "");
        s = s.replace("\t", "");
        return s;
    }

    public static String diagnose(int maxRepeats) {
        String res = "";
        if ((maxRepeats >= 0 && maxRepeats <= 9) || (maxRepeats >= 181))  {
            res = "not human";
        }
        else if (maxRepeats >= 10 && maxRepeats <= 35) {
            res = "normal";
        }
        else if (maxRepeats >= 36 && maxRepeats <= 39) {
            res = "high risk";
        }
        else if (maxRepeats >= 40 && maxRepeats <= 180) {
            res = "Huntington's";
        }
        return res;
    }

    public static void main(String[] args) {
        In file = new In(args[0]);
        String str = file.readAll();
        str = removeWhitespace(str);
        int max = maxRepeats(str);
        StdOut.println("max repeats = " + max);
        StdOut.println(diagnose(max));
    }
}
