package linkedlist;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        //find middle point of linkedlist
        ListNode slow = head;
        ListNode fast = head;

        int halfLength = 0;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            halfLength ++;
        }

        //reverse second half
        ListNode pre = null;
        ListNode cur = slow;

        while(cur!=null){
            ListNode orgNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
        }

        //compare half
        ListNode start = head;
        while(halfLength > 0){
            if(start.val != pre.val) return false;
            start = start.next;
            pre = pre.next;
            halfLength --;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = n5;

        new IsPalindrome().isPalindrome(n1);

    }
}
