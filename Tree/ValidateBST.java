public class ValidateBST {
    public static boolean isValidBST(int[] order) {
        if (order.length == 1) {
            return true;
        }
        for (int i = 0; i < order.length - 1; i++) {
            if (order[i] >= order[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
