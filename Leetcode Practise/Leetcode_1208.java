public class Leetcode_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0;
        int j = 0;
        int currCost = 0;
        int maxLength = 0;
        int n = s.length();
        while (j < n) {
            currCost = currCost + Math.abs(t.charAt(j) - s.charAt(j));
            if (currCost <= maxCost) {
                maxLength = Math.max(maxLength, j - i + 1);
            } else {
                while (currCost > maxCost) {
                    currCost = currCost - Math.abs(t.charAt(i) - s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
}
