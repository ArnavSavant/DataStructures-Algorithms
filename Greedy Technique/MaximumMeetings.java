import java.util.Arrays;
import java.util.Comparator;

public class MaximumMeetings {

    public static class Pair {
        int startTime;
        int endTime;

        Pair(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }
    }

    public static class endTimeComporator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.endTime == p2.endTime) {
                return Integer.compare(p1.startTime, p2.startTime);
            }
            return Integer.compare(p1.endTime, p2.endTime);
        }
    }

    public static int maximumMeetings(int[] start, int[] end) {
        int n = start.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pairs, new endTimeComporator());
        int lastEndTime = 0;
        int maxMeetings = 0;
        for (Pair p : pairs) {
            if (p.startTime >= lastEndTime) {
                maxMeetings++;
                lastEndTime = p.endTime;
            }
        }
        return maxMeetings;
    }
}
