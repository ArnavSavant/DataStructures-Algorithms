import java.util.Arrays;

public class Leetcode_826 {
    class Assignment implements Comparable<Assignment> {
        int difficulty;
        int profit;

        Assignment(int d, int p) {
            this.difficulty = d;
            this.profit = p;
        }

        public int compareTo(Assignment o) {
            if (this.difficulty == o.difficulty) {
                return Integer.compare(this.profit, o.profit);
            }
            return Integer.compare(this.difficulty, o.difficulty);
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Assignment job[] = new Assignment[n];

        for (int i = 0; i < n; i++) {
            job[i] = new Assignment(difficulty[i], profit[i]);
        }
        Arrays.sort(job);
        int currMax[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                currMax[0] = job[0].profit;
                continue;
            }
            currMax[i] = Math.max(currMax[i - 1], job[i].profit);
        }
        int maxProfit = 0;
        for (int x : worker) {
            int ind = findFloor(x, job, n);
            if (ind != -1) {
                maxProfit = maxProfit + (currMax[ind]);
            }
        }
        return maxProfit;
    }

    public int findFloor(int x, Assignment[] job, int n) {
        int low = 0;
        int high = n - 1;
        int ind = -1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (job[mid].difficulty > x) {
                high = mid - 1;
            } else {
                ind = Math.max(ind, mid);
                low = mid + 1;
            }
        }
        return ind;
    }
}
