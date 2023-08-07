import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
   public int solve(String s, String t) {
      Map<Character, Integer> mp = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); i++) {
         if (mp.containsKey(t.charAt(i))) {
            mp.put(t.charAt(i), mp.get(t.charAt(i)) + 1);
         } else {
            mp.put(t.charAt(i), 1);
         }
      }
      int i = 0;
      int j = 0;
      int min = Integer.MAX_VALUE;
      int count = mp.size();
      String ans = "";
      while (j < s.length()) {
         System.out.println(mp);
         if (mp.containsKey(s.charAt(j))) {
            mp.put(s.charAt(j), mp.get(s.charAt(j)) - 1);
            if (mp.get(s.charAt(j)) == 0) {
               count--;
            }
         }
         if (count > 0) {
            j++;
         }
         if (count == 0) {
            while (count == 0) {
               System.out.println(mp);
               min = Math.min(min, j - i + 1);
               if(min == j-i+1) {
                  ans = s.substring(i, j+1);
               }
               if (mp.containsKey(s.charAt(i))) {
                  mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
                  if (mp.get(s.charAt(i)) > 0) {
                     i++;
                     count++;
                  } else {
                     i++;
                     min = Math.min(min, j - i + 1);
                     if(min == j-i+1) {
                        ans = s.substring(i, j+1);
                     }
                  }
               } else {
                  i++;
                  min = Math.min(min, j - i + 1);
                  if(min == j-i+1) {
                     ans = s.substring(i, j+1);
                  }
               }
            }
            j++;
         }
      }
      System.out.println(ans);
      return min;
   }

   public static void main(String[] args) {
      MinimumWindowSubstring obj = new MinimumWindowSubstring();
      String s = "ADOBECODEBANC";
      String t = "ABC";
      System.out.println(obj.solve(s, t));
   }
}
