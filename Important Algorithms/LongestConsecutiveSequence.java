import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
   public int longestConsecutive(int[] nums) {
      Set<Integer> s = new TreeSet<Integer>();
      for (int i = 0; i < nums.length; i++) {
         s.add(nums[i]);
      }
      System.out.println(s);
      int counter = 0;
      int prev = 0;
      int maxCounter = Integer.MIN_VALUE;
      System.out.println("prev  counter");
      for (int x : s) {
         if (counter == 0) {
            counter++;
         } else {
            if (x == prev + 1) {
               counter++;
            } else {
               maxCounter = Math.max(maxCounter, counter);
               counter = 1;

            }
         }
         prev = x;
      }
      if (counter == s.size()) {
         return counter;
      }
      return maxCounter;
   }
   public static void main(String[] args) {
      LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
      int arr[] = {9,1,4,7,3,-1,0,5,8,-1,6};
      System.out.println(obj.longestConsecutive(arr));
   }
}