import java.util.SortedSet;
import java.util.TreeSet;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

   public int longestSubarray(int[] nums, int limit) {
      int max = 0;
      int i = 0;
      int j = 0;
      SortedSet<Integer> set = new TreeSet<Integer>();
      while (j < nums.length) {
         set.add(nums[j]);
         if (Math.abs(set.last() - set.first()) <= limit) {
            max = Math.max(max, j - i + 1);
            j++;
         }

         else if (Math.abs(set.last() - set.first()) > limit) {
            while (Math.abs(set.last() - set.first()) > limit) {
               if(nums[i] == nums[i+1]) {
                  i++;
               }
               else {
                  set.remove(nums[i]);
                  i++;
               }
            }
            max = Math.max(max, j - i + 1);
            j++;
         }
      }
      return max;
   }
   public static void main(String[] args) {
      LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit obj = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
      int arr[] = {4,2,2,2,4,4,2,2};
      System.out.println(obj.longestSubarray(arr, 0));
   }
}
