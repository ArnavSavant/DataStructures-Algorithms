public class MinimumInsertionsToMakeStringPalidrome {
    public int minInsertions(String s) {
        int n = s.length();
        int x = longestPalindromeSubseq(s);
        return n - x;
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        return spaceOptimized(s, rev, n);
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
