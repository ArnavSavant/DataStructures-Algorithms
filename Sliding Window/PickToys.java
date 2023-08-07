import java.util.HashMap;
import java.util.Map;

public class PickToys {
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
         if (mp.size() < 2) {
            j++;
         } else if (mp.size() == 2) {
            max = Math.max(max, j - i + 1);
            j++;
         } else if (mp.size() > 2) {
            while (mp.size() > 2) {
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
      PickToys obj = new PickToys();
      String s = "abacacb";
      System.out.println(obj.solve(s));
   }
}
