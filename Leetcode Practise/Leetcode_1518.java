public class Leetcode_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int filled = numBottles;
        int emptied = 0;
        while (filled > 0) {
            ans = ans + filled;
            emptied = emptied + filled;
            filled = emptied / numExchange;
            emptied = emptied % numExchange;
        }
        return ans;
    }
}
