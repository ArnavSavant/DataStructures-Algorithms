public class Leetcode_3210 {
    public String getEncryptedString(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt((i + k) % s.length()));
        }
        return sb.toString();
    }
}
