/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        // recursion
        // return mergeKLists(lists, 0, lists.length-1);

        // min heap
        Queue<ListNode> pq = new PriorityQueue(lists.length, (Comparator<ListNode>) (node1, node2) -> node1.val - node2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = pq.poll();
        if (curr != null && curr.next != null) {
            pq.add(curr.next);
        }
        dummy.next = curr;

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (temp.next != null) {
                pq.add(temp.next);
            }
            curr.next = temp;
            curr = temp;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        return merge2List(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end));
    }

    public ListNode merge2List(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = null;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                tail.next = node2;
                break;
            }

            if (node2 == null) {
                tail.next = node1;
                break;
            }

            if (node1.val < node2.val) {
                if (tail != null) {
                    tail.next = node1;
                } else {
                    dummy.next = node1;
                }
                tail = node1;
                node1 = node1.next;
            } else {
                if (tail != null) {
                    tail.next = node2;
                } else {
                    dummy.next = node2;
                }
                tail = node2;
                node2 = node2.next;
            }
        }

        return dummy.next;
    }
}