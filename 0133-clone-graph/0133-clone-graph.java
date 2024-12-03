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
    private HashMap<Node, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return cloneNode(node);
    }

    private Node cloneNode(Node originalNode) {
        if (nodeMap.containsKey(originalNode)) {
            return nodeMap.get(originalNode);
        }

        Node clonedNode = new Node(originalNode.val);
        nodeMap.put(originalNode, clonedNode);

        for (Node neighbor : originalNode.neighbors) {
            clonedNode.neighbors.add(cloneNode(neighbor));
        }

        return clonedNode;
    }
}
