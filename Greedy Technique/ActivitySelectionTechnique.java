import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionTechnique {

    // Function to perform activity selection using the greedy approach
    public static void selectActivities(int[] startTimes, int[] endTimes) {
        // Ensure both arrays are of the same length
        if (startTimes.length != endTimes.length) {
            throw new IllegalArgumentException("Input arrays must have the same length");
        }

        // Create an array of activities with start and end times
        Activity[] activities = new Activity[startTimes.length];
        for (int i = 0; i < startTimes.length; i++) {
            activities[i] = new Activity(startTimes[i], endTimes[i]);
        }

        // Sort the activities based on their end times
        Arrays.sort(activities, Comparator.comparingInt(a -> a.endTime));

        // Select the first activity
        System.out.println("Selected Activity: " + activities[0]);

        // Iterate through the sorted activities and select compatible ones
        int prevActivityEnd = activities[0].endTime;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].startTime >= prevActivityEnd) {
                System.out.println("Selected Activity: " + activities[i]);
                prevActivityEnd = activities[i].endTime;
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9};

        selectActivities(startTimes, endTimes);
    }

    // Activity class to represent individual activities
    static class Activity {
        int startTime;
        int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "(" + startTime + ", " + endTime + ")";
        }
    }
}
