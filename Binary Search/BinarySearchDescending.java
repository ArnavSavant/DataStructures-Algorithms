public class BinarySearchDescending {
   public int search(int arr[], int key) {
      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (key > arr[mid]) {
            high = mid - 1;
         }
         else if (key < arr[mid]) {
            low = mid + 1;
         }
         else if(key == arr[mid]) {
            return mid;
         }
      }
      return -1;
   }
   public static void main(String[] args) {
      BinarySearchDescending obj = new BinarySearchDescending();
      int arr[]={48,36,25,19,18,16,11,9,5,3,1};
      System.out.println("Index "+obj.search(arr, 16));
   }
}
