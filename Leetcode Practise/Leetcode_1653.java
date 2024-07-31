public class Leetcode_1653 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int a_count_right = 0;
        for (char x : s.toCharArray()) {
            if (x == 'a') {
                a_count_right++;
            }
        }
        if (a_count_right == n || a_count_right == 0) {
            return 0;
        }
        int b_count_left = 0;
        int ans = n;
        for (char x : s.toCharArray()) {
            if (x == 'a') {
                a_count_right--;
            }
            ans = Math.min(ans, b_count_left + a_count_right);
            if (x == 'b') {
                b_count_left++;
            }

        }
        return ans;
    }
}
