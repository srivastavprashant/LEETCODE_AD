package LeetCodeJ;// 1482. Minimum Number of Days to Make m Bouquets


class Solution 
{
    public int minDays(int[] bloomDay, int m, int k) 
    {
        if(bloomDay.length< m*k)
            return -1;
        
        int start=1, last= 1000000000, last_ans=0;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            int count=0, bouquets=0;
            for(int i: bloomDay)
            {
                if(i<= mid)
                    count++;
                else
                    count=0;
                
                if(count== k)
                { bouquets++; count=0; }
                
                if(bouquets== m)
                { last_ans= mid; break; }
            }
            
            if(bouquets<m)
                start= mid+1;
            else
                last= mid-1;
        }
        return last_ans;
    }
}
