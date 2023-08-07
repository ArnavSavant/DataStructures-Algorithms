public class DutchFlagAlgorithm {
   public void display(int arr[]) {
      for(int i=0;i<arr.length;i++) {
         System.out.print(arr[i]+" ");
      }
      System.out.println();
   }
   public int[] solve(int arr[], int n) {
      int low = 0; //[0....low-1] --> '0'
      int mid = 0; //[low .... high-1] --> '1'
      int high = n-1; //[high .... n-1] --> '2'
      while(mid<=high) {
         if(arr[mid]==0) {
            swap(arr,low,mid);
            low++;
            mid++;
         }
         else if(arr[mid]==1) {
            swap(arr, mid, mid);
            mid++;
         }
         else {
            swap(arr, mid, high);
            high--;
         }
      }
      return arr;
   }
   public void swap(int arr[], int x, int y){
      int temp=arr[x];
      arr[x]=arr[y];
      arr[y]=temp;
   }
   public static void main(String[] args) {
      int arr[]={2,1,0,2,1,0,2,1,1,0,2,1,0,0,1,1,0,2};
      DutchFlagAlgorithm obj = new DutchFlagAlgorithm();
      System.out.println("Orignal Array");
      obj.display(arr);
      System.out.println("Sorted Array");
      obj.display(obj.solve(arr, arr.length));
   }
}
