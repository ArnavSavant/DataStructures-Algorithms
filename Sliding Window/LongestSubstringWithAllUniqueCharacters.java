import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAllUniqueCharacters {
   public int solve(String s) {
      int i = 0;
      int j = 0;
      int max = 0;
      Map<Character, Integer> mp = new HashMap<Character, Integer>();
      while (j < s.length()) {
         if (mp.containsKey(s.charAt(j))) {
            mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            // System.out.println(mp);
         } else {
            mp.put(s.charAt(j), 1);
            // System.out.println(mp);
         }
         if (j - i + 1 < mp.size()) {
            j++;
         } else if (j - i + 1 == mp.size()) {
            max = Math.max(max, j - i + 1);
            j++;
         } else if (j - i + 1 > mp.size()) {
            while (j - i + 1 > mp.size()) {
               mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
               // System.out.println(mp);
               if (mp.get(s.charAt(i)) == 0) {
                  mp.remove(s.charAt(i));
                  // System.out.println(mp);
               }
               i++;
            }
            j++;
         }
      }
      return max;
   }
   public static void main(String[] args) {
      LongestSubstringWithAllUniqueCharacters obj = new LongestSubstringWithAllUniqueCharacters();
      String s = "abacbebebaca";
      System.out.println(obj.solve(s));
   }
}
