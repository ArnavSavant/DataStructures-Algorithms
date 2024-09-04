public class Leetcode_115 {
    public int numDistinct(String s, String t) {
        return spaceOptimized(s, t);
    }

    public int spaceOptimized(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[] = new int[m + 1];
        int prev[] = new int[m + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            prev[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = prev[j - 1] + prev[j];
                } else {
                    dp[j] = prev[j];
                }
            }
            for (int k = 0; k <= m; k++) {
                prev[k] = dp[k];
            }
        }
        return dp[m];
    }
}
