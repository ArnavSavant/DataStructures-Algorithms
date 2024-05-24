import java.util.ArrayList;
import java.util.List;

public class Leetcode_1319 {
    class DisjointSet {
        List<Integer> parent;
        List<Integer> size;

        DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(0);
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

        public boolean unionBySize(int u, int v) {
            int ultimateParentOfU = findParent(u);
            int ultimateParentOfV = findParent(v);
            if (ultimateParentOfU == ultimateParentOfV) {
                return false;
            }
            if (size.get(ultimateParentOfU) > size.get(ultimateParentOfV)) {
                parent.set(ultimateParentOfV, ultimateParentOfU);
                size.set(ultimateParentOfU, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
            } else if (size.get(ultimateParentOfU) < size.get(ultimateParentOfV)) {
                parent.set(ultimateParentOfU, ultimateParentOfV);
                size.set(ultimateParentOfV, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
            } else {
                parent.set(ultimateParentOfV, ultimateParentOfU);
                size.set(ultimateParentOfU, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
            }
            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraCables = 0;
        for (int connection[] : connections) {
            if (!ds.unionBySize(connection[0], connection[1])) {
                extraCables++;
            }
        }
        int noOfComponents = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                noOfComponents++;
            }
        }
        return (extraCables >= noOfComponents - 1) ? (noOfComponents - 1) : -1;
    }
}