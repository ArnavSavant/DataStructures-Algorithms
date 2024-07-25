import java.util.ArrayList;
import java.util.List;

public class Leetcode_3211 {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        solve(0, n, new StringBuffer(), ans);
        return ans;
    }

    public void solve(int ind, int n, StringBuffer sb, List<String> ans) {
        if (ind == n) {
            ans.add(new String(sb.toString()));
            return;
        }
        sb.append("1");
        solve(ind + 1, n, sb, ans);
        sb.deleteCharAt(ind);

        if (ind == 0 || sb.charAt(ind - 1) != '0') {
            sb.append("0");
            solve(ind + 1, n, sb, ans);
            sb.deleteCharAt(ind);
        }
    }
}
