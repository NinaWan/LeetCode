/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> list = new ArrayList();
        list.add(head);

        while (head != null) {
            int i = list.size() - 1;
            ListNode temp = head.next;

            for (; i >= 0; i--) {
                if (head.val > list.get(i).val) {
                    list.get(i).next = head;
                    if (i < list.size() - 1) {
                        head.next = list.get(i + 1);
                    }
                    list.add(i + 1, head);
                    break;
                }
            }

            if (i < 0) {
                head.next = list.get(0);
                list.add(0, head);
            }

            list.get(list.size() - 1).next = null;

            head = temp;
        }

        return list.get(0);
    }
}