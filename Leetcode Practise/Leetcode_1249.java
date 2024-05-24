public class Leetcode_1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuffer sb = new StringBuffer(s);
        int open = 0;
        int close = 0;
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == '(') {
                open++;
                i++;
            } else if (sb.charAt(i) == ')') {
                if (close + 1 > open) {
                    sb.deleteCharAt(i);
                } else {
                    close++;
                    i++;
                }
            } else {
                i++;
            }
        }
        open = 0;
        close = 0;
        i = sb.length() - 1;
        while (i >= 0) {
            if (sb.charAt(i) == '(') {
                if (open + 1 > close) {
                    sb.deleteCharAt(i);
                } else {
                    open++;
                }
            } else if (sb.charAt(i) == ')') {
                close++;
            }
            i--;
        }
        return sb.toString();
    }
}
