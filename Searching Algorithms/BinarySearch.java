public class BinarySearch {
   public  boolean search(int arr[], int x) {
      int low=0;
      int high=arr.length-1;
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
      int arr[]={2,3,5,8,9,11};
      BinarySearch obj = new BinarySearch();
      System.out.println(obj.search(arr,9));
   }
}
