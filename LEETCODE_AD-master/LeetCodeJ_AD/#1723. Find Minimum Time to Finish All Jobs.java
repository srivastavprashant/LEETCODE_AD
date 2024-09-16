package LeetCodeJ;// #1723. Find Minimum Time to Finish All Jobs


class Solution 
{
    int min;
    void call(int[] jobs, int[] work, int index)
    {
        if(index== -1)
        {
            min= 0;
            for(int i: work)
                min= Math.max(min, i);
            return;
        }
        
        HashSet<Integer> seen= new HashSet<>();
        for(int i=0;i<work.length;i++)
        {
            if(!seen.contains(work[i]) && (work[i]+ jobs[index]<min || min== 0))
            {
                seen.add(work[i]);
                work[i]+= jobs[index];
                call(jobs, work, index-1);
                work[i]-= jobs[index];
            }
        }
    }
    
    public int minimumTimeRequired(int[] jobs, int k) 
    {
        min= 0;
        Arrays.sort(jobs);
        call(jobs, new int[k], jobs.length-1);
        
        return min;
    }
}
