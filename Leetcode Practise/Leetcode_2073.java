public class Leetcode_2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int temp = tickets[k];
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] < temp) {
                time = time + tickets[i];
            } else {
                if (i <= k) {
                    time = time + temp;
                } else {
                    time = time + (temp - 1);
                }
            }
        }
        return time;
    }
}