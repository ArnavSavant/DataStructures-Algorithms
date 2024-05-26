public class Leetcode_551 {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for (char x : s.toCharArray()) {
            if (x == 'L') {
                l++;
            } else {
                l = 0;
            }
            if (x == 'A') {
                a++;
            }
            if (l >= 3 || a >= 2) {
                return false;
            }
        }
        return true;
    }
}
