import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], transalateInteger(nums[i], mapping));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(mp.get(a), mp.get(b));
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public int transalateInteger(int num, int[] mapping) {
        int mapped = 0;
        int base = 1;
        if (num == 0) {
            mapped = mapping[0];
        }
        while (num > 0) {
            mapped = mapped + mapping[num % 10] * base;
            num /= 10;
            base *= 10;
        }
        return mapped;
    }
}
