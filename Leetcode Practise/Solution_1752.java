public class Solution_1752 {
   public boolean check(int nums[]) {
      int count = 0; //how many places the array is not sorted
      // a sorted rotated array would be un-sorted at exactly one place.
      for(int i=0;i<nums.length;i++) {
         if(nums[i]>nums[(i+1)%nums.length]) {
            count++;
         }
         if(count > 1) {
            return false;
         }
      }
      return true;
   }
}
