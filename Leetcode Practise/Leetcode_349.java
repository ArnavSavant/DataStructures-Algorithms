import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int x : nums1) {
            mp.put(x, true);
        }
        List<Integer> list = new ArrayList<>();
        for (int x : nums2) {
            if (mp.containsKey(x) && mp.get(x)) {
                list.add(x);
                mp.put(x, false);
            }
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
/*
The `intersection` method is designed to find the intersection of two arrays, `nums1` and `nums2`, and return it as an array. The intersection of two arrays includes all the unique elements present in both arrays. This method efficiently solves the problem using a `HashMap` and a `List`.

### Algorithm

1. **HashMap Population**: Initially, iterate through `nums1` and store each element in a `HashMap` (`mp`) with a value of `true`. This map acts as a set to quickly check if an element from `nums2` is present in `nums1`.

2. **Intersection Finding**: Iterate through `nums2` and for each element:
   - Check if it exists in `mp` and if its corresponding value is `true` (indicating it has not been processed before).
   - If so, add the element to a `List` (`list`) and update its value in `mp` to `false` to mark it as processed.

3. **Convert List to Array**: Convert the `list` of intersection elements into an array (`ans`) and return it.

### Why It Works

This method works because it leverages the `HashMap` to efficiently check for the existence and processing state of each element in `nums1` when iterating through `nums2`. The use of `true`/`false` values allows for not only checking presence but also ensuring uniqueness in the intersection result, as each element from `nums1` is considered only once.

### Time Complexity

- **O(n + m)**: Where `n` is the length of `nums1` and `m` is the length of `nums2`. Each array is iterated through exactly once, making the time complexity linear with respect to the sizes of the input arrays.

### Space Complexity

- **O(n + k)**: Where `n` is the number of unique elements in `nums1` that are stored in the `HashMap`, and `k` is the size of the intersection (the number of unique elements added to the list). In the worst case, this space complexity simplifies to O(n + m) if all elements are unique and all elements in `nums2` are in `nums1`.

### Summary

The `intersection` method efficiently computes the intersection of two arrays, ensuring uniqueness in the output by utilizing a `HashMap` for constant-time lookups and a `List` to store the intersection elements before converting them into the required array format. This approach offers a clear and efficient solution to the problem.
 */