import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Leetcode_3113 {
    public long numberOfSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int prevLargest[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            prevLargest[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(nums[i])) {
                List<Integer> temp = mp.get(nums[i]);
                temp.add(i);
                mp.put(nums[i], temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                mp.put(nums[i], temp);
            }
            if (prevLargest[i] == -1) {
                ans = ans + mp.get(nums[i]).size();
            } else {
                int ind = getUpperBound(mp.get(nums[i]), prevLargest[i]);
                ans = ans + (mp.get(nums[i]).size() - ind);
            }
        }
        return ans;
    }

    public int getUpperBound(List<Integer> list, int x) {
        int low = 0;
        int high = list.size() - 1;
        int upperBound = list.size() - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (list.get(mid) < x) {
                low = mid + 1;
            } else if (list.get(mid) > x) {
                upperBound = mid;
                high = mid - 1;
            }
        }
        return upperBound;
    }
}
