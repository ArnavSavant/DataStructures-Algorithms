public class Leetcode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while ((i != -1) && (j != -1)) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (i != -1) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while (j != -1) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
/*
### Function Signature:
```java
public void merge(int[] nums1, int m, int[] nums2, int n)
```

### Purpose:
This function merges two sorted arrays, `nums1` and `nums2`, into a single sorted array. The merged result is stored in `nums1`.

### Parameters:
- `nums1[]`: A sorted integer array with a size of `m + n`. The first `m` elements contain the sorted sequence, and the remaining `n` elements are empty (usually initialized with zeros or other placeholders).
- `m`: The number of initialized elements in `nums1`.
- `nums2[]`: A sorted integer array with a size of `n`.
- `n`: The number of elements in `nums2`.

### Detailed Explanation:

1. **Initialization**:
   ```java
   int i = m - 1;
   int j = n - 1;
   int k = m + n - 1;
   ```
   - `i`: Points to the last element of `nums1` that contains valid data.
   - `j`: Points to the last element of `nums2`.
   - `k`: Points to the last position in `nums1` where the merged elements will be placed.

2. **Merging Process**:
   ```java
   while ((i != -1) && (j != -1)) {
      ...
   }
   ```
   - The loop continues until either `nums1` or `nums2` is exhausted.
   - Inside the loop, we compare the current elements of `nums1` and `nums2`:
     - If the current element of `nums1` is greater than or equal to the current element of `nums2`, place the element from `nums1` in the current position of `k` and decrement `i`.
     - Otherwise, place the element from `nums2` in the current position of `k` and decrement `j`.
   - After placing an element, decrement `k`.

3. **Handling Remaining Elements**:
   - If there are remaining elements in `nums1`:
     ```java
     while (i != -1) {
         nums1[k] = nums1[i];
         i--;
         k--;
     }
     ```
   - If there are remaining elements in `nums2`:
     ```java
     while (j != -1) {
         nums1[k] = nums2[j];
         j--;
         k--;
     }
     ```
   - These loops ensure that any leftover elements from either array are placed correctly in `nums1`.

### Intuition:

Imagine you're sorting seashells 🐚 on the beach. You have two piles of sorted seashells (`nums1` and `nums2`) and a larger space (`nums1` with extra space) to merge them. You start by picking the largest seashell from the end of each pile and placing it at the end of the larger space. You continue this process, always picking the largest available seashell, until both piles are empty. This is the essence of the merging process in this function.

The beauty of this approach is that it utilizes the extra space in `nums1` efficiently, merging the arrays in-place without needing additional space.
 */
