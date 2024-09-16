package LeetCodeJ;// 863. All Nodes Distance K in Binary Tree

class Solution 
{
    static int counter;
    static void inorder(TreeNode root, HashMap<Integer, Integer> map, ArrayList<ArrayList<Integer>> list, int parent)
    {
        if(root!=null)
        {
            ArrayList<Integer> arr= new ArrayList<>();
            if(root.left!= null) arr.add(root.left.val);
            if(root.right!= null) arr.add(root.right.val);
            if(parent!=-1) arr.add(parent);
            list.add(arr);
            map.put(root.val, counter++);
            
            inorder(root.left, map, list, root.val);
            inorder(root.right, map, list, root.val);
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) 
    {
        counter=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        
        inorder(root, map, list, -1);
        
        Queue<Integer> q= new LinkedList<>();
        boolean[] visited= new boolean[list.size()];
        q.add(map.get(target.val));
        visited[map.get(target.val)]= true;
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(target.val);
        int dist=0;
        
        while(!q.isEmpty() && dist!=K)
        {
            int size= q.size();
            ans = new ArrayList<>();
            
            for(int i=0;i<size;i++)
            {
                //System.out.println(q);
                int curr= q.poll();
                
                for(int j: list.get(curr))
                {
                    if(visited[map.get(j)]) continue;
                    
                    q.add(map.get(j));
                    ans.add(j);
                    visited[map.get(j)]= true;
                }
            }
            dist++;
        }
        return ans;
    }
}
