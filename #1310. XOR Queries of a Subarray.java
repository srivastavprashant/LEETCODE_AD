/*
  Using the property that x^y^x= y;
  Calculate the presum xor array for the given array. (use in place approach to not waste extra space)
  Then for a range xor = presum_xor[start-1]^ presum_xor[last].
    OR in case start ==0 ans= presum_xor[last].
*/

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) 
    {
        int xor=0;
        int[] ans= new int[queries.length];
        
        for(int i=0;i<arr.length;i++)
            arr[i]= xor^=arr[i];
        
        int c=0;
        for(int[] i: queries)
        {
            if(i[0]==0)
                ans[c++]= arr[i[1]];
            else
                ans[c++]= arr[i[0]-1]^ arr[i[1]];
        }
        return ans;
    }
}
