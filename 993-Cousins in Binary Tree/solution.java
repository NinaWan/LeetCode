/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class TreeNodeWrapper {
    TreeNode parent;
    TreeNode node;

    TreeNodeWrapper(TreeNode node,
                    TreeNode parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNodeWrapper> queueA = new LinkedList();
        queueA.add(new TreeNodeWrapper(root,
                                       null));
        Queue<TreeNodeWrapper> queueB = new LinkedList();

        while (queueA.size() != 0 || queueB.size() != 0) {
            TreeNodeWrapper xNode = null;
            TreeNodeWrapper yNode = null;

            if (queueA.size() != 0) {
                while (queueA.size() != 0) {
                    TreeNodeWrapper current = queueA.poll();
                    if (null != current.node.left) {
                        queueB.add(new TreeNodeWrapper(current.node.left,
                                                       current.node));
                    }

                    if (null != current.node.right) {
                        queueB.add(new TreeNodeWrapper(current.node.right,
                                                       current.node));
                    }

                    if (x == current.node.val) {
                        xNode = current;
                    }

                    if (y == current.node.val) {
                        yNode = current;
                    }
                }

                if ((Objects.isNull(xNode) && null != yNode) || (null == yNode && null != xNode)) {
                    return false;
                }

                if (null != xNode && null != yNode) {
                    if (xNode.parent == yNode.parent) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else {
                while (queueB.size() != 0) {
                    TreeNodeWrapper current = queueB.poll();
                    if (null != current.node.left) {
                        queueA.add(new TreeNodeWrapper(current.node.left,
                                                       current.node));
                    }

                    if (null != current.node.right) {
                        queueA.add(new TreeNodeWrapper(current.node.right,
                                                       current.node));
                    }

                    if (x == current.node.val) {
                        xNode = current;
                    }

                    if (y == current.node.val) {
                        yNode = current;
                    }
                }

                if ((null == xNode && null != yNode) || (null == yNode && null != xNode)) {
                    return false;
                }

                if (null != xNode && null != yNode) {
                    if (xNode.parent == yNode.parent) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}