public class CountGoodNumbers {
   public int countGoodNumbers(long n) {
      if (n == 1) {
         return 5;
      }
      long x = n / 2, y = n / 2;
      if (n % 2 == 1) {
         x = x + 1;
      }
      return (int) ((posPow(5, x) % 1000000007) * (posPow(4, y) % 1000000007) % 1000000007) ;
   }

   public long posPow(long x, long n) {
      if (n == 1) {
         return x % 1000000007;
      }
      return (n%2==0 ? (posPow((x*x) %1000000007, n/2) %1000000007): (x*posPow(x%1000000007, n-1) %1000000007));
   }

   public static void main(String[] args) {
      CountGoodNumbers obj = new CountGoodNumbers();
      System.out.println(obj.countGoodNumbers(50));
   }
}
