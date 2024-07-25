import java.util.ArrayList;
import java.util.List;

public class Leetcode_1568 {
    public int timer = 0;

    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int noOfComponents = getComponents(grid, m, n);

        if (noOfComponents == 0 || noOfComponents > 1) {
            return 0;
        }

        List<List<Integer>> graph = new ArrayList<>();
        int noOfLandCells = createGraph(graph, m, n, grid);

        if (noOfLandCells == 1) {
            return 1;
        }

        int[] time = new int[m * n];
        int[] low = new int[m * n];
        boolean[] visited = new boolean[m * n];
        boolean[] articulated = new boolean[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs2(i * n + j, -1, graph, visited, time, low, articulated);
                    break;
                }
            }
        }

        for (boolean x : articulated) {
            if (x) {
                return 1;
            }
        }

        return 2;
    }

    public int getComponents(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int noOfComponents = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs1(grid, i, j, m, n, visited);
                    noOfComponents++;
                }
            }
        }
        return noOfComponents;
    }

    public int createGraph(List<List<Integer>> graph, int m, int n, int[][] grid) {
        int v = m * n;
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        int noOfLandCells = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    noOfLandCells++;
                    int dRow[] = { 0, 1, 0, -1 };
                    int dCol[] = { 1, 0, -1, 0 };
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dRow[k];
                        int newCol = j + dCol[k];
                        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                            continue;
                        } else if (grid[newRow][newCol] == 1) {
                            graph.get(i * n + j).add(newRow * n + newCol);
                        }
                    }
                }
            }
        }
        return noOfLandCells;
    }

    public void dfs1(int[][] grid, int row, int col, int m, int n, boolean[][] visited) {
        visited[row][col] = true;
        int dRow[] = { 1, 0, -1, 0 };
        int dCol[] = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            } else if (grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs1(grid, newRow, newCol, m, n, visited);
            }
        }
    }

    public void dfs2(int node, int parent, List<List<Integer>> graph, boolean[] visited, int[] time, int[] low,
            boolean[] articulated) {
        visited[node] = true;
        time[node] = timer;
        low[node] = timer;
        timer++;
        int child = 0;
        for (int neighbour : graph.get(node)) {
            if (neighbour == parent) {
                continue;
            }
            if (!visited[neighbour]) {
                dfs2(neighbour, node, graph, visited, time, low, articulated);
                low[node] = Math.min(low[node], low[neighbour]);
                if (low[neighbour] >= time[node] && parent != -1) {
                    articulated[node] = true;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], time[neighbour]);
            }
        }
        if (child > 1 && parent == -1) {
            articulated[node] = true;
        }
    }
}
