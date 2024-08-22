import java.util.List;

public class Leetcode_624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (List<Integer> arr : arrays) {
            min = Math.min(min, arr.get(0));
            max = Math.max(max, arr.get(arr.size() - 1));
        }
        return max - min;
    }
}
