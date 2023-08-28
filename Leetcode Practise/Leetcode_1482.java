public class Leetcode_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 0;
        int high = findMax(bloomDay);
        int minDay = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (isPossibleToMakeBoquet(bloomDay, m, k, mid)) {
                minDay = Math.min(mid,minDay);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(minDay == Integer.MAX_VALUE) {
            return -1;
        }
        return minDay;
    }

    public boolean isPossibleToMakeBoquet(int[] bloomDay, int m, int k, int day) {
        int boquetMadeTillNow = 0;
        int flowersRequired = k;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowersRequired--;
            } else {
                flowersRequired = k;
            }
            if (flowersRequired == 0) {
                boquetMadeTillNow++;
                flowersRequired = k;
            }
            if (boquetMadeTillNow == m) {
                return true;
            }
        }
        return false;
    }

    public int findMax(int arr[]) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
