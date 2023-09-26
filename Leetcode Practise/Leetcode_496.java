import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int ans[] = new int[nums1.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            int x = nums2[i];
            if (stack.isEmpty()) {
                stack.push(-1);
                mp.put(x, -1);
            } else {
                
            }
        }
        return ans;
    }
}
