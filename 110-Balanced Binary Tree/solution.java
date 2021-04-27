/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * Definition for node parameters.
 */
public class NodeParams {
    boolean isBalanced;
    int depth;

    NodeParams() {
    }

    ;

    NodeParams(boolean isBalanced,
               int depth) {
        this.isBalanced = isBalanced;
        this.depth = depth;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        NodeParams left = calculateParams(root.left);
        NodeParams right = calculateParams(root.right);

        return left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) < 2;
    }

    private NodeParams calculateParams(TreeNode node) {
        if (null == node) {
            return new NodeParams(true,
                                  0);
        }

        NodeParams result = new NodeParams();

        NodeParams left = calculateParams(node.left);
        NodeParams right = calculateParams(node.right);

        result.isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) < 2;
        result.depth = Math.max(left.depth, right.depth) + 1;

        return result;
    }
}