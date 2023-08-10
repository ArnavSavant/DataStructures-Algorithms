public class Leetcode_121 {
   public int maxProfit(int[] prices) {
      int minPastPrice = Integer.MAX_VALUE;
      int maxProfit = Integer.MIN_VALUE;
      for (int i = 0; i < prices.length; i++) {
         minPastPrice = Math.min(minPastPrice, prices[i]);
         maxProfit = Math.max(maxProfit, prices[i] - minPastPrice);
      }
      return maxProfit;
   }
}
