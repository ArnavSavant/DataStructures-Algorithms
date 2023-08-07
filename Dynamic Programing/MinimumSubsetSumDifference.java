//S1+S2=S
//S1-S2= D(min)
//D(min) = 2*S1 - S [s1>s2] & [0 <= S <= sum of all array elements]
//or
//D(min) = S - 2*S2 [s1>s2] & [0 <= S <= sum of all array elements]
public class MinimumSubsetSumDifference {
   public int minimumSubsetSumDifference(int arr[], int n, int sum) {
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
               t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
            } else {
               t[i][j] = t[i - 1][j];
            } 
         }
      }
      int diff = Integer.MAX_VALUE;
      for (int i = 0; i <= sum / 2; i++) {
         if (t[n][i]) {
            diff = Math.min(diff, sum - 2 * i);
         }
      }
      return diff;
   }

   public int sum(int arr[]) {
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
         sum = sum + arr[i];
      }
      return sum;
   }

   public static void main(String[] args) {
      MinimumSubsetSumDifference obj = new MinimumSubsetSumDifference();
      int arr[] = { 1, 2, 7 };
      System.out.println(obj.minimumSubsetSumDifference(arr, arr.length, obj.sum(arr)));
   }
}
