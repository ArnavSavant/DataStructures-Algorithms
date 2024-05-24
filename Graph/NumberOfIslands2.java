import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {
    class DisjointSet {
        List<Integer> parent;
        List<Integer> size;

        DisjointSet(int n) {
            size = new ArrayList<>();
            parent = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                size.add(0);
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (parent.get(node) == node) {
                return node;
            }
            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }

        public void unionBySize(int u, int v) {
            int ultimateParentOfU = findParent(u);
            int ultimateParentOfV = findParent(v);
            if (ultimateParentOfU == ultimateParentOfV) {
                return;
            }
            if (size.get(ultimateParentOfU) > size.get(ultimateParentOfV)) {
                parent.set(ultimateParentOfV, ultimateParentOfU);
                size.set(ultimateParentOfU, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));

            } else if (size.get(ultimateParentOfV) > size.get(ultimateParentOfU)) {
                parent.set(ultimateParentOfU, ultimateParentOfV);
                size.set(ultimateParentOfV, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
            } else {
                parent.set(ultimateParentOfV, ultimateParentOfU);
                size.set(ultimateParentOfU, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
            }
        }

    }

    public int[] numberOfIslandII(int n, int m, int[][] queries, int q) {
        DisjointSet ds = new DisjointSet(n * m - 1);
        int numberOfIslands[] = new int[q];
        int currIslands = 0;
        int grid[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 0);
        }
        for (int i = 0; i < q; i++) {
            int row = queries[i][0];
            int col = queries[i][1];
            int node = row * n + col;
            grid[row][col] = 1;
            currIslands++;
            int[] dRow = { 1, 0, -1, 0 };
            int[] dCol = { 0, 1, 0, -1 };
            for (int j = 0; j < 4; j++) {
                int newRow = row + dRow[j];
                int newCol = col + dCol[j];
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
                    continue;
                } else if (grid[newRow][newCol] == 1) {
                    int newNode = newRow * n + newCol;
                    if (ds.findParent(node) != ds.findParent(newNode)) {
                        ds.unionBySize(node, newNode);
                        currIslands--;
                    }

                }
            }
            numberOfIslands[i] = currIslands;
        }
        return numberOfIslands;
    }
}
