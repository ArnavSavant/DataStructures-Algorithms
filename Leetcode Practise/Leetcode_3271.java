public class Leetcode_3271 {
    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        while (ind < n) {
            int hashValue = 0;
            for (int i = ind; i < ind + k; i++) {
                hashValue += s.charAt(i) - 'a' + 1;
            }
            char hashedChar = (char) (hashValue % 26 + 97);
            sb.append(hashedChar);
            ind = ind + k;
        }
        return sb.toString();
    }
}
