
public class Huntingtons {
    public static int maxRepeats(String dna){
        int res = 0;
        String s = "CAG";
        for(int i = 0; i < dna.length() - 2; i++){
            int j = i;
            while(i < dna.length() - 2 && dna.substring(i, i + 3).equals(s)){
                i += 3;
            }
            res = Math.max(res, (i - j) / s.length());
        }
        return res;
    }
    public static String removeWhitespace(String s){
        s = s.replace(" ", "");
        s = s.replace(System.lineSeparator(), "");
        s = s.replace("/t", "");
        return s;
    }
    public static String diagnose(int maxRepeats){
        String res = "";
        if(maxRepeats >= 0 && maxRepeats < 10) {
            res = "not human";
        }
        if(maxRepeats >= 10 && maxRepeats < 36) {
            res = "normal";
        }
        if(maxRepeats >= 36 && maxRepeats < 40) {
            res = "high risk";
        }
        if(maxRepeats >= 40 && maxRepeats <= 180) {
            res = "Huntington’s";
        }
        else {
            res = "not human";
        }
        return res;
    }
    public static void main(String[] args){
        In file = new In(args[0]);
        String x = file.readAll();
        x = removeWhitespace(x);
        int ans = maxRepeats(x);
        System.out.println("max repeats = " + ans);
        System.out.println(diagnose(ans));
    }
}
