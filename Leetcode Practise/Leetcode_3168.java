public class Leetcode_3168 {
    public int minimumChairs(String s) {
        int maxChairs = Integer.MIN_VALUE;
        int currChairs = 0;
        for (char x : s.toCharArray()) {
            if (x == 'E') {
                currChairs++;
            } else {
                currChairs--;
            }
            maxChairs = Math.max(maxChairs, currChairs);
        }
        return maxChairs;
    }
}
