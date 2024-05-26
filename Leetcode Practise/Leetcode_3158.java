import java.util.HashSet;
import java.util.Set;

public class Leetcode_3158 {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int x : nums) {
            if (set.contains(x)) {
                ans = ans ^ x;
            } else {
                set.add(x);
            }
        }
        return ans;
    }
}
