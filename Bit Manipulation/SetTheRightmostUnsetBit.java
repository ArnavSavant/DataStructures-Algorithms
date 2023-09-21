public class SetTheRightmostUnsetBit {
    public static int setBits(int N) {
        if (((N + 1) ^ N) == ((N << 1) + 1)) {
            return N;
        }
        return (N | (N + 1));
    }
}
