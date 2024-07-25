public class Leetcode_912 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            max_heapify(nums, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            max_heapify(nums, 0, i);
        }

        return nums;
    }

    public void max_heapify(int arr[], int i, int n) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            max_heapify(arr, largest, n);
        }
    }
}
