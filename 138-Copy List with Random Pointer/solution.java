/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap();
        Node curr = head;

        while (curr != null) {
            nodeMap.put(curr, new Node(curr.val, null, null));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            Node newCurr = nodeMap.get(curr);
            newCurr.next = nodeMap.get(curr.next);
            newCurr.random = nodeMap.get(curr.random);
            curr = curr.next;
        }

        return nodeMap.get(head);
    }
}