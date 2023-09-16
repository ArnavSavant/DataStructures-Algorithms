import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(num, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }

    private static void solve(int[] num, ArrayList<Integer> ans, int sum, int ind) {
        if (ind == num.length) {
            ans.add(sum);
            return;
        }
        solve(num, ans, sum + num[ind], ind + 1);
        solve(num, ans, sum, ind + 1);
    }
}
