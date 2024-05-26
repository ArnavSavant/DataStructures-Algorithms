// import java.util.Arrays;

public class Leetcode_552 {
    public int checkRecord(int n) {

        // recursive code
        // int ans[] = new int[1];
        // solve(n, 0, 0, 0, ans);
        // return ans[0];

        // top-down dp or memorisation
        // int dp[][][] = new int[n][2][3];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < 2; j++) {
        // Arrays.fill(dp[i][j], -1);
        // }
        // }
        // return solve(n, 0, 0, 0, dp);

        return 0;
    }

    // public void solve(int n, int i, int a, int l, int ans[]) { // recursive code
    // if (i == n) {
    // ans[0] = ans[0] + 1;
    // return;
    // }
    // if (a < 1) {
    // solve(n, i + 1, a + 1, 0, ans); // absent
    // }
    // if (l < 2) {
    // solve(n, i + 1, a, l + 1, ans); // late
    // }
    // solve(n, i + 1, a, 0, ans); // present
    // }

    // public int solve(int n, int i, int a, int l, int[][][] dp) {
    // int mod = 1000000007;
    // if (i == n) {
    // return 1;
    // }
    // if (dp[i][a][l] != -1) {
    // return dp[i][a][l];
    // }

    // dp[i][a][l] = 0;

    // dp[i][a][l] = (dp[i][a][l] + solve(n, i + 1, a, 0, dp)) % mod; // present

    // if (a < 1) {
    // dp[i][a][l] = (dp[i][a][l] + solve(n, i + 1, a + 1, 0, dp)) % mod; // absent
    // }

    // if (l < 2) {
    // dp[i][a][l] = (dp[i][a][l] + solve(n, i + 1, a, l + 1, dp)) % mod; // late
    // }

    // return dp[i][a][l];
    // }
}
