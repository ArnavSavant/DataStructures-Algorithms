public class TwoNumbersWithOddOccurrences {
    public static int[] twoOddNum(int[] arr) {
        int ans[] = new int[2];
        int XOR = 0;
        int rightMostSetBitMask = 0;
        for (int x : arr) {
            XOR = XOR ^ x;
        }
        rightMostSetBitMask = XOR & -XOR; // (-XOR = (~XOR + 1)) --> 2's complement
        int xor1 = 0;
        int xor2 = 0;
        for (int x : arr) {
            if ((rightMostSetBitMask & x) == 0) {
                xor1 = xor1 ^ x;
            } else {
                xor2 = xor2 ^ x;
            }
        }
        if (xor1 > xor2) {
            ans[0] = xor1;
            ans[1] = xor2;
        } else {
            ans[0] = xor2;
            ans[1] = xor1;
        }
        return ans;
    }
}
