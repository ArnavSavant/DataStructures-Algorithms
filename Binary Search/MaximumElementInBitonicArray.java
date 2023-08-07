public class MaximumElementInBitonicArray {
   public int solve(int arr[]) {
      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (mid > 0 && mid < arr.length - 1) {
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
               return mid;
            }
            else if (arr[mid + 1] > arr[mid]) {
               low = mid + 1;
            }
            else if (arr[mid - 1] > arr[mid]) {
               high = mid - 1;
            }
         }
         else if (mid == 0) {
            if (arr[1] > arr[0]) {
               return 1;
            }
            else {
               return 0;
            }
         }
         else if (mid == arr.length - 1) {
            if (arr[arr.length - 1] > arr[arr.length - 2]) {
               return arr.length - 1;
            }
            else {
               return arr.length - 2;
            }
         }
      }
      return -1;
   }
}
