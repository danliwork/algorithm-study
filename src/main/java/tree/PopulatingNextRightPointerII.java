package tree;

public class PopulatingNextRightPointerII {
    public Node connect(Node root) {
        Node cur = root;
        while(cur!=null){
            connectLevel(cur);
            while(cur!=null && cur.left == null && cur.right == null){
                cur = cur.next;
            }
            if(cur!=null){
                cur = cur.left != null ? cur.left : cur.right;
            }

        }
        return root;
    }

    private void connectLevel(Node root){
        Node cur = root;

        while(cur!=null){
            Node left = null;
            if(cur.left!=null && cur.right!=null){
                cur.left.next = cur.right;
                left = cur.right;
            } else {
                left = cur.left!=null? cur.left : cur.right;
            }

            Node next = cur.next;
            //skip next node with empty children
            while(next!=null && next.left == null && next.right==null){
                next = next.next;
            }
            if(next!=null){
                Node right = next.left!=null? next.left : next.right;
                if(left!=null){
                    left.next = right;
                }
            }
            cur = next == null ? null : next.next;
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static Node buildTree(){
        Node n1 = new Node(2);

        Node n2 = new Node(1);
        Node n3 = new Node(3);

        Node n4 = new Node(0);
        Node n5 = new Node(7);
        Node n6 = new Node(9);
        Node n7 = new Node(1);

        Node n8 = new Node(2);
        Node n9 = new Node(1);
        Node n10 = new Node(0);
        Node n11 = new Node(8);
        Node n12 = new Node(8);

        Node n13 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        n7.right = n12;
        n10.left = n13;
        return n1;
    }

    public static void main(String[] args) {
        new PopulatingNextRightPointerII().connect(buildTree());
    }
}
