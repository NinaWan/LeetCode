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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        if (null == root) return result;
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            List<Integer> currentVals = new ArrayList<Integer>();
            for (TreeNode currentNode : currentLevel) {
                // left child
                if (null != currentNode.left) {
                    nextLevel.add(currentNode.left);
                }
                // right child
                if (null != currentNode.right) {
                    nextLevel.add(currentNode.right);
                }
                // current value
                currentVals.add(currentNode.val);
            }
            result.add(currentVals);
            currentLevel = nextLevel;
        }
        return result;
    }
}