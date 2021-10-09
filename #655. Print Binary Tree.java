// #655. Print Binary Tree


class Solution {
    public int calcHeight(TreeNode root) {
        if(root== null) return 0;
        else {
            return 1+ Math.max(calcHeight(root.left), calcHeight(root.right)); 
        }
    }
    
    public List<List<String>> printTree(TreeNode root) {
        int h= calcHeight(root);
        List<List<String>> ans= new ArrayList<>();
        for(int i=0;i<h;i++) {
            List<String> temp = new ArrayList<>();
            for(int j=0;j<(1<<h)-1;j++) temp.add("");
            ans.add(temp);
        }
        
        helper(ans, root, 0, (1<<h-1)-1, h);
        return ans;
    }
    
    public void helper(List<List<String>> ans, TreeNode root, int i, int j, int h) {
        if(root== null) return;
        else {
            ans.get(i).set(j, root.val+"");
            helper(ans, root.left, i+1, j- (1<<h-i-2), h);
            helper(ans, root.right, i+1, j+ (1<<h-i-2), h);
        }
    }
}
