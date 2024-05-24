import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class MinimumSpaningTreeUsingDisjointSet {
    class DisjointSet {
        List<Integer> rank;
        List<Integer> parent;
        List<Integer> size;

        DisjointSet(int n) {
            rank = new ArrayList<>();
            size = new ArrayList<>();
            parent = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                rank.add(0);
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

        public void unionByRank(int u, int v) {
            int ultimateParentOfU = findParent(u);
            int ultimateParentOfV = findParent(v);
            if (ultimateParentOfU == ultimateParentOfV) {
                return;
            }
            if (rank.get(ultimateParentOfU) > rank.get(ultimateParentOfV)) {
                parent.set(ultimateParentOfV, ultimateParentOfU);
            } else if (rank.get(ultimateParentOfV) > rank.get(ultimateParentOfU)) {
                parent.set(ultimateParentOfU, ultimateParentOfV);
            } else {
                parent.set(ultimateParentOfV, ultimateParentOfU);
                rank.set(ultimateParentOfU, rank.get(ultimateParentOfU) + 1);
            }
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

    public int spannigTree(int[][] edges, int v) {
        Arrays.sort(edges, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });

        DisjointSet ds = new DisjointSet(v);
        int mstWeight = 0;
        for (int edge[] : edges) {
            if (ds.findParent(edge[0]) != ds.findParent(edge[1])) {
                mstWeight = edge[2];
                ds.unionBySize(edge[0], edge[1]);
            }
        }
        return mstWeight;
    }
}
