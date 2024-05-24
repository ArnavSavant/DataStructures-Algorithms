public class Leetcode_1544 {
    public String makeGood(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == (char) (s.charAt(1) + 32) || (s.charAt(1) == (char) (s.charAt(0) + 32))) {
                return "";
            } else {
                return s;
            }
        }
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        while (sb.length() > 0 && i < sb.length() - 1) {
            if (sb.charAt(i) == (char) (sb.charAt(i + 1) + 32) || sb.charAt(i + 1) == (char) (sb.charAt(i) + 32)) {
                sb.delete(i, i + 2);
                if (i != 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
