package linkedlist;

public class RemoveNthToLastElement {



    public ListNode removeNthFromEnd(ListNode head, int n) {
        //slow fast pointers
        if (head == null || n <= 0) return head;

        ListNode fast = head;
        int i = 1;
        while (i <= n && fast != null) {
            fast = fast.next;
        }
        ListNode pre = null;
        ListNode slow = head;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (pre != null) {
            pre.next = slow.next;
        }
        return pre == null ? pre : head;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        new RemoveNthToLastElement().removeNthFromEnd(n1, 2);

    }
}
