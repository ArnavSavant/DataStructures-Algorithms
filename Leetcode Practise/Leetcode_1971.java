import java.util.ArrayList;
import java.util.List;

public class Leetcode_1971 {
    class DisjointSet {
        List<Integer> parent;
        List<Integer> size;

        DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
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
                size.set(ultimateParentOfU, size.get(ultimateParentOfV) + size.get(ultimateParentOfV));
            } else if (size.get(ultimateParentOfV) > size.get(ultimateParentOfU)) {
                parent.set(ultimateParentOfU, ultimateParentOfV);
                size.set(ultimateParentOfV, size.get(ultimateParentOfV) + size.get(ultimateParentOfV));
            } else {
                parent.set(ultimateParentOfV, ultimateParentOfU);
                size.set(ultimateParentOfU, size.get(ultimateParentOfV) + size.get(ultimateParentOfV));
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : edges) {
            ds.unionBySize(edge[0], edge[1]);
        }
        if (ds.findParent(source) == ds.findParent(destination)) {
            return true;
        } else {
            return false;
        }
    }
}
