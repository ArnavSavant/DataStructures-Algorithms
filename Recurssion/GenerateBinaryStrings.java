import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    public List<String> generateString(int N) {
        List<String> ans = new ArrayList<String>();
        StringBuffer sb = new StringBuffer("");
        solve(ans, N, sb);
        return ans;
    }

    public void solve(List<String> list, int n, StringBuffer sb) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        sb.append('0');
        solve(list, n, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '1') {
            sb.append('1');
            solve(list, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
