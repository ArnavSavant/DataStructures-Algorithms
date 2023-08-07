import java.util.Arrays;

public class MinimumDifferenceBetweenHighestandLowestofKScores {
   public int minimumDifference(int[] nums, int k) {
      display(nums);
      Arrays.sort(nums);
      display(nums);
      int n = nums.length;
      int i = 0;
      int j = 0;
      int min = Integer.MAX_VALUE;
      while (j < n) {
         if (j - i + 1 < k) {
            j++;
         } else if (j - i + 1 == k) {
            min = Math.min(min, nums[j] - nums[i]);
            i++;
            j++;
         }
      }
      return min;
   }
   public void display(int nums[]) {
      for(int i=0;i<nums.length;i++) {
         System.out.print(nums[i]+" ");
      }
      System.out.println("");
   }
   public static void main(String[] args) {
      MinimumDifferenceBetweenHighestandLowestofKScores obj = new MinimumDifferenceBetweenHighestandLowestofKScores();
      int arr[] = {9,1,7,4};
      System.out.println(obj.minimumDifference(arr, 2));
   }
}