import java.util.HashMap;
import java.util.Map;

public class NumberofSubarraySumEqualsToK {
   public int solve(int arr[], int k) {
      int ans = 0;
      Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
      mp.put(0, 1);
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
         sum = sum + arr[i];
         if (mp.containsKey(sum - k)) {
            ans = ans + mp.get(sum - k);
         }
         if (mp.containsKey(sum)) {
            mp.put(sum, mp.get(sum) + 1);
         } else {
            mp.put(sum, 1);
         }
      }
      return ans;
   }

   public static void main(String[] args) {
      NumberofSubarraySumEqualsToK obj = new NumberofSubarraySumEqualsToK();
      int arr[] = { 0,0,0,0,0};
      System.out.println(obj.solve(arr, 0));
   }
}
