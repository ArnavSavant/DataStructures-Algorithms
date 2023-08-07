import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfAnagrams {
   public int solve(String text, String key) {
      int ans = 0;
      int count = 0;
      Map<Character, Integer> mp = new HashMap<Character, Integer>();
      int k = key.length();

      for (int i = 0; i < k; i++) {
         if (mp.containsKey(key.charAt(i))) {
            mp.put(key.charAt(i), mp.get(key.charAt(i)) + 1);
         } else {
            mp.put(key.charAt(i), 1);
            count++;
         }
      }

      int n = text.length();
      int i = 0;
      int j = 0;
      while (j < n) {
         char x = text.charAt(j);
         // calculation of the new element in the window
         if (mp.containsKey(x)) {
            mp.put(x, mp.get(x) - 1);
            if (mp.get(x) == 0) {
               count--;
            }
         }
         // window length not achieved yet
         if (j - i + 1 < k) {
            // System.out.println(mp);
            j++;
         }
         // window length achieved
         else if (j - i + 1 == k) {
            // System.out.println(mp);
            if (count == 0) {
               ans++;
            }
            if (mp.containsKey(text.charAt(i))) {
               mp.put(text.charAt(i), mp.get(text.charAt(i)) + 1);
               if (mp.get(text.charAt(i)) == 1) {
                  count++;
               }
            }
            // sliding the window
            i++;
            j++;
         }
      }
      // System.out.println(ans);
      return ans;
   }

   public static void main(String[] args) {
      CountOccurrenceOfAnagrams obj = new CountOccurrenceOfAnagrams();
      String text = "ababaxxaabbaxxbbaaa";
      String key = "aaabb";
      System.out.println(obj.solve(text, key));
   }
} 
