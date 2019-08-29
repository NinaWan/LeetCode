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
    public int findSecondMinimumValue(TreeNode root) {
        if (null == root) {
            return -1;
        }

        int min = root.val;
        int secondMin = -1;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (null != current.left) {
                stack.push(current.left);
            }
            if (null != current.right) {
                stack.push(current.right);
            }
            if (current.val > min && (current.val < secondMin || secondMin == -1)) {
                secondMin = current.val;
            }
        }

        return secondMin;
    }

}