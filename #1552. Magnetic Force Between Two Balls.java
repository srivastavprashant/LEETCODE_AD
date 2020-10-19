// 1552. Magnetic Force Between Two Balls

class Solution {
    public int maxDistance(int[] position, int m) 
    {
        Arrays.sort(position);
        int start= 0, last= position[position.length-1], ans=0;
        
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            int find=position[0], balls=0, index=0;
            while(balls!= m && index!= position.length)
            {
                balls++;
                find= position[index]+mid;
                index= binarySearch(position, 0, position.length-1, find);
            }
            
            if(balls== m)
            {
                start= mid+1;
                ans= mid;
            }
            else
                last= mid-1;
        }
        
        return ans;
    }
    
    static int binarySearch(int[] position, int start, int last, int find)
    {
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(position[mid]== find)
                return mid;
            else if(find> position[mid])
                start= mid+1;
            else
                last= mid-1;
        }
        
        return start;
    }
}
