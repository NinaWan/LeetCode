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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Stack<TreeNode> stackA = new Stack();
        Stack<TreeNode> stackB = new Stack();

        stackA.push(root);

        while (!stackA.isEmpty()) {
            TreeNode current = stackA.pop();

            if (null != current.left) {
                stackA.push(current.left);
            }

            if (null != current.right) {
                stackA.push(current.right);
            }

            stackB.push(current);
        }

        while (!stackB.isEmpty()) {
            result.add(stackB.pop().val);
        }

        return result;
    }
}