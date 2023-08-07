public class MaximumSumSubArrayofSizek {
   // public int solve(int arr[], int k) {
   // int n = arr.length;
   // if (n < k) {
   // return -1;
   // }
   // int currSum = 0;
   // for (int i = 0; i < k; i++) {
   // currSum = currSum + arr[i];
   // }
   // int maxSum = currSum;

   // for (int i = k; i < n; i++) {
   // currSum = currSum + arr[i] - arr[i - k];
   // maxSum = Math.max(maxSum, currSum);
   // }
   // return maxSum;
   // }
   public int solve(int arr[], int k) {
      int n = arr.length;
      int i = 0; // denoting start of window
      int j = 0; // denoting end of window
      int maxSum = Integer.MIN_VALUE;
      int sum = 0;
      while (j < n) {
         sum = sum + arr[j];
         if (j - i + 1 < k) {
            j++;
         } else if (j - i + 1 == k) {
            maxSum = Math.max(maxSum, sum);
            sum = sum - arr[i];
            i++;
            j++;
         }
      }
      return maxSum;
   }

   public static void main(String[] args) {
      MaximumSumSubArrayofSizek obj = new MaximumSumSubArrayofSizek();
      int arr[] = { 2, 3, 5, 1, 8, 2, 3 };
      // int arr[]={1,2};
      System.out.println(obj.solve(arr, 3));
   }
}