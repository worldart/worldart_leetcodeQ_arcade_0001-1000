//25ms



/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(final Node node, final Map<Integer, Node> nodes) {
        if (node == null) {
            return null;
        }
        if (nodes.containsKey(node.val)) {
            return nodes.get(node.val);
        }
        final var copy = new Node(node.val);
        nodes.put(copy.val, copy);
        node.neighbors.stream()
            .map(n -> clone(n, nodes))
            .forEach(copy.neighbors::add);
        return copy;
    }
}





//24ms






/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Node, Node> map){
        if(node == null) return null;

        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);

        for(Node n : node.neighbors){
            copy.neighbors.add(dfs(n, map));
        }
        return copy;
    }
}
