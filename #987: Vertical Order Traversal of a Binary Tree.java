class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> q_level=new LinkedList<>();
        q.add(root); q_level.add(0);
        
        TreeMap<Integer, List<Integer[]>> map=new TreeMap<>();
        int hor_level=0;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode temp= q.poll();
                int level= q_level.poll();
                
                if(map.containsKey(level))
                    map.get(level).add(new Integer[]{temp.val, hor_level});
                else
                {
                    List<Integer[]> list=new ArrayList<>();
                    list.add(new Integer[]{temp.val, hor_level});
                    map.put(level, list);
                }
                
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    q_level.add(level-1);
                }
                
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    q_level.add(level+1);
                }
            }
            hor_level++;
        }
        
        Comparator<Integer[]> comp=new Comparator<Integer[]>()
        {
            @Override
            public int compare(Integer[] a, Integer[] b)
            {
                if(a[1]!=b[1])
                    return a[1]- b[1];
                else
                    return a[0]- b[0];
            }
        };
        
        List<List<Integer>> ans=new ArrayList<>();
        for(Map.Entry<Integer, List<Integer[]>> i: map.entrySet())
        {
            Collections.sort(i.getValue(), comp);
            List<Integer> temp=new ArrayList<>();
            
            for(Integer[] j: i.getValue())
                temp.add(j[0]);
            ans.add(temp);
        }
        
        return ans;
    }
}
