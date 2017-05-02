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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> ancestorsOfp = getAllAncestors(root, p);
        Queue<TreeNode> ancestorsOfq = getAllAncestors(root, q);
        TreeNode result = null;
        while(!ancestorsOfp.isEmpty() && !ancestorsOfq.isEmpty() && ancestorsOfp.peek() == ancestorsOfq.peek()){
            result = ancestorsOfp.poll();
            ancestorsOfq.poll();
        }
        return result;
    }

    private Queue<TreeNode> getAllAncestors(TreeNode root, TreeNode child){
        Queue<TreeNode> ancestors = new LinkedList<TreeNode>();
        boolean flag = true;
        TreeNode currentNode = root;
        while(flag){
            ancestors.add(currentNode);
            if(currentNode.val == child.val){
                flag = false;
            }else{
                if(child.val < currentNode.val){
                    currentNode = currentNode.left;
                }else{
                    currentNode = currentNode.right;
                }
            }

        }
        return ancestors;
    }
}