public class DeleteOperationsForTwoStrings {
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);

        return word1.length() - lcs + word2.length() - lcs;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        return spaceOptimized(text1, text2, n1, n2);
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
