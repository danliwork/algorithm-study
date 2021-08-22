package array;

import java.util.HashSet;
import java.util.Set;

public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for(int i=2; i<=n; i++){
            str = generateNext(str);
        }
        return str;
    }

    private String generateNext(String str){
        StringBuilder result = new StringBuilder();
        int i=0;
        while(i<str.length()){
            int count = 1;
            while(i+1 < str.length() && str.charAt(i+1) == str.charAt(i)){
                count++;
                i++;
            }
            result.append(count);
            result.append(str.charAt(i));
            i++;
        }
        return result.toString();
    }

    public int BrushCount(int[] buildings)
    {
        int brushCount = 0;
        int prevHeight = 0;
        for(int i = 0; i < buildings.length; i++)
        {
            if(buildings[i] > prevHeight)
                brushCount = brushCount + (buildings[i] - prevHeight);
            prevHeight = buildings[i];
        }
        return brushCount;
    }

    public int solution(String S){
        long decimal = Long.parseLong(S, 2);
        int ops = 0;
        while (decimal > 0) {
            if (decimal % 2 == 0)
                decimal /= 2;
            else
                decimal -= 1;
            ops++;
        }
        return ops;
    }

    public  int solution2(String s) {
        int firstOneAt = s.indexOf("1");
        return firstOneAt == -1 ? 0
                : s.replace("0", "").length() + s.length() - firstOneAt - 1;
    }

    //public static void main(String[] args) {
    //    int[] buildings = {4, 1, 2, 1, 2, 2};
    //    System.out.println(new CountAndSay().solution2("011100"));
    //    System.out.println(new CountAndSay().solution2("111"));
    //}

    // A node of binary tree
    static class Node
    {
        int data;
        Node left, right;
    };

    // A utility function to create a new Binary
// Tree node
    static Node newNode(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    private int r;

    public int pathSum(Node root) {
        if(root == null) return r;
        doCheck(root, new HashSet<>());
        return r;
    }

    private void doCheck(Node root, Set<Integer> p) {
        if(root == null || p.contains(root.data)) {
            r = Math.max(r, p.size());
            return;
        }
        p.add(root.data);
        doCheck(root.left, p);
        doCheck(root.right, p);
        p.remove(root.data);
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Create binary tree shown in above figure
        Node root = newNode(1);
        root.right = newNode(2);
        root.right.left= newNode(1);
        root.right.right= newNode(1);
        root.right.right.left= newNode(4);



        System.out.println(new CountAndSay().pathSum(root));
    }
}
