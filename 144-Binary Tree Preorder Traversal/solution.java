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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        List<TreeNode> stack = new ArrayList<TreeNode>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = pop(stack);

            if (null != current.right) {
                stack.add(current.right);
            }

            if (null != current.left) {
                stack.add(current.left);
            }

            result.add(current.val);
        }

        return result;
    }

    private TreeNode pop(List<TreeNode> stack) {
        TreeNode node = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return node;
    }
}