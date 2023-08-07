//performs well for unbounded arrays(infinte size)
//performs better than binary search for bounded arrays if the element is closer to the starting index
public class ExponentialSearch {
   public boolean search(int arr[], int x) {
      if(x==arr[0]) {
         return true;
      }
      int i=1;
      while(i<arr.length && arr[i]<=x) {
         i=i*2;
      }
      return binarySearch(arr, i/2, Math.min(i,arr.length-1), x);
   }
   public boolean binarySearch(int arr[], int low, int high, int x) {
      while(low<high) {
         int mid=(low+high)/2;
         if(x>arr[mid]) {
            low=mid+1;
         }
         else if(x<arr[mid]) {
            high=mid-1;
         }
         else {
            return true;
         }
      }
      return false;
   }
   public static void main(String[] args) {
      int arr[] = {1,3,9,11,16,20,25,28,29,31};
      ExponentialSearch obj = new ExponentialSearch();
      System.out.println(obj.search(arr,25));
   }
}
