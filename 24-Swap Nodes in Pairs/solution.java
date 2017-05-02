/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(null == head) return head;

        ListNode before = null;
        ListNode tempNode = null;
        ListNode pointer = head;

        ListNode result = null;
        if(null != head.next){
            result = head.next;
        }else{
            result = head;
        }

        while(null != pointer){
            if(null != pointer.next){
                // swap
                tempNode = pointer.next;
                pointer.next = tempNode.next;
                tempNode.next = pointer;
                if(null != before){
                    before.next = tempNode;
                }
            }
            before = pointer;
            pointer = pointer.next;
        }

        return result;
    }
}