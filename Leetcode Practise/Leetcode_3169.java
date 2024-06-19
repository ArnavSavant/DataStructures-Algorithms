import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_3169 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        int start = 0;
        int end = 0;
        int ans = 0;
        for (int[] meeting : meetings) {
            if (start == 0 && end == 0) {
                start = meeting[0];
                end = meeting[1];
                ans += start - 1;
            } else {
                if (meeting[0] <= end) {
                    end = Math.max(end, meeting[1]);
                } else {
                    ans += meeting[0] - end - 1;
                    start = meeting[0];
                    end = meeting[1];
                }
            }
        }
        if (end < days) {
            ans += days - end;
        }
        return ans;
    }
}
