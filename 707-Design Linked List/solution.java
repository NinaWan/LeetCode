class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null || index < 0 || index > length - 1) {
            return -1;
        }

        ListNode p = head;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the
     * first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
        tail = tail == null ? head
                            : tail;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        if (tail == null) {
            tail = newTail;
            head = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == length) {
            addAtTail(val);
            return;
        }

        if (index < 0 || index > length) {
            return;
        }

        ListNode p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = p.next;
        p.next = newNode;
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > length - 1 || head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            length--;
            return;
        }

        ListNode p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }

        if (p.next.next == null) {
            tail = p;
            p.next = null;
        } else {
            p.next = p.next.next;
        }

        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */