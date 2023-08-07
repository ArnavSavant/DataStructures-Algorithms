public class MinimumDifferenceElementInSortedArray {
   public int solve(int arr[], int key) {
      if (arr.length == 0 || arr == null) {
         return -1;
      }
      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (arr[mid] == key) {
            return 0;
         }
         else if (arr[mid] > key) {
            high = mid - 1;
         }
         else if (arr[mid] < key) {
            low = mid + 1;
         }
      }
      int min = Math.min(Math.abs(key - arr[high]), Math.abs(key - arr[low]));
      if(min == Math.abs(key - arr[high])) {
         return arr[high];
      }
      else if(min == Math.abs(key - arr[low])){
         return arr[low];
      }
      return -1;
   }
   public static void main(String[] args) {
      MinimumDifferenceElementInSortedArray obj = new MinimumDifferenceElementInSortedArray();
      int arr[] = {1, 4, 9, 10, 12, 15, 18, 20, 27};
      System.out.println(obj.solve(arr, 22));
   }
}
