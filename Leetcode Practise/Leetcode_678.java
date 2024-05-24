public class Leetcode_678 {
    public boolean checkValidString(String s) {
        int openMin = 0;
        int openMax = 0;
        for (char x : s.toCharArray()) {
            if (x == '(') {
                openMin++;
                openMax++;
            } else if (x == ')') {
                openMin--;
                openMax--;
            } else {
                openMin--;
                openMax++;
            }
            if (openMax < 0) {
                return false;
            }
            if (openMin < 0) {
                openMin = 0;
            }
        }
        return openMin == 0;
    }
}
