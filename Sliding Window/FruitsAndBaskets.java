import java.util.HashMap;
import java.util.Map;

public class FruitsAndBaskets {
    public static int findMaxFruits(int[] arr, int n) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int maxFruits = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (mp.containsKey(arr[j])) {
                mp.put(arr[j], mp.get(arr[j]) + 1);
            } else {
                mp.put(arr[j], 1);
            }
            if (mp.size() == 2) {
                maxFruits = Math.max(maxFruits, j - i + 1);
            } else if (mp.size() > 2) {
                while (mp.size() > 2) {
                    mp.put(arr[i], mp.get(arr[i]) - 1);
                    if (mp.get(arr[i]) == 0) {
                        mp.remove(arr[i]);
                    }
                    i++;
                }
                maxFruits = Math.max(maxFruits, j - i + 1);
            }
            j++;
        }
        return maxFruits;
    }
}
