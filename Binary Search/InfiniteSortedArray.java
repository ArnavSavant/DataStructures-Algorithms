public class InfiniteSortedArray {
   public int search(int arr[], int key) {
      int low = 0;
      int high = arr.length - 1;
      while (arr[high] < key) {
         low = high;
         high = high * 2;
      }
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (key < arr[mid]) {
            high = mid - 1;
         }
         else if (key > arr[mid]) {
            low = mid + 1;
         }
         else if (key == arr[mid]) {
            return mid;
         }
      }
      return -1;
   }

   public static void main(String[] args) {

   }
}
