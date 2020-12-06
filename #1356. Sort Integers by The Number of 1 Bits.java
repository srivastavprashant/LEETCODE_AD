// #1356. Sort Integers by The Number of 1 Bits


class Solution 
{    
    public int[] sortByBits(int[] arr) 
    {
        int[] table=new int[256];
        lookUpTable(table);
        int[] setBits=new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            int j=4,n=arr[i];
            while(j>0)
            {
                setBits[i]+=table[n&255];
                n=n>>8;
                j--;
            }
        }
        
        ArrayList<Integer> sort= new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            sort.add(i);
        
        Comparator<Integer> comp= new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                if(setBits[a]== setBits[b])
                    return arr[a]-arr[b];
                else
                    return setBits[a]- setBits[b];
            }
        };
        
        Collections.sort(sort, comp);
        int[] ans= new int[arr.length];
        for(int i=0;i<arr.length;i++)
            ans[i]= arr[sort.get(i)];
        
        return ans;
    }
    static void lookUpTable(int []table)
    {
        table[0]=0;
        
        for(int i=1;i<256;i++)
            table[i]=(i&1) + table[i/2];
    }
}
