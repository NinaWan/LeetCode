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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        TreeNode max = root;
        Stack<TreeNode> stack = new Stack();
        boolean inserted = false;

        while (null != current || !stack.isEmpty()) {
            if (null == current) {
                current = stack.pop();
                // compare current value and target value
                if (current.val > val) {
                    if (null == current.left) {
                        current.left = new TreeNode(val);
                    } else {
                        max.right = new TreeNode(val);
                    }
                    inserted = true;
                    break;
                }
                max = current;
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }

        if (!inserted) {
            max.right = new TreeNode(val);
        }

        return root;
    }
}