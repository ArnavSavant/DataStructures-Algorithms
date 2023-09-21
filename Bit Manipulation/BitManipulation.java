public class BitManipulation {
    public static int[] bitManipulation(int num, int i) {
        int ans[] = new int[3];
        if ((num >> i - 1 & 1) == 1) {
            ans[0] = 1;
        } else {
            ans[0] = 0;
        }
        int mask = 1 << (i - 1);
        ans[1] = num | mask;
        mask = ~mask;
        ans[2] = num & mask;
        return ans;
    }
}
