import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int currentOccupiedPlatforms = 0;
        int minimumPlatformsRequired = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (at[i] < dt[j]) {
                currentOccupiedPlatforms++;
                minimumPlatformsRequired = Math.max(minimumPlatformsRequired, currentOccupiedPlatforms);
                i++;
            } else {
                j++;
                currentOccupiedPlatforms--;
            }
        }

        return minimumPlatformsRequired;
    }
}
