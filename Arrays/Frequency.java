import java.util.Map;
import java.util.HashMap;

public class Frequency {
    public void findFrequency(int arr[]) {
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int x: arr) {
            if(mp.containsKey(x)) {
                mp.put(x,mp.get(x)+1);
            }
            else {
                mp.put(x, 1);
            }
        }
        System.out.println(mp);
    }
    public static void main(String[] args) {
        Frequency obj = new Frequency();
        int arr[] = {1,4,7,8,1,1,4,7,7,8};
        obj.findFrequency(arr);
    }
}