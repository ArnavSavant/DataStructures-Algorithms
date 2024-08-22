public class StoneGame2 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        if (n == 1) {
            return piles[0];
        }
        int prefix[] = new int[n];
        prefix[0] = piles[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + piles[i];
        }
        // return recursion(piles, prefix, 1, 0, true);
        int[][][] dp = new int[n][n][2];
        return memorization(piles, prefix, dp, 1, 0, true);
    }

    public int recursion(int piles[], int prefix[], int m, int ind, boolean isAlice) {
        if (ind >= piles.length) {
            return 0;
        }
        int ans = isAlice ? 0 : Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m && ind + x - 1 < piles.length; x++) {
            int currScore = 0;
            if (ind == 0) {
                currScore = prefix[ind + x - 1];
            } else {
                currScore = prefix[ind + x - 1] - prefix[ind - 1];
            }
            int next = recursion(piles, prefix, Math.max(m, x), ind + x, !isAlice);
            if (isAlice) {
                ans = Math.max(ans, currScore + next);
            } else {
                ans = Math.min(ans, next);
            }
        }
        return ans;
    }

    public int memorization(int[] piles, int[] prefix, int[][][] dp, int m, int ind, boolean isAlice) {
        if (ind >= piles.length) {
            return 0;
        }
        if (dp[ind][m][isAlice ? 1 : 0] != 0) {
            return dp[ind][m][isAlice ? 1 : 0];
        }
        int ans = isAlice ? 0 : Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m && ind + x - 1 < piles.length; x++) {
            int currScore = 0;
            if (ind == 0) {
                currScore = prefix[ind + x - 1];
            } else {
                currScore = prefix[ind + x - 1] - prefix[ind - 1];
            }
            int next = memorization(piles, prefix, dp, Math.max(m, x), ind + x, !isAlice);
            if (isAlice) {
                ans = Math.max(ans, currScore + next);
            } else {
                ans = Math.min(ans, next);
            }
        }
        dp[ind][m][isAlice ? 1 : 0] = ans;
        return ans;
    }
}