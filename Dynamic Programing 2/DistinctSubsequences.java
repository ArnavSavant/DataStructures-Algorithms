public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // int n = s.length();
        // int m = t.length();
        // return recursion(n - 1, m - 1, s, t);

        // int dp[][] = new int[n][m];
        // for (int i = 0; i < n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return memorization(n - 1, m - 1, s, t, dp);

        // return tabulation(s, t);
        
        return spaceOptimized(s, t);
    }

    public int recursion(int i, int j, String s, String t) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return recursion(i - 1, j - 1, s, t) + recursion(i - 1, j, s, t);
        } else {
            return recursion(i - 1, j, s, t);
        }
    }

    public int memorization(int i, int j, String s, String t, int[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = memorization(i - 1, j - 1, s, t, dp) + memorization(i - 1, j, s, t, dp);
        } else {
            return dp[i][j] = memorization(i - 1, j, s, t, dp);
        }
    }

    public int tabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
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
