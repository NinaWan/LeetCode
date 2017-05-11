/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size() != 0){
            TreeNode current = queue.poll();
            // Left node
            if(null != current.left){
                if(null == current.left.left && null == current.left.right) result += current.left.val;
                queue.add(current.left);
            }

            // Right node
            if(null != current.right){
                queue.add(current.right);
            }
        }

        return result;
    }
}