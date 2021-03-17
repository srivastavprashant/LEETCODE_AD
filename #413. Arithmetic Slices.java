// #413. Arithmetic Slices



class Solution 
{
    public int numberOfArithmeticSlices(int[] nums) 
    {
        int n= nums.length, m= n;
        int[][] arr= new int[n][m];
        
        for(int[] i: arr)
            Arrays.fill(i, -3000);
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<m;j++)
            {
                if(j== i+1)
                    arr[i][j]= nums[j]- nums[j-1];
                else if(nums[j]- nums[j-1]== arr[i][j-1])
                    arr[i][j]= nums[j]- nums[j-1];
                else
                    break;
            }
        }
        
        int ans= 0;
        for(int i=0;i<n;i++)
            for(int j= i+2;j<m;j++)
                if(arr[i][j]!= -3000)
                    ans++;
        
        return ans;
    }
}
