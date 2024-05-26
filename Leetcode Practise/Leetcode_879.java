import java.util.Arrays;

public class Leetcode_879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][] = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        int mod = 1000000007;
        for (int k = 1; k <= group.length; k++) {
            int g = group[k - 1];
            int p = profit[k - 1];
            for (int i = n; i >= g; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - g][Math.max(j - p, 0)]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[i][minProfit]) % mod;
        }
        return sum;
    }
}
