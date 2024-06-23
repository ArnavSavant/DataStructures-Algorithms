public class Leetcode_213 {
    public int spaceOptimized(int num[]) {
        int n = num.length;
        if (n == 1) {
            return num[0];
        }
        int x = 0;
        int y = num[0];
        int curr = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int take = num[i];
            if (i > 1) {
                take = take + x;
            }
            int notTake = 0 + y;
            curr = Math.max(take, notTake);
            x = y;
            y = curr;
        }
        return curr;
    }

    public int rob(int num[]) {
        int n = num.length;
        if (n == 1) {
            return num[0];
        }
        int arr1[] = new int[n - 1];
        int arr2[] = new int[n - 1];
        int ind1 = 0, ind2 = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                arr1[ind1++] = num[i];
            }
            if (i != n - 1) {
                arr2[ind2++] = num[i];
            }
        }
        return Math.max(spaceOptimized(arr1), spaceOptimized(arr2));
    }
}
