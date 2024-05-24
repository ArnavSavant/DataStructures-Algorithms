public class Leetcode_3106 {
    public String getSmallestString(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == 'a' || k == 0) {
                sb.append(c);
            } else {
                int min = Math.min(Math.abs(c - 'a'), 26 - Math.abs(c - 'a'));
                if (min <= k) {
                    sb.append('a');
                    k = k - min;
                } else {
                    sb.append((char) (c - k));
                    k = 0;
                }
            }
        }
        return sb.toString();
    }
}
