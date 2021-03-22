// #337. House Robber III



class Solution {
    Map<TreeNode, int[]> map;
    int call(TreeNode root, boolean steal)
    {
        if(root== null) return 0;
        else if(map.containsKey(root) && map.get(root)[steal?0:1]!= -1) return map.get(root)[steal?0:1];
        else
        {
            int val;
            if(steal) val= call(root.left, !steal)+ call(root.right, !steal);
            else
            {
                val= root.val+ call(root.left, !steal)+ call(root.right, !steal);
                val= Math.max(val, val= call(root.left, steal)+ call(root.right, steal));
            }
            
            map.put(root, new int[]{-1, -1});
            map.get(root)[steal?0:1]= val;
            return val;
        }
    }
    public int rob(TreeNode root) {
        map= new HashMap<>();
        return Math.max(call(root, true), call(root, false));
    }
}
