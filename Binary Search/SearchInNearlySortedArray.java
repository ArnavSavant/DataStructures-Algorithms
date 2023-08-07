public class SearchInNearlySortedArray {
   public int search(int arr[], int target) {
      int n = arr.length;
      if (n == 0 || arr == null) {
         return -1;
      }
      int low = 0;
      int high = n - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (arr[mid] == target) {
            return mid;
         }
         else if ((mid - 1 >= 0) && (arr[mid - 1] == target)) {
            return mid-1;
         }
         else if((mid + 1 <= n-1) && (arr[mid + 1] == target)) {
            return mid+1;
         }
         else if(target < arr[mid] && mid-2>=0) {
            high = mid-2;
         }
         else if(target > arr[mid] && mid+2<=n-1) {
            low = mid+2;
         }
      }
      return -1;
   }
   public static void main(String[] args) {
      SearchInNearlySortedArray obj = new SearchInNearlySortedArray();
      int arr[]={10,30,20,40,60,50};
      System.out.println(obj.search(arr, 50));
   }
}
