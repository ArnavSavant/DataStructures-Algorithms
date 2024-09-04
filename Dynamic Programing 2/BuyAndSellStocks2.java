public class BuyAndSellStocks2 {
    public int maxProfit(int[] prices) {

        // return recursion(0, prices, false);

        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // for (int i = 0; i < n; i++) {
        //     dp[i][0] = -1;
        //     dp[i][1] = -1;
        // }
        // return memorization(0, prices, 0, dp);

        return tabulation(prices);
    }

    public int recursion(int ind, int[] prices, boolean isHolding) {
        if (ind == prices.length) {
            return 0;
        }
        if (isHolding) {
            int holding = recursion(ind + 1, prices, true);
            int selling = prices[ind] + recursion(ind + 1, prices, false);
            return Math.max(holding, selling);
        } else {
            int buying = recursion(ind + 1, prices, true) - prices[ind];
            int notBuying = recursion(ind + 1, prices, false);
            return Math.max(buying, notBuying);
        }
    }

    public int memorization(int ind, int[] prices, int isHolding, int[][] dp) {
        if (ind == prices.length) {
            return 0;
        }
        if (dp[ind][isHolding] != -1) {
            return dp[ind][isHolding];
        }
        if (isHolding == 1) {
            int holding = memorization(ind + 1, prices, 1, dp);
            int selling = prices[ind] + memorization(ind + 1, prices, 0, dp);
            dp[ind][isHolding] = Math.max(holding, selling);
        } else {
            int buying = memorization(ind + 1, prices, 1, dp) - prices[ind];
            int notBuying = memorization(ind + 1, prices, 0, dp);
            dp[ind][isHolding] = Math.max(buying, notBuying);
        }
        return dp[ind][isHolding];
    }

    public int tabulation(int prices[]) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
