package LeetCodeJ;//#988. Smallest String Starting From Leaf



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
    String min;
    void call(TreeNode root, StringBuilder br)
    {   
        if(root.left!= null)
        {
            br.append((char)(root.left.val+ 'a'));
            call(root.left, br);
            br.setLength(br.length() - 1);
        }
        
        if(root.right!= null)
        {
            br.append((char)(root.right.val+ 'a'));
            call(root.right, br);
            br.setLength(br.length() - 1);
        }
        
        if(root.left== null && root.right== null)
        {
             StringBuilder temp= new StringBuilder(br);
             String s= temp.reverse().toString();
             if(s.compareTo(min)<0)
                min= new String(s);
        }   
    }
    
    public String smallestFromLeaf(TreeNode root)
    {
        if(root== null) return "";
        
        StringBuilder br= new StringBuilder();
        for(int i=0;i<8500;i++)
            br.append('z');
        
        min= br.toString();
        br= new StringBuilder();
        br.append((char)(root.val+ 'a'));
        call(root, br);
        
        return min;
    }
}
