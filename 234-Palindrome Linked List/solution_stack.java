/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // Create a stack object
        Stack<ListNode> stack = new Stack<ListNode>();
        // Put each element in singly-linked list into stack
        stack.push(head);
        ListNode currentNode = head;
        ListNode stackNode;
        while (currentNode.next != null) {
            stack.push(currentNode.next);
        }
        // Compare each element
        currentNode = head;
        while (currentNode != null && !stack.isEmpty()) {
            stackNode = stack.pop();
            if (currentNode.val != stackNode.val) {
                break;
            }
        }
        if (currentNode == null) {
            return true;
        }
        return false;
    }
}
