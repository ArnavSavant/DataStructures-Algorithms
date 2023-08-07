public class MooresVotingAlgorithm {
   public int solve(int arr[], int n) {
      int count = 0;
      int element = 0;
      for(int i=0;i<n-1;i++) {
         if(count==0) {
            element = arr[i];
         }
         if(element == arr[i]) {
            count++;
         }
         else {
            count--;
         }
      }
      return element;
   }
   public static void main(String[] args) {
      MooresVotingAlgorithm obj = new MooresVotingAlgorithm();
      int arr[] = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
      System.out.println(obj.solve(arr, arr.length));
   }
}
