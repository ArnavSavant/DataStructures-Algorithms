public class CeilOfAnElement {
   public int search(int arr[], int key) {
      int low = 0;
      int high = arr.length-1;
      int res = Integer.MAX_VALUE;
      while(low<=high) {
         int mid = low+ (high-low)/2;
         if(arr[mid]== key) {
            return key;
         }
         else if(arr[mid]>key) {
            high = mid-1;
         }
         else if(arr[mid]<key) {
            low = mid+1;
         }
         if(arr[mid]>key) {
            res = Math.min(res,arr[mid]);
         }
      }
      return res;
   }
   public static void main(String[] args) {
      CeilOfAnElement obj = new CeilOfAnElement();
      int arr[]= {1,2,4,5,6,8,10,12,16,18,25};
      System.out.println(obj.search(arr, 19));
   }
}
