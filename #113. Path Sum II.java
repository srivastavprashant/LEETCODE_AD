// #113. Path Sum II



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    List<List<Integer>> ans;
    void call(TreeNode root, int sum, int curr_sum, ArrayList<Integer> arr)
    {
        if(root.left== null && root.right== null)
        {
            arr.add(root.val);
            if(sum== curr_sum+ root.val)
                ans.add(new ArrayList<>(arr));
            arr.remove(arr.size()-1);
            return;
        }
        arr.add(root.val);
        if(root.left!= null) call(root.left, sum, curr_sum+ root.val, arr);
        if(root.right!= null) call(root.right, sum, curr_sum+ root.val, arr);
        arr.remove(arr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
        if(root== null) return new ArrayList<>();
        ans= new ArrayList<>();
        call(root, sum, 0, new ArrayList<>());
        
        return ans;
    }
}
