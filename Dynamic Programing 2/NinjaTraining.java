import java.util.Arrays;

public class NinjaTraining {
    public int maximumPoints(int arr[][], int N) {

        // recursion
        int ans1 = recursion(arr, N - 1, 3);

        // memorization
        int dp[][] = new int[N][4];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans2 = memorization(arr, N - 1, 3, dp);

        // tabulation
        int ans3 = tabulation(arr, N);

        // space optimization
        int ans4 = spaceOptimization(arr, N);

        return ans1 & ans2 & ans3 & ans4;
    }

    public int recursion(int arr[][], int day, int last) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    max = Math.max(max, arr[0][i]);
                }
            }
            return max;
        }

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = arr[day][task] + recursion(arr, day - 1, task);
                max = Math.max(max, point);
            }
        }
        return max;
    }

    public int memorization(int arr[][], int day, int last, int dp[][]) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    max = Math.max(max, arr[0][i]);
                }
            }
            return dp[day][last] = max;
        }

        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = arr[day][task] + memorization(arr, day - 1, task, dp);
                max = Math.max(max, point);
            }
        }
        return dp[day][last] = max;
    }

    public int tabulation(int arr[][], int N) {
        int dp[][] = new int[N][3];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]));
    }

    public int spaceOptimization(int arr[][], int N) {
        int prev0 = arr[0][0];
        int prev1 = arr[0][1];
        int prev2 = arr[0][2];
        for (int i = 1; i < N; i++) {
            int curr0 = arr[i][0] + Math.max(prev1, prev2);
            int curr1 = arr[i][1] + Math.max(prev0, prev2);
            int curr2 = arr[i][2] + Math.max(prev0, prev1);
            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
        }
        return Math.max(prev0, Math.max(prev1, prev2));
    }

    public static void main(String[] args) {
        NinjaTraining obj = new NinjaTraining();
        int arr[][] = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
        System.out.println(obj.maximumPoints(arr, 3));
    }
}
