public class Leetcode_3206 {
    public int numberOfAlternatingGroups(int[] colors) {
        int left = 0;
        int centre = 1;
        int right = 2;
        int ans = 0;
        while (left < colors.length) {
            if ((colors[left % colors.length] == colors[right % colors.length])
                    && (colors[left % colors.length] != colors[centre % colors.length])) {
                ans++;
            }
            left++;
            right++;
            centre++;
        }
        return ans;
    }
}
