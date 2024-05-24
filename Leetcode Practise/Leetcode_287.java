import java.util.HashMap;
import java.util.Map;

public class Leetcode_287 {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int x: nums) {
            if(mp.containsKey(x)) {
                return x;
            }
            else {
                mp.put(x,1);
            }
        }
        return -1;
    }
}
