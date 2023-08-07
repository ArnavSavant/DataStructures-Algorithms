public class LinearSearch {
   public boolean search(int arr[], int x) {
      for(int i=0;i<arr.length;i++) {
         if(arr[i]==x) {
            return true;
         }
      }
      return false;
   }
   public static void main(String[] args) {
      LinearSearch obj = new LinearSearch();
      int arr[]={4,2,6,8,9,5,3};
      System.out.println(obj.search(arr, 10));
   }
}
