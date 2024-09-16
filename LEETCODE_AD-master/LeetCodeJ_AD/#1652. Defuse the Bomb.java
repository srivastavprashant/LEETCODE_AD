package LeetCodeJ;


class Solution {
    public int[] decrypt(int[] code, int k) 
    {
        int n= code.length;
        int[] ans= new int[n];
        if(k==0)
            Arrays.fill(ans, 0);
        else
        {
            int inc= k/Math.abs(k);
            for(int i=0;i<n;i++)
            {
                int index= i;
                do{
                    index+= inc;
                    ans[i]+= code[(index+ n)%n];
                } while(i+k!= index);
            }
        }
        
        return ans;
    }
}
