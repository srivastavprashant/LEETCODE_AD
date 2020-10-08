// 1582. Special Positions in a Binary Matrix

class Solution {
    public int numSpecial(int[][] mat) 
    {
        int ans=0;
        for(int i=0;i<mat.length;i++)
        {
            int count=0, index=-1;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]== 1)
                { count++; index= j; }
            }
            
            for(int j=0;j<mat.length && index!=-2 && count==1;j++)
                if(i!=j && mat[j][index]==1)
                    index=-2;
            
            if(count==1 && index>=0)
            { ans++; }
        }
        
        return  ans;
    }
}
