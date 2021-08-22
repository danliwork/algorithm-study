package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
class CloneGraph {



    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return dfs(node, new HashSet<>());
    }

    public Node dfs(Node node, Set<Integer> visited) {
        Node newNode = map.computeIfAbsent(node.val, key -> new Node(node.val));
        visited.add(node.val);
        for(Node nb : node.neighbors){
            Node cloneNb = null;// map.getOrDefault(nb.val, dfs(nb, visited));
            if(map.containsKey(nb.val)){
                cloneNb = map.get(nb.val);
            } else {
                cloneNb = dfs(nb, visited);
            }
            newNode.neighbors.add(cloneNb);
        }

        return newNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.addAll(Arrays.asList(n2, n4));
        n2.neighbors.addAll(Arrays.asList(n1, n3));
        n3.neighbors.addAll(Arrays.asList(n2, n4));
        n4.neighbors.addAll(Arrays.asList(n1, n3));
        Node clone = new CloneGraph().cloneGraph(n1);
        log.info("res = " + clone);
    }

}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
