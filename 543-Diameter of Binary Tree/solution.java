/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) return 0;

        Queue<TreeNode> queue = new LinkedList();
        List<Integer> paths = new ArrayList();
        int result = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int leftPath = 0;
            int rightPath = 0;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            paths.add(longestPath(current.left) + longestPath(current.right));
        }

        for (Integer path : paths) {
            if (path > result) result = path;
        }

        return result;
    }

    private int longestPath(TreeNode root) {
        if (root == null) return 0;
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        return left > right ? left + 1 : right + 1;
    }
}