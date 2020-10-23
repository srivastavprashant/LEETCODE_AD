//915. Partition Array into Disjoint Intervals


class Solution {
    public int partitionDisjoint(int[] arr) 
    {
        int[] min= new int[arr.length];
        int tmin= Integer.MAX_VALUE;
        for(int i= arr.length-1;i>=0;i--)
        {
            tmin= Math.min(tmin, arr[i]);
            min[i]= tmin;
        }
        
        tmin= arr[0];
        for(int i=0;i<arr.length;i++)
        {
            int temp= tmin;
            tmin= Math.max(tmin, arr[i]);
            arr[i]= temp;
        }
        
        for(int i=1;i<arr.length;i++)
            if(min[i]>= arr[i])
                return i;
        return -1;
    }
}
