public class LargestSubarrayofSumK {
   public int solve(int arr[], int k) {
      int i = 0;
      int j = 0;
      int max = 0;
      int sum = 0;
      while (j < arr.length) {
         sum = sum + arr[j];
         if (sum < k) {
            j++;
         } else if (sum == k) {
            max = Math.max(max, j - i + 1);
            j++;
         } else if (sum > k) {
            while (sum > k) {
               sum = sum - arr[i];
               i++;
            }
            if (sum == k) {
               max = Math.max(max, j - i + 1);
            }
            j++;
         }
      }
      return max;
   }

   public static void main(String[] args) {
      LargestSubarrayofSumK obj = new LargestSubarrayofSumK();
      int arr[] = { 4, 1, 1, 1, 2, 3, 5 };
      System.out.println(obj.solve(arr, 5));
   }
}