/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Stack<ListNode> s1 = new Stack();
        Stack<ListNode> s2 = new Stack();

        // push to stack
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        // addition
        ListNode curr = null;
        int carryOver = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || carryOver != 0) {
            ListNode d1 = null;
            ListNode d2 = null;
            ListNode newNode = null;
            int tempSum = 0;

            if (s1.isEmpty() && s2.isEmpty()) {
                tempSum = carryOver;
            } else {
                if (!s1.isEmpty() && !s2.isEmpty()) {
                    d1 = s1.pop();
                    d2 = s2.pop();
                    tempSum = d1.val + d2.val + carryOver;
                } else {
                    if (s1.isEmpty()) {
                        d2 = s2.pop();
                        tempSum = d2.val + carryOver;
                    } else {
                        d1 = s1.pop();
                        tempSum = d1.val + carryOver;
                    }
                }
            }

            newNode = new ListNode(tempSum % 10);
            newNode.next = curr;
            carryOver = tempSum / 10;

            curr = newNode;
        }

        return curr;
    }
}