public class SearchInRotatedSortedArray {
   public int search(int arr[], int key) {
      int n = arr.length;
      if (n == 0 || arr == null) {
         return -1;
      }
      int low = 0;
      int high = n - 1;
      int mid = 0;
      while (low <= high) {
         mid = low + (high - low) / 2;
         if ((arr[mid] < arr[(mid + 1) % n]) && (arr[mid] < arr[(mid + n - 1) % n])) {
            break;
         }
         else if (arr[mid] < arr[high]) {
            high = mid - 1;
         }
         else if (arr[mid] > arr[low]) {
            low = mid + 1;
         }
      }
      high = n - 1;
      if (key >= arr[mid] && key <= arr[high]) {
         low = mid;
      }
      else {
         high = (mid + n - 1) % n;
      }
      while (low <= high) {
         mid = low + (high - low) / 2;
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
      SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
      int arr[]={7,8,9,10,1,2,3,4,5,6};
      System.out.println("index: "+obj.search(arr, 5));
   }
}
