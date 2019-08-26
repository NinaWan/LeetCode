/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) {
            return true;
        }

        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        if (left && right) {
            Integer leftMax = findMax(root.left);
            Integer rightMin = findMin(root.right);

            if ((null == leftMax || leftMax < root.val) && (null == rightMin || rightMin > root.val)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Integer findMax(TreeNode root) {
        TreeNode current = root;
        while (null != current && null != current.right) {
            current = current.right;
        }

        return null == current ? null : current.val;
    }

    public Integer findMin(TreeNode root) {
        TreeNode current = root;
        while (null != current && null != current.left) {
            current = current.left;
        }

        return null == current ? null : current.val;
    }
}