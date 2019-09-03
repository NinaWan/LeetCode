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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (null == root) {
            return result;
        }

        if (null == root.left && null == root.right) {
            result.add(String.valueOf(root.val));
            return result;
        }

        if (null != root.left) {
            List<String> leftPaths = binaryTreePaths(root.left);
            for (int i = 0; i < leftPaths.size(); i++) {
                result.add(String.valueOf(root.val) + "->" + leftPaths.get(i));
            }
        }

        if (null != root.right) {
            List<String> rightPaths = binaryTreePaths(root.right);
            for (int i = 0; i < rightPaths.size(); i++) {
                result.add(String.valueOf(root.val) + "->" + rightPaths.get(i));
            }
        }

        return result;
    }
}