public class FindXOR {
    public static int findXOR(int L, int R) {
        int xor1 = findXOR(L - 1);
        int xor2 = findXOR(R);
        return xor1 ^ xor2;
    }

    public static int findXOR(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }
}
