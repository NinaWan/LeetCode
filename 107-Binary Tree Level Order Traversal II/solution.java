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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        List<TreeNode> rootList = new ArrayList<TreeNode>();
        rootList.add(root);
        List<TreeNode> currentLevel = rootList;

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> firstElement = new ArrayList<Integer>();
        firstElement.add(root.val);
        result.add(firstElement);

        while (!isLeafLevel(currentLevel)) {
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            List<Integer> nextLevelVals = new ArrayList<Integer>();
            for (TreeNode node : currentLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                    nextLevelVals.add(node.left.val);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                    nextLevelVals.add(node.right.val);
                }
            }
            currentLevel = nextLevel;
            result.add(0, nextLevelVals);
        }
        return result;
    }

    private boolean isLeafLevel(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            if (node.left != null || node.right != null)
                return false;
        }
        return true;
    }
}