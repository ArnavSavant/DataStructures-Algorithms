public class Leetcode_3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < (colors.length + k - 1)) {
            if (colors[j % colors.length] == colors[(j + 1) % colors.length]) {
                i = j + 1;
            }
            if (j - i + 1 < k) {
                j++;
            }
            if (j - i + 1 == k) {
                count++;
                i++;
            }
        }
        return count;
    }
}
