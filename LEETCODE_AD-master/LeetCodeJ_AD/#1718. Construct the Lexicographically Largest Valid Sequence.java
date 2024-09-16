package LeetCodeJ;// #1718. Construct the Lexicographically Largest Valid Sequence

class Solution 
{
    int[] ans;
    boolean[] used;
    boolean DFSREC(int n, int[] occupied, int index)
    {
        //for(int i=0;i<occupied.length;i++)
        //    System.out.print(occupied[i]+" ");
        //System.out.println();
        
        boolean ret= false;
        if(index== occupied.length)
        {
            ans= new int[1+ (n-1)*2];
            for(int i=0;i<ans.length;i++)
                ans[i]= occupied[i];
            return true;
        }
        else if(occupied[index]!=0) 
            return DFSREC(n, occupied, index+1);
        else
        {   
            for(int i=n;i>=1;i--)
            {
                if(!used[i]&& (i==1|| (index+i<occupied.length && occupied[index+i]==0)))
                {
                    occupied[index]= i;
                    if(i!= 1)occupied[index+i]= i;
                    used[i]= true;
                    ret|= DFSREC(n, occupied, index+1);
                    occupied[index]= 0;
                    if(i!= 1)occupied[index+i]= 0;
                    used[i]= false;
                    if(ret) return true;
                }
            }
            
            return ret;
        }
    }
    
    public int[] constructDistancedSequence(int n) 
    {
        used= new boolean[n+1];
        int[] occupied= new int[1+ (n-1)*2];
        DFSREC(n, occupied, 0);
        
        return ans;
    }
}
