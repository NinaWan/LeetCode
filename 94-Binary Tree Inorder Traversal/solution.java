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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        List<TreeNode> stack = new ArrayList<>();
        TreeNode current = root;

        while (null != current || !stack.isEmpty()) {
            if (null == current) {
                current = pop(stack);
                result.add(current.val);
                current = current.right;
            } else {
                stack.add(current);
                current = current.left;
            }
        }

        return result;
    }

    private TreeNode pop(List<TreeNode> stack) {
        TreeNode node = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return node;
    }
}