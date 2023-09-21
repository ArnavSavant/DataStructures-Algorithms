public class CountSetBits {
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count = count + countBits(i);
        }
        return count;
    }

    public static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }
}
