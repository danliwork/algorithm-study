package linkedlist;

public class ReversingEvenNodes {
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    Node reverseSubList(Node pre, Node cur){
        Node p = pre;
        Node c = cur;
        while(c!=null || c.data % 2 == 0){
            Node orgNext  = c.next;
            c.next = p;
            p = c;
            c = orgNext;
        }
        if(pre == null) return p;
        pre.next = p;
        cur.next = c;
        return null;
    }

    Node reverse(Node head) {
        // Write your code here
        Node dummy = new Node(0);
        Node newHead = null;
        Node pre = null;
        Node cur = head;
        while(cur != null){
            if(cur.data % 2 == 0){
                newHead = reverseSubList(pre, cur);
            }
            pre = cur;
            cur = cur.next;
        }
        return newHead!=null ? newHead:head;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(8);
        Node n4 = new Node(12);
        Node n5 = new Node(16);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        new ReversingEvenNodes().reverse(n1);

    }

}
