public class MinMax {
    public int min(int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            min = Math.min(x, min);
        }
        return min;
    }

    public int max(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            max = Math.max(x, max);
        }
        return max;
    }
}
