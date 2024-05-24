import java.util.Arrays;

public class Leetcode_3116 {
    public long findKthSmallest(int[] coins, int k) {
        if (coins.length == 1) {
            return coins[0] * (long) k;
        }
        Arrays.sort(coins);
        long low = coins[0];
        if (low == 1) {
            return k;
        }
        long high = coins[coins.length - 1];
        high = high * k;
        long ans = 0;
        while (low <= high) {
            long mid = high - (high - low) / 2;
            long pos = findPosition(mid, coins);
            if (pos < k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    private long findPosition(long value, int[] coins) {
        int n = coins.length;
        long count = 0;
        int bitMask = (1 << n) - 1;
        for (int mask = 1; mask <= bitMask; mask++) {
            long lcm = 1;
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    long newLCM = lcm / gcd(lcm, coins[i]) * coins[i];
                    if (newLCM > value || newLCM <= 0) {
                        lcm = value + 1;
                        break;
                    }
                    lcm = newLCM;
                }
            }
            if (bits % 2 == 1) {
                count += value / lcm;
            } else {
                count -= value / lcm;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
