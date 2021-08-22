package linkedlist;

public class ReverseListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode newHead = head;
        int count = 0;
        while(cur != null){
            count ++;
            if(count == m){
                reverse(pre, cur, n-m+1, newHead);
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return newHead == null ? head:newHead;
    }

    private void reverse(ListNode orgPre, ListNode start, int n, ListNode newHead){
        ListNode cur = start;
        ListNode pre = null;

        while(n>=1){
            ListNode orgNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = orgNext;
            n--;
        }
        start.next = cur;
        if(orgPre!= null){
            orgPre.next = pre;
        } else {
            newHead = pre;
        }
    }

    public static void main(String[] args) {

        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);

        n3.next = n5;

        new ReverseListII().reverseBetween(n3, 1,2);

    }
}
