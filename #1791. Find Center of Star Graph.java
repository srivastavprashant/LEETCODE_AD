// #1791. Find Center of Star Graph

class Solution {
    public int findCenter(int[][] edges) 
    {
        int[] degree= new int[edges.length+2];
        for(int[] i:edges)
        {
            degree[i[0]]++;
            degree[i[1]]++;
        }
        
        for(int i=0;i<degree.length;i++)
            if(degree[i]== edges.length)
                return i;
        
        return 0;
    }
}
