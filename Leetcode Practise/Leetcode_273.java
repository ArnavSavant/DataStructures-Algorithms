import java.util.HashMap;
import java.util.Map;

public class Leetcode_273 {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        Map<Integer, String> map = new HashMap<>();
        fillMap(map);
        StringBuilder sb = new StringBuilder();

        String[] units = { "", "Thousand", "Million", "Billion" };
        int unitIndex = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String segment = toWords(num % 1000, map);
                if (!segment.isEmpty()) {
                    sb.insert(0, segment + " " + units[unitIndex] + " ");
                }
            }
            num /= 1000;
            unitIndex++;
        }

        return sb.toString().trim();
    }

    public void fillMap(Map<Integer, String> map) {
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
    }

    public String toWords(int num, Map<Integer, String> map) {
        if (num == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        // Hundred's place
        int x = num / 100;
        if (x > 0) {
            sb.append(map.get(x)).append(" ").append(map.get(100)).append(" ");
        }

        // Ten's place
        num = num % 100;
        if (num >= 20) {
            x = num / 10;
            sb.append(map.get(x * 10)).append(" ");
            num = num % 10;
        }

        // Unit's place and teens
        if (num > 0) {
            sb.append(map.get(num)).append(" ");
        }

        return sb.toString().trim();
    }
}
