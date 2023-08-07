public class SubsetSum {
  // Recursive code
  // public boolean subsetsum(int arr[], int sum, int n) {
  //   if (sum == 0) {
  //     return true;
  //   }
  //   if (n == 0) {
  //     return false;
  //   }
  //   if (arr[n - 1] > sum) {
  //     return subsetsum(arr, sum, n - 1);
  //   }
  //   return subsetsum(arr, sum - arr[n - 1], n - 1) || subsetsum(arr, sum, n - 1);
  // }

  // DP Solution
  public int subsetsum(int arr[], int sum, int n) {
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
          t[i][j] = Math.max(t[i - 1][j - arr[i - 1]], t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }

  public static void main(String[] args) {
    SubsetSum obj = new SubsetSum();
    int arr[] = { 2, 3, 5, 8, 9, 11 };
    System.out.println(obj.subsetsum(arr, 10, arr.length));
  }
}
