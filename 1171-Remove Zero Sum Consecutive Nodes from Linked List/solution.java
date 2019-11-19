/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }

        List<ListNode> list = new ArrayList();
        while (head != null) {
            if (head.val == 0) {
                if (!list.isEmpty()) {
                    list.get(list.size() - 1).next = head.next;
                }
            } else {
                list.add(head);
            }
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = list.isEmpty() ? null : list.get(0);
        ListNode tail = dummy;
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i).val;
            for (int j = i + 1; j < list.size(); j++) {
                sum += list.get(j).val;
                if (sum == 0) {
                    if (i == 0) {
                        dummy.next = list.get(j).next;
                    } else {
                        tail.next = list.get(j).next;
                    }
                    i = j + 1;
                }
            }
            tail = tail.next;
        }

        return dummy.next;
    }
}