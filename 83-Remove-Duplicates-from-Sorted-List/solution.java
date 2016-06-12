/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode p = head;
        ListNode previous = head;
        ListNode temp;
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(p.val);
        p = p.next;
        
        while(p != null){
            if(s.contains(p.val)){// is duplicate
                // Remove from the linked list
                previous.next = p.next;
                temp = p;
                p = p.next;
                temp.next = null;
            }else{
                s.add(p.val);
                previous = p;
                p = p.next;
            }
        }
        
        return head;
    }
}