import java.util.HashMap;
import java.util.Map;

public class Leetcode_560 {
   public int subarraySum(int[] nums, int k) {
      int count = 0;
      int sum = 0;
      Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
      mp.put(0, 1);
      for (int i = 0; i < nums.length; i++) {
         sum = sum + nums[i];
         if (mp.containsKey(sum - k)) {
            count = count + mp.get(sum - k);
         }
         if (mp.containsKey(sum)) {
            mp.put(sum, mp.get(sum) + 1);
         } else {
            mp.put(sum, 1);
         }
      }
      return count;
   }
}
