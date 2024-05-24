import java.util.ArrayList;
import java.util.List;

public class Leetcode_1992 {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        boolean visited[][] = new boolean[m][n];
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int end[] = new int[2];
                    dfs(land, i, j, end, visited, m, n);
                    List<Integer> cords = new ArrayList<>();
                    cords.add(i);
                    cords.add(j);
                    cords.add(end[0]);
                    cords.add(end[1]);
                    temp.add(cords);
                }
            }
        }
        int ans[][] = new int[temp.size()][4];
        for (int i = 0; i < temp.size(); i++) {
            List<Integer> cords = temp.get(i);
            ans[i][0] = cords.get(0);
            ans[i][1] = cords.get(1);
            ans[i][2] = cords.get(2);
            ans[i][3] = cords.get(3);
        }
        return ans;
    }

    public void dfs(int[][] land, int row, int col, int end[], boolean[][] visited, int m, int n) {
        visited[row][col] = true;
        if (row >= end[0]) {
            end[0] = row;
        }
        if (col >= end[1]) {
            end[1] = col;
        }
        int dRow[] = { 1, 0, -1, 0 };
        int dCol[] = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            } else if (land[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(land, newRow, newCol, end, visited, m, n);
            }
        }
    }
}
