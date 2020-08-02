// #1536. Minimum Swaps to Arrange a Binary Grid

class Solution {
    public int minSwaps(int[][] grid) 
    {
        ArrayList<Integer> zero=new ArrayList<>();
        ArrayList<Integer> last=new ArrayList<>();
        int not_valid=0, ans=0;
        //HashSet<Integer> set=new HashSet<>();
        //boolean duplicate=false;
        
        for(int i=0;i<grid.length;i++)
            last.add( -1);
        
        for(int i=0;i<grid.length;i++)
        {
            int count=0;
            for(int j=0;j<grid[0].length;j++)
            {
                count+= grid[i][j]==0?1:0;
                last.set(i, grid[i][j]==1? j: last.get(i));
            }
            zero.add(count);                
        }
        
        for(int i=0;i<grid.length-1;i++)
        {
            int count= grid.length-i-1;
            
            if(zero.get(i)>= count && last.get(i)< grid.length- count)
                continue;
            else 
            {
                for(int j=i+1;j<grid.length;j++)
                    if(zero.get(j)>=count && last.get(j)< grid.length-count)
                    {
                        //System.out.println(j+" "+i);
                        ans+= j-i;
                        zero.remove(j);
                        last.remove(j);
                        zero.add(i, 0);
                        last.add(i, 0);
                        break;
                    }
                    else if(j==grid.length-1)
                        return -1;
            }
        }
        
        return ans;
    }
}
