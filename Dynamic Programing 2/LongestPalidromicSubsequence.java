public class LongestPalidromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        // return recursion(s, rev, n - 1, n - 1);

        // int dp[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return memorization(s, rev, n - 1, n - 1, dp);

        return spaceOptimized(s, rev, n);
    }

    public int recursion(String s, String rev, int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (s.charAt(ind1) == rev.charAt(ind2)) {
            return 1 + recursion(s, rev, ind1 - 1, ind2 - 1);
        }
        return 0 + Math.max(recursion(s, rev, ind1 - 1, ind2), recursion(s, rev, ind1, ind2 - 1));
    }

    public int memorization(String s, String rev, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (s.charAt(ind1) == rev.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + memorization(s, rev, ind1 - 1, ind2 - 1, dp);
        }
        return dp[ind1][ind2] = Math.max(memorization(s, rev, ind1 - 1, ind2, dp),
                memorization(s, rev, ind1, ind2 - 1, dp));
    }

    public int tabulation(String s, String rev, int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public int spaceOptimized(String s, String rev, int n) {
        int prev[] = new int[n + 1];
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[j] = 1 + prev[j - 1];
                } else {
                    dp[j] = Math.max(prev[j], dp[j - 1]);
                }
            }
            for (int k = 1; k <= n; k++) {
                prev[k] = dp[k];
            }
        }
        return dp[n];
    }
}
