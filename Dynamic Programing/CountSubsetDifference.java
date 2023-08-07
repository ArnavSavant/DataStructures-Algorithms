//s1+s2=S
//s1-s2=D
//s1=(S+D)/2 =>reduced to count subset sum
public class CountSubsetDifference {
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

   public int sum(int arr[]) {
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
         sum = sum + arr[i];
      }
      return sum;
   }

   public int countSubsetdifference(int arr[], int n, int diff) {
      int sum = sum(arr);
      int x = (sum + diff) / 2;
      return countSubsetSum(arr, n, x);
   }

   public static void main(String[] args) {
      CountSubsetDifference obj = new CountSubsetDifference();
      int arr[] = { 1, 1, 2, 3 };
      System.out.println(obj.countSubsetdifference(arr, arr.length, 1));
   }
}
