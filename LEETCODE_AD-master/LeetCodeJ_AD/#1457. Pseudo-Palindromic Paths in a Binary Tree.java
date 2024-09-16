package LeetCodeJ;/*
  Intutuion: Just create a hashMap of all the value and there frequency linked to them, and whenever u come across a leaf check if it has either 0 or just one odd freq if yes
             return true else false.
             
  Bit Manipulation: 
             Observation: given the values can just be from [1, 9] so we can actually use a Integer to work as a hashSet for us i.e 
                          toggle the root.value bit every time that no occurs so if the no occured even times it will be 0,
                          else if occured odd time then just check how many bits are set if more than 1 return false.
                          (Use brian Kernigams algo) to find the set bits.
*/

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
 
 // TOGGLE IMPLEMENTATION
class Solution {
    
    static int call(TreeNode root, int xor)
    {
        if(root==null)
            return 0;
        else
        {
            xor^= 1<<root.val;
            
            if(root.left==null && root.right==null)
                return (xor==0 || (xor&(xor-1))==0)? 1: 0;
            return call(root.left, xor)+ call(root.right, xor);
        }
    }
    
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        return call(root, 0);
    }
}

// HASHSET IMPLEMENTATION
class Solution 
{
    static HashMap<Integer, Integer> map=new HashMap<>();
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        if(root==null)
            return 0;
        else
        {
            if(map.containsKey(root.val))
                map.put(root.val, map.get(root.val)+1);
            else
                map.put(root.val, 1);
            
            if(root.left==null && root.right==null)
            {
                int temp= check();
                if(map.get(root.val)==1)
                    map.remove(root.val);
                else
                    map.put(root.val, map.get(root.val)-1);
                return temp;
            }
            
            int left= pseudoPalindromicPaths(root.left);
            int right= pseudoPalindromicPaths(root.right);
            
            if(map.get(root.val)==1)
                map.remove(root.val);
            else
                map.put(root.val, map.get(root.val)-1);
            
            return left+ right;
        }
    }
        
    static int check()
    {
        System.out.println(map);
        int odd=0;
        for(Map.Entry<Integer, Integer> i: map.entrySet())
            if((i.getValue()&1)==1)
                odd++;
        return odd<=1? 1: 0;
    }
    
}
