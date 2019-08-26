/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    Stack<TreeNode> stack = new Stack();

    public BSTIterator(TreeNode root) {
        TreeNode current = root;
        while (null != current) {
            this.stack.push(current);
            current = current.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode current = stack.pop();
        TreeNode temp = current.right;

        if (null != temp) {
            stack.push(temp);
            temp = temp.left;
        }

        while (null != temp) {
            stack.push(temp);
            temp = temp.left;
        }

        return current.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */