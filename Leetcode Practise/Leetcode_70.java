public class Leetcode_70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int x = 1;
        int y = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = x + y;
            x = y;
            y = curr;
        }
        return curr;
    }
}
