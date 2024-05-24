import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_827 {
    class DisjointSet {
        List<Integer> parent;
        List<Integer> size;

        DisjointSet(int n) {
            size = new ArrayList<>();
            parent = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                size.add(1);
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

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int dRow[] = { 1, 0, -1, 0 };
                    int dCol[] = { 0, 1, 0, -1 };
                    int node = i * n + j;
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dRow[k];
                        int newCol = j + dCol[k];
                        if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                            continue;
                        }
                        if (grid[newRow][newCol] == 1) {
                            int newNode = newRow * n + newCol;
                            ds.unionBySize(node, newNode);
                        }
                    }
                }
            }
        }
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int dRow[] = { 1, 0, -1, 0 };
                    int dCol[] = { 0, 1, 0, -1 };
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dRow[k];
                        int newCol = j + dCol[k];
                        if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                            continue;
                        }
                        if (grid[newRow][newCol] == 1) {
                            set.add(ds.findParent(newRow * n + newCol));
                        }
                    }
                    int current = 1;
                    for (int x : set) {
                        current = current + ds.size.get(x);
                    }
                    largest = Math.max(largest, current);
                }
            }
        }
        return largest == Integer.MIN_VALUE ? n * n : largest;
    }
}
