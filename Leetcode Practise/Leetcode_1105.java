import java.util.Arrays;

public class Leetcode_1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return tabulation(books, shelfWidth);
    }

    public int tabulation(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth)
                    break;
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n];
    }
}