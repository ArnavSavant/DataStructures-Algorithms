import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctIslands {
    public static int distinctIsland(int[][] arr, int n, int m) {
        boolean visited[][] = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    List<String> list = new ArrayList<>();
                    dfs(arr, n, m, visited, i, j, i, j, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    public static String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }

    public static void dfs(int[][] arr, int n, int m, boolean[][] visited, int row, int col, int baseRow, int baseCol, List<String> list) {
        visited[row][col] = true;
        list.add(toString(row - baseRow, col - baseCol));
        if (row + 1 < n && arr[row + 1][col] == 1 && !visited[row + 1][col]) {
            dfs(arr, n, m, visited, row + 1, col, baseRow, baseCol, list);
        }
        if (col + 1 < m && arr[row][col + 1] == 1 && !visited[row][col + 1]) {
            dfs(arr, n, m, visited, row, col + 1, baseRow, baseCol, list);
        }
        if (row - 1 >= 0 && arr[row - 1][col] == 1 && !visited[row - 1][col]) {
            dfs(arr, n, m, visited, row - 1, col, baseRow, baseCol, list);
        }
        if (col - 1 >= 0 && arr[row][col - 1] == 1 && !visited[row][col - 1]) {
            dfs(arr, n, m, visited, row, col - 1, baseRow, baseCol, list);
        }
    }
}
