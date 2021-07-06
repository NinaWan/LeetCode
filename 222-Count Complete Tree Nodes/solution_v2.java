/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            l = l.left;
            hl++;
        }

        while (r != null) {
            r = r.right;
            hr++;
        }

        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}