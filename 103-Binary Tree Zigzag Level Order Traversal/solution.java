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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (null == root) {
            return result;
        }

        List<TreeNode> leftToRight = new ArrayList<>();
        List<TreeNode> rightToLeft = new ArrayList<>();
        leftToRight.add(root);


        while (leftToRight.size() != 0 || rightToLeft.size() != 0) {
            if (leftToRight.size() != 0) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < leftToRight.size(); i++) {
                    temp.add(leftToRight.get(i).val);
                }

                result.add(temp);

                while (leftToRight.size() != 0) {
                    TreeNode current = leftToRight.get(leftToRight.size() - 1);
                    if (current.right != null) {
                        rightToLeft.add(current.right);
                    }
                    if (current.left != null) {
                        rightToLeft.add(current.left);
                    }
                    leftToRight.remove(leftToRight.size() - 1);
                }
            } else {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < rightToLeft.size(); i++) {
                    temp.add(rightToLeft.get(i).val);
                }

                result.add(temp);

                while (rightToLeft.size() != 0) {
                    TreeNode current = rightToLeft.get(rightToLeft.size() - 1);
                    if (current.left != null) {
                        leftToRight.add(current.left);
                    }
                    if (current.right != null) {
                        leftToRight.add(current.right);
                    }
                    rightToLeft.remove(rightToLeft.size() - 1);
                }
            }
        }

        return result;
    }
}