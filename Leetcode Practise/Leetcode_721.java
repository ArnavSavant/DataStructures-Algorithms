import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode_721 {
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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (mp.containsKey(accounts.get(i).get(j))) {
                    ds.unionBySize(mp.get(accounts.get(i).get(j)), i);
                } else {
                    mp.put(accounts.get(i).get(j), i);
                }
            }
        }
        List<List<String>> merged = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            merged.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            int parent = ds.findParent(entry.getValue());
            if (merged.get(parent).size() == 0) {
                merged.get(parent).add(accounts.get(parent).get(0));
            }
            merged.get(parent).add(entry.getKey());
        }
        for (int i = 0; i < merged.size();) {
            if (merged.get(i).isEmpty()) {
                merged.remove(i);
            } else {
                i++;
            }
        }
        return merged;
    }
}
