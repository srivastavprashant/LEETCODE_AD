// #1769. Minimum Number of Operations to Move All Balls to Each Box


class Solution {
    public int[] minOperations(String boxes) 
    {
        char[] arr= boxes.toCharArray();
        int[] ans= new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int val= 0;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]== '1')
                    val+= Math.abs(i-j);
            }
            
            ans[i]= val;
        }
        
        return ans;
    }
}
