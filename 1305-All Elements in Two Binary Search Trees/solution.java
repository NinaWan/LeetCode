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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        populatePriorityQueueWithTree(root1, priorityQueue);
        populatePriorityQueueWithTree(root2, priorityQueue);

        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
        }

        return res;
    }

    private void populatePriorityQueueWithTree(TreeNode root, PriorityQueue<Integer> priorityQueue) {
        Queue<TreeNode> queue = new LinkedList();// for bfs
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                continue;
            }
            priorityQueue.offer(curr.val);
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
    }
}