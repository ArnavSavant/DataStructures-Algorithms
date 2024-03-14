import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.List;

public class TopViewOfABinaryTree {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            if (!mp.containsKey(temp.col)) {
                mp.put(temp.col, temp.node.data);
            }
            if (temp.node.left != null) {
                queue.add(new Pair(temp.node.left, temp.col - 1));
            }
            if (temp.node.right != null) {
                queue.add(new Pair(temp.node.right, temp.col + 1));
            }
        }
        List<Integer> list = new ArrayList<>(mp.keySet());
        Collections.sort(list);
        for (int x : list) {
            ans.add(mp.get(x));
        }
        return ans;
    }
}
