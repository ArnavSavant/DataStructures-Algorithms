import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_947 {
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

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        for (int stone[] : stones) {
            ds.unionBySize(stone[0], stone[1] + maxRow + 1);
            stoneNodes.put(stone[0], 1);
            stoneNodes.put(stone[1] + maxRow + 1, 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : stoneNodes.entrySet()) {
            if (ds.findParent(entry.getKey()) == entry.getKey()) {
                count++;
            }
        }
        return n - count;
    }
}