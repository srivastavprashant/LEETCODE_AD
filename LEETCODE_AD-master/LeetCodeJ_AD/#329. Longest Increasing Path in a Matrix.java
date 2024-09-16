package LeetCodeJ;// #329. Longest Increasing Path in a Matrix


class Solution 
{
    int max, n;
    int[] memo;
    int DFSREC(ArrayList<ArrayList<Integer>> arr, int index)
    {
        if(memo[index]!= -1)
            return memo[index];
        
        int max= 0;
        for(int i: arr.get(index))
        {
            memo[i]= DFSREC(arr, i);
            max= Math.max(max, memo[i]);
        }
        
        memo[index]= max+1;
        return max+1;
    }
    
    int index(int i, int j)
    { return i* n+ j; }
    
    public int longestIncreasingPath(int[][] matrix) 
    {
        int size= matrix.length* matrix[0].length;
        memo= new int[size];
        Arrays.fill(memo, -1);
        max= 0;
        n= matrix[0].length;
        
        ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
        for(int i=0;i<size;i++)
            arr.add(new ArrayList<>());
        
        HashSet<Integer> indegree= new HashSet<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(i!=0 && matrix[i-1][j]> matrix[i][j])
                { arr.get(index(i, j)).add(index(i-1, j)); indegree.add(index(i-1, j)); } 
                
                if(j!=0 && matrix[i][j-1]> matrix[i][j])
                { arr.get(index(i, j)).add(index(i, j-1)); indegree.add(index(i, j-1)); }
                
                if(i!=matrix.length-1 && matrix[i+1][j]> matrix[i][j])
                { arr.get(index(i, j)).add(index(i+1, j)); indegree.add(index(i+1, j)); }
                
                if(j!=matrix[0].length-1 && matrix[i][j+1]> matrix[i][j])
                { arr.get(index(i, j)).add(index(i, j+1)); indegree.add(index(i, j+1)); }
            }
        }
        
        int ret= 0;
        for(int i=0;i<size;i++)
        {
            if(indegree.contains(i)) continue;
            
            DFSREC(arr, i);
            //System.out.println(memo[i]+" "+i);
            ret= Math.max(ret, memo[i]);
        }
        
        return ret;
    }
}
