public class Leetcode_3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalBottlesDrunk = 0;
        while (numBottles >= numExchange) {
            numBottles = numBottles - numExchange;
            totalBottlesDrunk = totalBottlesDrunk + numExchange;
            numExchange++;
            numBottles++;
        }
        return totalBottlesDrunk + numBottles;
    }
}
