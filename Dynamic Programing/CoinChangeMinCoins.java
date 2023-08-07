public class CoinChangeMinCoins {
   public int coinChangeMinCoins(int coins[], int n, int sum) {
      int t[][] = new int[n + 1][sum + 1];
      for (int i = 0; i <= n; i++) {
         t[i][0] = 0; // because for making sum '0' we need zero coins
      }
      for (int i = 0; i <= sum; i++) {
         t[0][i] = Integer.MAX_VALUE - 1; // because we need infinte coins of value '0' to make a sum
      }
      for (int i = 1; i <= sum; i++) { // initialising second row because if we have just one coin which is not the
                                       // multiple of sum then we can never make the required sum
         if (i % coins[0] == 0) {
            t[1][i] = i / coins[0];
         } else {
            t[1][i] = Integer.MAX_VALUE - 1;
         }
      }
      for (int i = 2; i <= n; i++) {
         for (int j = 1; j <= sum; j++) {
            if (coins[i - 1] <= j) {
               t[i][j] = Math.min((1 + t[i][j - coins[i - 1]]), t[i - 1][j]);
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][sum];
   }

   public static void main(String[] args) {
      CoinChangeMinCoins obj = new CoinChangeMinCoins();
      int coins[] = { 3, 4, 2, 1};
      System.out.println(obj.coinChangeMinCoins(coins, coins.length, 10));
   }
}
