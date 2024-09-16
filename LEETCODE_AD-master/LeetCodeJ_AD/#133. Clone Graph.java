package LeetCodeJ;// #133. Clone Graph


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
    public Node cloneGraph(Node node) 
    {
        if(node== null) return null;
        Queue<Node> q= new LinkedList<>();
        q.add(node);
        HashMap<Integer, Node> map= new HashMap<>();
        HashSet<Integer> set= new HashSet<>();
        set.add(node.val);

        while(!q.isEmpty())
        {
            int size= q.size();
            for(int ii=0;ii<size;ii++)
            {
                Node curr= q.poll();
                Node copy;
                if(map.containsKey(curr.val))
                    copy= map.get(curr.val);
                else
                {
                    copy= new Node(curr.val);
                    map.put(copy.val, copy);
                }
                
                for(Node n: curr.neighbors)
                {
                    if(map.containsKey(n.val))
                        copy.neighbors.add(map.get(n.val));
                    else
                    {
                        Node temp= new Node(n.val);
                        map.put(n.val, temp);
                        copy.neighbors.add(map.get(n.val));
                    }
                    
                    if(set.contains(n.val)) continue;
                    q.add(n);
                    set.add(n.val);
                }
            }
        }
        
        return map.get(node.val);
    }
}
