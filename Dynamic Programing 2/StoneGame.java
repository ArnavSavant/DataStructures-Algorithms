public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int total = 0;
        // int n = piles.length;
        for (int x : piles) {
            total += x;
        }
        // int dp[][] = new int[n][n];
        // int alice = recurison(0, n - 1, piles);
        // int alice = memorization(0, n - 1, piles, dp);
        int alice = tabulation(piles);  
        int bob = total - alice;
        return alice > bob;
    }

    public int recurison(int l, int r, int piles[]) {
        if (l > r) {
            return 0;
        }
        int noOfElements = r - l + 1;
        int left = 0;
        int right = 0;
        if (noOfElements % 2 == 0) {
            left = piles[l];
            right = piles[r];
        }
        return Math.max(left + recurison(l + 1, r, piles), right + recurison(l, r - 1, piles));
    }

    public int memorization(int l, int r, int piles[], int dp[][]) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int noOfElements = r - l + 1;
        int left = 0;
        int right = 0;
        if (noOfElements % 2 == 0) {
            left = piles[l];
            right = piles[r];
        }
        return dp[l][r] = Math.max(left + memorization(l + 1, r, piles, dp), right + memorization(l, r - 1, piles, dp));
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
