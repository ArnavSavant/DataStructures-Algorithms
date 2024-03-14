import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
    public static String getAlienLanguage(String[] dictionary, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < dictionary.length - 1; i++) {
            String first = dictionary[i];
            String second = dictionary[i + 1];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    graph.get(first.charAt(j) - 'a').add(second.charAt(j) - 'a');
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean[] visited = new boolean[k];
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                dfs(i, visited, sb, graph);
            }
        }
        return sb.reverse().toString(); // Reverse the string before returning
    }

    public static void dfs(int node, boolean[] visited, StringBuffer sb, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, sb, graph);
            }
        }
        sb.append((char) (node + 97)); // Append the character after visiting all neighbours
    }
}
