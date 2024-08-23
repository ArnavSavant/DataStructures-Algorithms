public class StrangePrinter {
    public int strangePrinter(String s) {
        int n = s.length();
        // return recursion(s, 0, n - 1);
        int dp[][] = new int[n][n];
        return memorization(s, 0, n - 1, dp);
    }

    public int recursion(String s, int l, int r) {
        if (l == r) {
            return 1;
        }
        if (l > r) {
            return 0;
        }
        int i = l + 1;
        while (i <= r && s.charAt(i) == s.charAt(l)) {
            i++;
        }
        if (i == r + 1) {
            return 1;
        }
        int ans1 = 1 + recursion(s, i, r);
        int ans2 = Integer.MAX_VALUE;
        for (int j = i; j <= r; j++) {
            if (s.charAt(j) == s.charAt(l)) {
                ans2 = Math.min(ans2, recursion(s, i, j - 1) + recursion(s, j, r));
            }
        }
        return Math.min(ans1, ans2);
    }

    public int memorization(String s, int l, int r, int[][] dp) {
        if (l == r) {
            return 1;
        }
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int i = l + 1;
        while (i <= r && s.charAt(i) == s.charAt(l)) {
            i++;
        }
        if (i == r + 1) {
            return 1;
        }
        int ans1 = 1 + memorization(s, i, r, dp);
        int ans2 = Integer.MAX_VALUE;
        for (int j = i; j <= r; j++) {
            if (s.charAt(j) == s.charAt(l)) {
                ans2 = Math.min(ans2, memorization(s, i, j - 1, dp) + memorization(s, j, r, dp));
            }
        }
        return dp[l][r] = Math.min(ans1, ans2);
    }
}
