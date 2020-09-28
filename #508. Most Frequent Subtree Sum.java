// 508. Most Frequent Subtree Sum

class Solution 
{
    static HashMap<Integer, Integer> map;
    static int postOrder(TreeNode root)
    {
        if(root!=null)
        {
            int left= postOrder(root.left);
            int right= postOrder(root.right);
            int key= left+right+root.val;
            
            map.put(key, map.getOrDefault(key, 0)+1);
            return key;
        }
        else
            return 0;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) 
    {
        if(root== null)
            return new int[]{};
        map= new HashMap<>();
        postOrder(root);
        
        ArrayList<Integer> list= new ArrayList<>(map.keySet());
        Comparator<Integer> comp= new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            { return map.get(b)- map.get(a); }
        };
        
        Collections.sort(list, comp);
        ArrayList<Integer> ans= new ArrayList<>();
        
        int key= map.get(list.get(0));
        for(int i: list)
        {
            if(map.get(i)== key)
                ans.add(i);
            else
                break;
        }
        
        int[] final_ans= new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            final_ans[i]= ans.get(i);
        
        return final_ans;        
    }
}
