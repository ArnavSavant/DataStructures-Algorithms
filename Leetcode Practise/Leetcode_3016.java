import java.util.Arrays;

public class Leetcode_3016 {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int count = 0;
        int ans = 0;
        for (int i = 26; i >= 0; i--) {
            if (freq[i] == 0) {
                continue;
            }
            if (count < 8) {
                ans = ans + freq[i];
                count++;
            } else if (count < 16) {
                ans = ans + 2 * freq[i];
                count++;
            } else if (count < 24) {
                ans = ans + 3 * freq[i];
                count++;
            } else {
                ans = ans + 4 * freq[i];
                count++;
            }
        }
        return ans;
    }
}
