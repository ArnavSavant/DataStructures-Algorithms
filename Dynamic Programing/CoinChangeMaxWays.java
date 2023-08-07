public class CoinChangeMaxWays {
   public int coinChangeMaxWays(int coins[], int n, int sum) {
      int t[][] = new int[n + 1][sum + 1];
      for (int i = 0; i <= sum; i++) {
         t[0][i] = 0;
      }
      for (int i = 0; i <= n; i++) {
         t[i][0] = 1;
      }
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= sum; j++) {
            if (coins[i - 1] <= j) {
               t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][sum];
   }

   // recurssive code
   // public int coinChangeMaxWays(int coins[], int n, int sum) {
   //    if(n == 0) {
   //       return 0;
   //    }
   //    if(sum == 0) {
   //       return 1;
   //    }
   //    if(coins[n-1]>sum) {
   //       return coinChangeMaxWays(coins, n-1, sum);
   //    }
   //    return coinChangeMaxWays(coins, n, sum-coins[n-1])+coinChangeMaxWays(coins, n-1, sum);
   // }
   public static void main(String[] args) {
      CoinChangeMaxWays obj = new CoinChangeMaxWays();
      int coins[]={1,2,3};
      System.out.println(obj.coinChangeMaxWays(coins, coins.length, 5 ));
   }
}