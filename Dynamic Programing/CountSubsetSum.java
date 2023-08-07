public class CountSubsetSum {
   //DP SOLUTION
   public int countSubsetSum(int arr[], int n, int sum) {
      int t[][] = new int[n + 1][sum + 1];
      for (int i = 0; i <= sum; i++) {
         t[0][i] = 0;
      }
      for (int i = 0; i <= n; i++) {
         t[i][0] = 1;
      }
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= sum; j++) {
            if (arr[i - 1] <= j) {
               t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][sum];
   }

   //RECURRSIVE SOLLUTION
   // public int countSubsetSum(int arr[], int n, int sum) {
   //    if (sum == 0) {
   //       return 1;
   //    }
   //    if (n == 0) {
   //       return 0;
   //    }
   //    if (sum < arr[n - 1]) {
   //       return countSubsetSum(arr, n - 1, sum);
   //    }
   //    return countSubsetSum(arr, n - 1, sum - arr[n - 1]) + countSubsetSum(arr, n - 1, sum);
   // }

   public static void main(String[] args) {
      CountSubsetSum obj = new CountSubsetSum();
      int arr[] = { 2, 3, 5, 6, 8, 10 };
      System.out.println(obj.countSubsetSum(arr, arr.length, 10));
   }
}
