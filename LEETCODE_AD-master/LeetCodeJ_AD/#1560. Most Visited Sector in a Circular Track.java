package LeetCodeJ;

class Solution {
    public List<Integer> mostVisited(int n, int[] arr) 
    {
        int[] map=new int[n];
        
        for(int i=1;i<arr.length;i++)
        {
            int start= arr[i-1]-1, end= arr[i]-1;
            
            while(start%n!= end)
            {
                map[start%n]++;
                start++;
            }
        }
        map[arr[arr.length-1]-1]++;
        
        int ans=-1;
        for(int i=0;i<n;i++)
            ans= Math.max(ans, map[i]);
        
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(ans== map[i])
                list.add(i+1);
        
        Collections.sort(list);
        return list;        
    }
}
