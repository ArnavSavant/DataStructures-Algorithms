import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : arr1) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int[] ans = new int[arr1.length];
        int cnt = 0;
        for (int x : arr2) {
            while (mp.get(x) > 0) {
                ans[cnt] = x;
                cnt++;
                mp.put(x, mp.get(x) - 1);
            }
            mp.remove(x);
        }
        int[] remaining = new int[arr1.length - cnt];
        int index = 0;
        for (int x : arr1) {
            if (mp.containsKey(x)) {
                while (mp.get(x) > 0) {
                    remaining[index] = x;
                    index++;
                    mp.put(x, mp.get(x) - 1);
                }
                mp.remove(x);
            }
        }
        Arrays.sort(remaining);
        for (int x : remaining) {
            ans[cnt] = x;
            cnt++;
        }
        return ans;
    }
}