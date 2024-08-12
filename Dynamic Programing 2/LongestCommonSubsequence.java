public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        // return recursion(text1, text2, n1 - 1, n2 - 1);

        // int dp[][] = new int[n1][n2];
        // for (int i = 0; i < n1; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // return memorization(text1, text2, n1 - 1, n2 - 1, dp);

        return tabulation(text1, text2, n1, n2);
    }

    public int recursion(String text1, String text2, int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return 1 + recursion(text1, text2, ind1 - 1, ind2 - 1);
        }
        return 0 + Math.max(recursion(text1, text2, ind1 - 1, ind2), recursion(text1, text2, ind1, ind2 - 1));
    }

    public int memorization(String text1, String text2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + memorization(text1, text2, ind1 - 1, ind2 - 1, dp);
        }
        return dp[ind1][ind2] = Math.max(memorization(text1, text2, ind1 - 1, ind2, dp),
                memorization(text1, text2, ind1, ind2 - 1, dp));
    }

    public int tabulation(String text1, String text2, int n1, int n2) {
        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int spaceOptimized(String text1, String text2, int n1, int n2) {
        int prev[] = new int[n2 + 1];
        int dp[] = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = 1 + prev[j - 1];
                } else {
                    dp[j] = Math.max(prev[j], dp[j - 1]);
                }
            }
            for (int k = 1; k <= n2; k++) {
                prev[k] = dp[k];
            }
        }
        return dp[n2];
    }
}
