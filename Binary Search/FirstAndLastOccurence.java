public class FirstAndLastOccurence {
   public int[] search(int arr[], int target) {
      if(arr.length == 0 || arr == null) {
         return new int[]{-1,-1};
      }

      int x=-1;
      int y=-1;

      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (target < arr[mid]) {
            high = mid - 1;
         }
         else if (target > arr[mid]) {
            low = mid + 1;
         }
         else if(target == arr[mid]) {
            x=mid;
            high = mid-1;
         }
      }

      low = 0;
      high = arr.length -1;
      while (low <= high) {
         int mid = low + (high - low) / 2;
         if (target < arr[mid]) {
            high = mid - 1;
         }
         else if (target > arr[mid]) {
            low = mid + 1;
         }
         else if(target == arr[mid]) {
            y=mid;
            low = mid+1;
         }
      }

      return new int[]{x,y};
   }
   public static void main(String[] args) {
      FirstAndLastOccurence obj = new FirstAndLastOccurence();
      int arr[]={1,4,8,8,8,9,12,15};
      int res[] = obj.search(arr, 10);
      System.out.println("["+res[0]+","+res[1]+"]");
   }
}
