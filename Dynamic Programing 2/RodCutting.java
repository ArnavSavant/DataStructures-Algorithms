import java.util.Arrays;

public class RodCutting {
    public int cutRod(int price[], int n) {
        // return recursion(price, n, n - 1);
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memorization(price, n, n - 1, dp);
    }

    public int recursion(int price[], int length, int ind) {
        if (ind == 0) {
            return length * price[0];
        }
        int cut = Integer.MIN_VALUE;
        if (ind + 1 <= length) {
            cut = price[ind] + recursion(price, length - ind - 1, ind);
        }
        int notCut = 0 + recursion(price, length, ind - 1);
        return Math.max(cut, notCut);
    }

    public int memorization(int price[], int length, int ind, int[][] dp) {
        if (ind == 0) {
            return length * price[0];
        }
        if (dp[ind][length] != -1) {
            return dp[ind][length];
        }
        int cut = Integer.MIN_VALUE;
        if (ind + 1 <= length) {
            cut = price[ind] + memorization(price, length - ind - 1, ind, dp);
        }
        int notCut = 0 + memorization(price, length, ind - 1, dp);
        return dp[ind][length] = Math.max(cut, notCut);
    }

    public int tabulation(int price[], int n) {
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = price[0] * i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + 1 <= j) {
                    dp[i][j] = Math.max(dp[i][j - i - 1] + price[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][n];
    }
}