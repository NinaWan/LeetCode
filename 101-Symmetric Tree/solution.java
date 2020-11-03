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
    public boolean isSymmetric(TreeNode root) {
        if (null == root || (root.left == null && root.right == null))
            return true;
        Queue<TreeNode> leftQueue = new LinkedList();
        Queue<TreeNode> rightQueue = new LinkedList();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftRoot = leftQueue.poll();
            TreeNode rightRoot = rightQueue.poll();
            if (leftRoot == null && rightRoot == null)
                continue;
            if (leftRoot == null || rightRoot == null)
                return false;
            if (leftRoot.val != rightRoot.val)
                return false;
            leftQueue.add(leftRoot.left);
            leftQueue.add(leftRoot.right);
            rightQueue.add(rightRoot.right);
            rightQueue.add(rightRoot.left);
        }

        return true;
    }
}