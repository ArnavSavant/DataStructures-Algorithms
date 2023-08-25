import java.util.ArrayList;

public class Leetcode_493 {

    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void find(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        while (left <= mid) {
            while (right <= high && (0.5 * arr[left]) > arr[right]) {
                right++;
            }
            count = count + right - (mid + 1);
            left++;
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        find(arr, low, mid, high);
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
}

/*
 This code is an implementation of a modified version of the merge-sort algorithm. Its main purpose is to find the number of important reverse pairs in an array. An important reverse pair is defined as a pair of indices `(i, j)` such that `i < j` and `nums[i] > 2 * nums[j]`.

Let's break down the logic and intuition behind the code:

### Intuition

A brute-force approach to count the important reverse pairs would involve iterating over the array using two nested loops. This would have a time complexity of \(O(n^2)\). However, a more efficient way to tackle this problem is by leveraging the merge-sort algorithm. While we perform the merge sort, we can simultaneously count the number of important reverse pairs. This approach has a time complexity of \(O(n \log n)\).

### Logic

1. **Main Function `reversePairs`**: 
    - This function initializes the merge sort and then returns the count of important reverse pairs.

2. **Function `find`**:
    - The primary purpose of this function is to count the important reverse pairs in the current segment of the array.
    - For each element in the left half of the array, it counts how many numbers in the right half satisfy the important reverse pair condition (`nums[i] > 2 * nums[j]`).
    - The while loop is designed such that for each element in the left half (denoted by `left`), it will keep moving `right` until it finds a number in the right half that no longer satisfies the condition. The difference `(right - (mid + 1))` gives the number of important reverse pairs for the current element in the left half. 

3. **Function `merge`**:
    - This function merges two sorted halves of a segment of the array.
    - Before merging, it calls the `find` function to count the important reverse pairs for the current segment.
    - The merging process then happens as in the traditional merge-sort algorithm, with the sorted result stored in a temporary ArrayList.

4. **Function `mergeSort`**:
    - This is the standard recursive merge sort function. It divides the array into two halves, sorts each half recursively, and then merges them using the `merge` function.

### Overall Flow:

1. The array is recursively divided into smaller segments.
2. For each segment, before merging, the `find` function is called to count the number of important reverse pairs.
3. After counting, the two halves of the segment are merged into a sorted segment.
4. The process continues until the entire array is sorted, and by this time, we have the count of all important reverse pairs.

### Example:

Consider the array: `nums = [2, 4, 3, 5, 1]`.

1. After the first split and before merging, we have two segments: `[2]` and `[4, 3, 5, 1]`.
2. Before merging `[2]` with `[4, 3, 5, 1]`, we count the number of important reverse pairs with numbers from the left segment (which is only `[2]`) and numbers from the right segment.
3. Similarly, we continue to split, count the reverse pairs, and merge until the array is completely sorted.

By the end, the count variable will have the total number of important reverse pairs in the array.
 */
