// 1609. Even Odd Tree

class Solution {
    public boolean isEvenOddTree(TreeNode root) 
    {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        boolean even= true;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            int val= -1;
            
            for(int i=0;i<size;i++)
            {
                TreeNode curr= q.poll();
                if(val== -1)
                {
                    val= curr.val;
                    
                    if((val%2==0 && even)||(!even && val%2!=0))
                        return false;
                }
                else
                {
                    if(even && curr.val%2==0)
                        return false;
                    else if(!even && curr.val%2!=0)
                        return false;
                    
                    if(val>= curr.val && even)
                        return false;
                    
                    if(val<= curr.val && !even)
                        return false;
                    
                    val= curr.val;
                }
                
                if(curr.left!= null)
                    q.add(curr.left);
                
                if(curr.right!= null)
                    q.add(curr.right);
            }
            even= !even;
        }
        return true;
    }
}
