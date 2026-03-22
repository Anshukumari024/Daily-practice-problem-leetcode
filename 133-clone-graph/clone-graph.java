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
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        map.put(node,new Node(node.val));
        while(!q.isEmpty()){
            Node curr=q.poll();
            for(Node neig:curr.neighbors){
                if(!map.containsKey(neig)){
                    map.put(neig,new Node(neig.val));
                    q.add(neig);
                }
                map.get(curr).neighbors.add(map.get(neig));
            }
        }
        return map.get(node);
    }
}