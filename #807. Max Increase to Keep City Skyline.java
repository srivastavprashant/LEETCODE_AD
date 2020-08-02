// #807. Max Increase to Keep City Skyline
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] arr) 
    {
        int[] right=new int[arr.length];
        int[] top=new int[arr[0].length];
        
        for(int i=0;i<arr.length;i++)
        {
            int max=0;
            for(int j=0;j<arr[0].length;j++)
                max= Math.max(max, arr[i][j]);
            right[i]= max;
        }
        
        for(int i=0;i<arr[0].length;i++)
        {
            int max=0;
            for(int j=0;j<arr.length;j++)
                max= Math.max(max, arr[j][i]);
            top[i]= max;
        }
        
        int ans=0;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[0].length;j++)
                ans+= Math.min(right[i], top[j])- arr[i][j];
        
        return ans;                
    }
}
