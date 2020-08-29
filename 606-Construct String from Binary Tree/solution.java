/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }

        String rString = t.right == null ? "" : tree2str(t.right);
        String lString = t.left == null ? "" : tree2str(t.left);

        if (t.left == null && t.right != null) {
            return t.val + "()" + "(" + rString + ")";
        } else if (t.right == null) {
            return t.val + "(" + lString + ")";
        } else {
            return t.val + "(" + lString + ")" + "(" + rString + ")";
        }
    }
}