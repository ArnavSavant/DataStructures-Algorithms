import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class Leetcode_1002 {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> initialMap = new HashMap<>();
        for (char x : words[0].toCharArray()) {
            initialMap.put(x, initialMap.getOrDefault(x, 0) + 1);
        }
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> mp = new HashMap<>();
            for (char x : words[i].toCharArray()) {
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }
            Iterator<Map.Entry<Character, Integer>> iterator = initialMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                char key = entry.getKey();
                if (mp.containsKey(key)) {
                    initialMap.put(key, Math.min(entry.getValue(), mp.get(key)));
                } else {
                    iterator.remove();
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : initialMap.entrySet()) {
            char key = entry.getKey();
            int freq = entry.getValue();
            while (freq-- != 0) {
                ans.add(Character.toString(key));
            }
        }
        return ans;
    }
}
