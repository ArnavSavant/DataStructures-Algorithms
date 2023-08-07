public class NthRootOfANumber {
   public void solve(int n, int m) { // m-->nummber
      int low = 1;
      int high = m;
      double eps = 1.0/10000;
      while((high-low)>eps) {
         double mid = (low + high)/2;
         if(multiply(n,mid)<m) {
            low=(int)mid;
         }
         else {
            high = (int)mid;
         }
      }
      System.out.println(low+"  "+high);  
   }

   public double multiply(int n, double number) {
      double ans = 1;
      for (int i = 1; i <= n; i++) {
         ans = ans * number;
      }
      return ans;
   }
   public static void main(String[] args) {
      NthRootOfANumber obj = new NthRootOfANumber();
      // System.out.println("hello");
      obj.solve(2, 9);
      // System.out.println("exit");
   }
}
