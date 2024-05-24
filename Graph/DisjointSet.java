import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
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
