public class BinarySearchUnknownOrder {

   public int searchDescending(int arr[], int key) {
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

   public int searchAscending(int arr[], int key) {
      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (key < arr[mid]) {
            high = mid - 1;
         }
         else if (key > arr[mid]) {
            low = mid + 1;
         }
         else if(key == arr[mid]) {
            return mid;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      int arr[]={1,4,5,9,12,16,17,18,25,36,48};
      BinarySearchUnknownOrder obj = new BinarySearchUnknownOrder();
      if(arr[0]<arr[1]) {
         System.out.println(obj.searchAscending(arr, 16));
      }
      else {
         System.out.println(obj.searchDescending(arr, 15));
      }
   }
}
