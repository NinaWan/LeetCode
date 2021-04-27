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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (null == t)
            return true;
        if (null == s)
            return false;

        Queue<TreeNode> sQueue = new LinkedList();
        sQueue.add(s);

        while (!sQueue.isEmpty()) {
            TreeNode current = sQueue.poll();
            if (current.left != null)
                sQueue.add(current.left);
            if (current.right != null)
                sQueue.add(current.right);
            if (isIdentical(current, t))
                return true;
        }

        return false;
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s != null && t != null && s.val != t.val)
            return false;
        if ((s == null && t != null) || (t == null && s != null))
            return false;

        if (isIdentical(s.left, t.left) && isIdentical(s.right, t.right))
            return true;
        return false;
    }
}