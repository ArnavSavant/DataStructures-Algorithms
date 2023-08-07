//array should be sorted
public class JumpSearch {
   public boolean search(int arr[], int x) {
      int m=(int)Math.floor(Math.sqrt(arr.length));
      int low=0;
      int high=m;
      while(arr[high-1]<x && high<arr.length) {
         low=high;
         high=high+m;
      }
      while(low<=high) {
         if(arr[low]==x) {
            return true;
         }
         low++;
      }
      return false;
   }
   public static void main(String[] args) {
      JumpSearch obj = new JumpSearch();
      int arr[]={1,4,9,16,25,36,49,64,81,100,121,144,169,196,225};
      System.out.println(obj.search(arr, 55));
   }
}
