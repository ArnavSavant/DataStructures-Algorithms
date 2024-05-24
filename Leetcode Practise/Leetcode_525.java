import java.util.HashMap;
import java.util.Map;

public class Leetcode_525 {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int countOfOne = 0;
        int countOfZero = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countOfZero++;
            } else {
                countOfOne++;
            }
            if (!mp.containsKey(countOfOne - countOfZero)) {
                mp.put(countOfOne - countOfZero, i);
            }
            if (countOfOne == countOfZero) {
                res = countOfOne + countOfZero;
            } else {
                int ind = mp.get(countOfOne - countOfZero);
                res = Math.max(res, ind);
            }
        }
        return res;
    }
}
