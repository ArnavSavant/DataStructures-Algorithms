public class FloorOfAnElement {
   public int search(int arr[], int key) {
      int low = 0;
      int high = arr.length-1;
      int res = Integer.MIN_VALUE;
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
         if(arr[mid]<key) {
            res = Math.max(res,arr[mid]);
         }
      }
      return res;
   }
   public static void main(String[] args) {
      FloorOfAnElement obj = new FloorOfAnElement();
      int arr[]= {1,2,4,5,6,8,10,16,18,25};
      System.out.println(obj.search(arr, 20));
   }
}
