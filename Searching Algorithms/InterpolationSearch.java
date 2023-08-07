//array should be sorted
//array should be uniformly distributed --> gap between elements should be same
//if non-uniformly the uniformity should be as high as possible
//IF data is highly and fairly uniform then this searching algorithm will be better ths binary search
public class InterpolationSearch {
   public boolean search(int arr[], int x) {
      int high = arr.length - 1;
      int low = 0;
      // int step = 0;
      while (low <= high) {
         int temp = (low + (((x - arr[low]) * (high - low)) / (arr[high] - arr[low])));
         if(temp>arr.length) {
            return false;
         }
         // System.out.println(temp);
         // step++;
         if (arr[temp] == x) {
            // System.out.println(step);
            return true;
         }
         if (x > arr[temp]) {
            low = temp + 1;
         }
         if (x < arr[temp]) {
            high = temp - 1;
         }
      }
      // System.out.println(step);
      return false;
   }

   public static void main(String[] args) {
      int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      InterpolationSearch obj = new InterpolationSearch();
      System.out.println(obj.search(arr, 25));
   }
}