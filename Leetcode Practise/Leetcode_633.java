import java.util.HashSet;
import java.util.Set;

public class Leetcode_633 {
    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        int sqrt = (int) Math.sqrt(c);
        for (int i = -sqrt; i <= sqrt; i++) {
            if (set.contains(c - (i * i))) {
                return true;
            } else {
                set.add(i * i);
            }
        }
        return false;
    }
}
