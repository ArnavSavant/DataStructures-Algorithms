import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode_752 {
    class Pair {
        StringBuilder value;
        int distance;

        Pair(StringBuilder s, int dist) {
            this.value = s;
            this.distance = dist;
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String s : deadends) {
            set.add(s);
        }
        if(set.contains("0000")) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(target);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (sb.charAt(i) == '0') {
                sb.replace(i, i + 1, "1");
                if (set.contains(sb.toString())) {
                    count++;
                }
                sb.replace(i, i + 1, "9");
                if (set.contains(sb.toString())) {
                    count++;
                }
            } else if (sb.charAt(i) == '9') {
                sb.replace(i, i + 1, "0");
                if (set.contains(sb.toString())) {
                    count++;
                }
                sb.replace(i, i + 1, "8");
                if (set.contains(sb.toString())) {
                    count++;
                }
            } else {
                sb.replace(i, i + 1, (char) (sb.charAt(i) + 1) + "");
                if (set.contains(sb.toString())) {
                    count++;
                }
                sb.replace(i, i + 1, (char) (sb.charAt(i) - 2) + "");
                if (set.contains(sb.toString())) {
                    count++;
                }
            }
        }
        if (count == 8) {
            return -1;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(new StringBuilder("0000"), 0));
        boolean visited[] = new boolean[10000];
        visited[0] = true;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            StringBuilder currentValue = new StringBuilder(node.value.toString());
            if (currentValue.toString().equals(target)) {
                return node.distance;
            }
            for (int i = 0; i < 4; i++) {
                StringBuilder newValue = new StringBuilder(currentValue);
                if (newValue.charAt(i) == '0') {
                    newValue.replace(i, i + 1, "1");
                    if (!set.contains(newValue.toString()) && !visited[Integer.parseInt(newValue.toString())]) {
                        queue.add(new Pair(new StringBuilder(newValue), node.distance + 1));
                        visited[Integer.parseInt(newValue.toString())] = true;
                    }
                    newValue.replace(i, i + 1, "9");
                    if (!set.contains(newValue.toString()) && !visited[Integer.parseInt(newValue.toString())]) {
                        queue.add(new Pair(new StringBuilder(newValue), node.distance + 1));
                        visited[Integer.parseInt(newValue.toString())] = true;
                    }
                } else if (newValue.charAt(i) == '9') {
                    newValue.replace(i, i + 1, "0");
                    if (!set.contains(newValue.toString()) && !visited[Integer.parseInt(newValue.toString())]) {
                        queue.add(new Pair(new StringBuilder(newValue), node.distance + 1));
                        visited[Integer.parseInt(newValue.toString())] = true;
                    }
                    newValue.replace(i, i + 1, "8");
                    if (!set.contains(newValue.toString()) && !visited[Integer.parseInt(newValue.toString())]) {
                        queue.add(new Pair(new StringBuilder(newValue), node.distance + 1));
                        visited[Integer.parseInt(newValue.toString())] = true;
                    }
                } else {
                    newValue.replace(i, i + 1, (char) (newValue.charAt(i) + 1) + "");
                    if (!set.contains(newValue.toString()) && !visited[Integer.parseInt(newValue.toString())]) {
                        queue.add(new Pair(new StringBuilder(newValue), node.distance + 1));
                        visited[Integer.parseInt(newValue.toString())] = true;
                    }
                    newValue.replace(i, i + 1, (char) (newValue.charAt(i) - 2) + "");
                    if (!set.contains(newValue.toString()) && !visited[Integer.parseInt(newValue.toString())]) {
                        queue.add(new Pair(new StringBuilder(newValue), node.distance + 1));
                        visited[Integer.parseInt(newValue.toString())] = true;
                    }
                }
            }
        }
        return -1;
    }
}
