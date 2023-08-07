import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
   Map<String,Boolean> mp =  new HashMap<String,Boolean>();

   public boolean solve(String a, String b) {
      if (a.length() != b.length()) {
         return false;
      }
      if (a.length() == 0 || b.length() == 0) {
         return false;
      }
      if (a.equals(b)) {
         return true;
      }
      if (a.length() <= 1) {
         return false;
      }
      boolean flag=false;
      int n = a.length();
      String key=a+" "+b;
      if(mp.containsKey(key) == true) {
         return mp.get(key);
      }
      for (int i = 1; i <= n - 1; i++) {

         boolean condition1 = solve(a.substring(0, i), b.substring(n - i, n))
               && solve(a.substring(i, n), b.substring(0, n-i));

         boolean condition2 = solve(a.substring(0, i), b.substring(0, i))
               && solve(a.substring(i, n), b.substring(i, n));

         if (condition1 || condition2) {
            flag=true;
            break;
         }
      }
      mp.put(key, flag);
      return flag;
   }

   public static void main(String[] args) {
      ScrambledString obj = new ScrambledString();
      String a="great";
      String b="taerg";
      System.out.println(obj.solve(a, b));
   }
}
