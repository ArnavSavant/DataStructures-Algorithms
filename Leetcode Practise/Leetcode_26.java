public class Leetcode_26 {
   public int removeDuplicates(int[] nums) {
      if(nums.length == 1) {
         return 1;
      }
      int i=0;
      for(int j =0;j<nums.length;j++) {
         if(nums[i]!=nums[j]) {
            i++;
            nums[i]=nums[j];
         }
      }
      return i+1;
   }
}
