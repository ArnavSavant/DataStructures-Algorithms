import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums1) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        for (int x : nums2) {
            if (mp.containsKey(x)) {
                ans.add(x);
                mp.put(x, mp.get(x) - 1);
                if  (mp.get(x )  == 0) {
                    mp.remove(x);
                }
            }
        }
        int[] array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            array[i] = ans.get(i);

        return array;
    }
}
