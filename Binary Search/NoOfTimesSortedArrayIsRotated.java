public class NoOfTimesSortedArrayIsRotated {
   public int search(int arr[]) {
      int n = arr.length;
      if (n == 0 || n == 1) { //base case
         return 0;
      }

      if (n == 2) { //for length equals two
         if (arr[0] > arr[1]) {
            return 1;
         }
         else {
            return 0;
         }
      }

      if (arr[0] < arr[n - 1]) { //sorted array check
         return 0; 
      }

      int low = 0;
      int high = n - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (arr[mid] < arr[(mid + 1) % n] && arr[mid] < arr[(mid + n - 1) % n]) { //(%n) helps in countering rotatory problems
            return mid;
         }
         else if (arr[mid] > arr[high]) {
            low = mid + 1;
         }
         else if (arr[mid] < arr[low]) {
            high = mid - 1;
         }
      }
      return 0;
   }

   public static void main(String[] args) {
      NoOfTimesSortedArrayIsRotated obj = new NoOfTimesSortedArrayIsRotated();
      int arr[] = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };
      System.out.println(obj.search(arr));
   }
}
