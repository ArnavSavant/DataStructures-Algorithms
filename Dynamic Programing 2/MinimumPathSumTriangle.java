import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPathSumTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return recursion(0, 0, triangle);

        // int dp[][] = new int[triangle.size()][];
        // for (int i = 0; i < triangle.size(); i++) {
        // dp[i] = new int[i + 1];
        // Arrays.fill(dp[i], Integer.MAX_VALUE);
        // }
        // return memorization(0, 0, dp, triangle);

        return spaceOptimized(triangle);
    }

    public int recursion(int row, int col, List<List<Integer>> triangle) {
        if (row == triangle.size()) {
            return 0;
        }
        int right = recursion(row + 1, col + 1, triangle);
        int down = recursion(row + 1, col, triangle);

        return triangle.get(row).get(col) + Math.min(right, down);
    }

    public int memorization(int row, int col, int[][] dp, List<List<Integer>> triangle) {
        if (row == triangle.size()) {
            return 0;
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int right = memorization(row + 1, col + 1, dp, triangle);
        int down = memorization(row + 1, col, dp, triangle);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(right, down);
    }

    public int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i + 1];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }
        return minCost;
    }

    public int spaceOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        int[] dp = new int[n];

        prev[0] = triangle.get(0).get(0);
        dp[0] = prev[0];
        for (int i = 1; i < n; i++) {
            dp[0] = triangle.get(i).get(0) + prev[0];
            for (int j = 1; j < i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(prev[j - 1], prev[j]);
            }
            dp[i] = triangle.get(i).get(i) + prev[i - 1];
            for (int k = 0; k <= i; k++) {
                prev[k] = dp[k];
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        return minCost;
    }

    public void display(int arr[]) {
        for (int x : arr) {
            System.out.print(x + "  ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MinimumPathSumTriangle obj = new MinimumPathSumTriangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int result = obj.minimumTotal(triangle);
        System.out.println("Minimum Path Sum: " + result);
    }
}
