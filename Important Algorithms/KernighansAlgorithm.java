public class KernighansAlgorithm {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int rightMostSetBitMask = n & (-n);
            n = n - rightMostSetBitMask;
            count++;
        }
        return count;
    }
}
