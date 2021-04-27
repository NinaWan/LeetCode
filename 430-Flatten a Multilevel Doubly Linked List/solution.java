/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node prev;
 * public Node next;
 * public Node child;
 * public Node() {}
 * public Node(int _val,Node _prev,Node _next,Node _child) {
 * val = _val;
 * prev = _prev;
 * next = _next;
 * child = _child;
 * }
 * };
 */
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node newTail = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;

            // Append current node
            if (newTail != null) {
                newTail.next = curr;
                curr.prev = newTail;
            }
            newTail = curr;

            // DFS
            if (curr.child != null) {
                Node childHead = flatten(curr.child);
                newTail.next = childHead;
                childHead.prev = newTail;
                curr.child = null;

                while (newTail.next != null) {
                    newTail = newTail.next;
                }
            }

            curr = next;
        }

        return head;
    }
}