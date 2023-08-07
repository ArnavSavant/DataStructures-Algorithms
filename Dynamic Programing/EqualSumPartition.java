//s1 = s2;
//s1-s2=0;
public class EqualSumPartition {

   public int sum(int arr[]) { // helper function
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
         sum = sum + arr[i];
      }
      return sum;
   }

   public boolean SubsetSum(int arr[], int n, int sum) {
      boolean t[][] = new boolean[n + 1][sum + 1];
      for (int i = 0; i <= sum; i++) {
         t[0][i] = false;
      }
      for (int i = 0; i <= n; i++) {
         t[i][0] = true;
      }
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= sum; j++) {
            if (arr[i - 1] <= j) {
               t[i][j] = (t[i - 1][j - arr[i - 1]] || t[i - 1][j]);
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][sum];
   }

   public boolean equalSumPartition(int arr[], int n) {
      if (sum(arr) % 2 == 1) {
         return false;
      }
      return SubsetSum(arr, n, sum(arr) / 2);
   }

   public static void main(String[] args) {
      EqualSumPartition obj = new EqualSumPartition();
      int arr[]={1,5,12,5};
      System.out.println(obj.equalSumPartition(arr, arr.length));
   }
}
