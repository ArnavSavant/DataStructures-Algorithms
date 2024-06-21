public class Leetcode_198 {
    public int rob(int num[]) {
        int n = num.length;
        if (n == 1) {
            return num[0];
        }
        int x = 0;
        int y = num[0];
        int curr = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int take = num[i];
            if (i > 1) {
                take = take + x;
            }
            int notTake = 0 + y;
            curr = Math.max(take, notTake);
            x = y;
            y = curr;
        }
        return curr;
    }
}
