import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int ans[] = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                mp.put(nums2[i], -1);
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    mp.put(nums2[i], -1);
                } else {
                    mp.put(nums2[i], stack.peek());
                }
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = mp.get(nums1[i]);
        }
        return ans;
    }
}
/*
Alright, let's dissect this code which is designed to solve the problem of finding the next greater element for each element in `nums1` from the elements in `nums2`.

**Problem Statement**: 
Given two arrays, `nums1` and `nums2`, for each element in `nums1`, find the first greater element in `nums2` that appears on its right. Return an array of these greater elements. If no such greater element exists for some element, put `-1` for that element.

**Logic and Intuition**:

The code uses a stack-based approach to determine the next greater element for each element in `nums2`. It uses a hashmap (`mp`) to store the next greater element for each of the elements in `nums2`.

1. **Monotonic Stack**: The stack used in this code will have the property that the elements from the bottom to the top of the stack are in decreasing order. This kind of stack is known as a monotonic stack. The idea is that when a new number comes, it will "defeat" the elements that are smaller than it, which means it's the next greater element for those smaller numbers. This is why the smaller numbers are popped out of the stack.

2. **Iterating in Reverse**: The code iterates over `nums2` in reverse. This is because we want to know the next greater element on the right for each element, and by iterating in reverse, we can utilize the stack to remember elements that we've previously encountered.

3. **Populating the Map**: As we iterate, if the current number is greater than the top of the stack, it "defeats" the numbers at the top (because it's the next greater number for them). We keep popping the stack until we find a larger number or the stack is empty. The current number's next greater element will be the top of the stack if it exists, otherwise `-1`. This mapping is stored in the hashmap `mp`.

4. **Generating the Result**: Once the map for all elements of `nums2` has been populated, it's straightforward to generate the result for `nums1`. For each element in `nums1`, we simply retrieve its next greater element from the hashmap and populate the `ans` array.

**Why this code works**:

1. **Memory of Future Elements**: By using the stack, the code has an efficient way to remember which numbers from `nums2` are potential next greater elements for future numbers. 

2. **Efficiency**: The code effectively uses the stack to eliminate numbers that are no longer candidates for being the next greater element for future numbers. This ensures that each number in `nums2` is processed in constant time, making the algorithm efficient.

3. **Accurate Mapping**: By the end of processing `nums2`, the hashmap `mp` has an accurate mapping of the next greater element for every number in `nums2`, which makes generating the result for `nums1` straightforward.

**Conclusion**:

The provided code is an efficient solution for the next greater element problem. It leverages the properties of a monotonic stack and the utility of a hashmap to store results, providing a clear and optimal approach to the problem.
 */
