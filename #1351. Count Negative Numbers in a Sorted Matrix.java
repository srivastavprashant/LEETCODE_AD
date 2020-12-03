// #1351. Count Negative Numbers in a Sorted Matrix



class Solution {
    public int countNegatives(int[][] grid) 
    {
        int ans= 0;
        for(int[] i: grid)
        {
            int index= binarySearch(0, i.length-1, 0, i);
            ans+= i.length- index;
        }
        
        return ans;
    }
    
    static int binarySearch(int start, int last, int find, int[] arr)
    {
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(arr[mid]>=find)
                start= mid+1;
            else
                last= mid-1;
        }
        
        return start;
    }
}
