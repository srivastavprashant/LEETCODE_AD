// 1608. Special Array With X Elements Greater Than or Equal X

class Solution 
{
    int binarySearch(int[] arr, int start, int last, int find)
    {
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(arr[mid]== find)
                return mid;
            else if(arr[mid]< find)
                start= mid+1;
            else
                last= mid-1;
        }
        
        return start;
    }
    
    public int specialArray(int[] nums) 
    {
        Arrays.sort(nums);
        
        for(int i=1;i<=nums.length;i++)
        {
            int index= binarySearch(nums, 0, nums.length-1, i);
            int val= index!= nums.length?nums[index]: -1;
            while(index!= 0 && nums[index-1]== val)
                index--;
            
            int greater= nums.length- index;
            
            if(greater== i)
                return i;
        }
        
        return -1;  
    }
}
