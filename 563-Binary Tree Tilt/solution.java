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
    public int findTilt(TreeNode root) {
        if (null == root)
            return 0;
        return findTilt(root.left) + findTilt(root.right) + Math.abs(subtreeSum(root.left) - subtreeSum(root.right));
    }

    private int subtreeSum(TreeNode root) {
        if (null == root)
            return 0;
        return subtreeSum(root.left) + subtreeSum(root.right) + root.val;
    }
}