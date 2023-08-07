import java.util.ArrayList;
import java.util.List;

public class hello {
   public List<String> addOperators(String num, int target) {
      List<String> ans = new ArrayList<String>();
      solve(num.length(), target, ans, new StringBuffer(num), 1);
      return ans;
   }

   public void solve(int length, int target, List<String> ans, StringBuffer b, int i) {

      if (i <= ((length * 2) - 1)) {
         String s = new String(b.toString());
         if (soln(b) == target) {
            ans.add(s);
         }
         b.replace(0, b.length(), s);
         return;
      }
      for(int j=0;j<=length;j++) {
         
      }
      b.insert(i, "*");
      solve(length, target, ans, b, i + 2);
      b.deleteCharAt(i);

      b.insert(i, "+");
      solve(length, target, ans, b, i + 2);
      b.deleteCharAt(i);

      b.insert(i, "-");
      solve(length, target, ans, b, i + 2);
      b.deleteCharAt(i);
   }

   public int soln(StringBuffer b) {
      int i=0;
      int j=0;
      int k=j;
      while(k<b.length()) {
         i++;
      }
      i=i+1;
      return Integer.valueOf(b.toString());
   }

   public static void main(String[] args) {
      hello obj = new hello();
      List<String> list = new ArrayList<String>();
      list = obj.addOperators("123", 6);
      System.out.println(list);
   }
}