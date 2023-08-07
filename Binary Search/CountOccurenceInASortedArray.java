public class CountOccurenceInASortedArray {
   public int search(int arr[], int target) {

      if (arr.length == 0 || arr == null || (arr.length == 1 && arr[0] != target)) {
         return 0;
      }

      int x = -1;
      int y = -1;

      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (target < arr[mid]) {
            high = mid - 1;
         }
         else if (target > arr[mid]) {
            low = mid + 1;
         }
         else if (target == arr[mid]) {
            x = mid;
            high = mid - 1;
         }
      }
      
      low = 0;
      high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (target < arr[mid]) {
            high = mid - 1;
         }
         else if (target > arr[mid]) {
            low = mid + 1;
         }
         else if (target == arr[mid]) {
            y = mid;
            low = mid + 1;
         }
      }

      if (x == -1 && y == -1) {
         return 0;
      }

      return y - x + 1;
   }

   public static void main(String[] args) {
      CountOccurenceInASortedArray obj = new CountOccurenceInASortedArray();
      int arr[]={1,3,6,8,8,8,10,12,16};
      System.out.println(obj.search(arr, 8));
   }
}
