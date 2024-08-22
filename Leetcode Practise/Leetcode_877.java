public class Leetcode_877 {
    public boolean stoneGame(int[] piles) {
        int total = 0;
        for (int x : piles) {
            total += x;
        }
        int alice = tabulation(piles);
        int bob = total - alice;
        return alice > bob;
    }

    public int tabulation(int piles[]) {
        int n = piles.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int l = n - 2; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                int noOfElements = r - l + 1;
                int left = 0;
                int right = 0;
                if (noOfElements % 2 == 0) {
                    left = piles[l];
                    right = piles[r];
                }
                dp[l][r] = Math.max(left + dp[l + 1][r], right + dp[l][r - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
