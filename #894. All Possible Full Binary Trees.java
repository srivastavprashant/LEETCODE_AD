
// Naive Solution can be optimized using dynamic programming as problem contains overlapping supproblems

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans= new ArrayList<>();
        TreeNode root= new TreeNode(0); n--;
        if(n== 0) return new ArrayList<>(Arrays.asList(new TreeNode(0)));
        
        for(int i=1;i<n;i++) {
            List<TreeNode> left= allPossibleFBT(i);
            List<TreeNode> right= allPossibleFBT(n-i);
            
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    root.left= l;
                    root.right= r;
                    TreeNode copy= new TreeNode(0);
                    snapshot(root, copy);
                    ans.add(copy);
                }
            }
        }
        
        return ans;
    }
    
    void snapshot(TreeNode root, TreeNode copy) {
        if(root== null) return;
        else {
            if(root.left!= null) copy.left= new TreeNode(0);
            if(root.right!= null) copy.right= new TreeNode(0);
            snapshot(root.left, copy.left);
            snapshot(root.right, copy.right);
        }
    }
}


// Memoization

class Solution {
    Map<Integer, List<TreeNode>> memo= new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(memo.containsKey(n)) return memo.get(n);
        List<TreeNode> ans= new ArrayList<>();
        TreeNode root= new TreeNode(0); n--;
        if(n== 0) return new ArrayList<>(Arrays.asList(new TreeNode(0)));

        for(int i=1;i<n;i++) {
            List<TreeNode> left= allPossibleFBT(i);
            List<TreeNode> right= allPossibleFBT(n-i);
            
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    root.left= l;
                    root.right= r;
                    TreeNode copy= new TreeNode(0);
                    snapshot(root, copy);
                    ans.add(copy);
                }
            }
        }
        
        memo.put(n+1, ans);
        return ans;
    }
    
    void snapshot(TreeNode root, TreeNode copy) {
        if(root== null) return;
        else {
            if(root.left!= null) copy.left= new TreeNode(0);
            if(root.right!= null) copy.right= new TreeNode(0);
            snapshot(root.left, copy.left);
            snapshot(root.right, copy.right);
        }
    }
    
}
