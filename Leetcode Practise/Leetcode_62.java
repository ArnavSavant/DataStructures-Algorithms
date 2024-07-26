import java.util.Arrays;

public class Leetcode_62 {
    public int uniquePaths(int m, int n) {
        return spaceOptimization(m, n);
    }

    public int recursion(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }

        int left = recursion(row, col - 1);
        int up = recursion(row - 1, col);

        return left + up;
    }

    public int memorization(int row, int col, int dp[][]) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int left = memorization(row, col - 1, dp);
        int up = memorization(row - 1, col, dp);

        return dp[row][col] = (left + up);
    }

    public int tabulation(int row, int col) {
        int dp[][] = new int[row][col];
        dp[0][0] = 1;
        for (int k = 0; k < row; k++) {
            dp[k][0] = 1;
        }
        for (int k = 0; k < col; k++) {
            dp[0][k] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public int spaceOptimization(int row, int col) {
        int dp[] = new int[col];
        int prev[] = new int[col];

        Arrays.fill(prev, 0);
        for (int i = 0; i < row; i++) {
            dp[0] = 1;
            for (int j = 1; j < col; j++) {
                dp[j] = dp[j - 1] + prev[j];
            }
            prev = dp;
        }
        return dp[col - 1];
    }
}
