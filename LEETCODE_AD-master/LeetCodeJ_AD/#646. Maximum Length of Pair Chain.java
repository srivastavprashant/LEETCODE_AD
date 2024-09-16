package LeetCodeJ;// #646. Maximum Length of Pair Chain


// Approach 1 : Dynamic programming
class Solution 
{
    HashMap<Integer, Integer> memo;
    int call(int[][] pairs, int curr)
    {
        if(memo.containsKey(curr)) return memo.get(curr);
        else
        {
            int index= binarySearch(pairs, curr), max= 0;
            
            for(int i= index;i<pairs.length;i++)
                max= Math.max(max, 1+ call(pairs, pairs[i][1]));
            
            memo.put(curr, max);
            return max;
        }
    }
    
    int binarySearch(int[][] pairs, int find)
    {
        int ret= pairs.length, start= 0, last= pairs.length-1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(find< pairs[mid][0])
            {
                ret= mid;
                last= mid-1;
            }
            else
                start= mid+ 1;
        }
        
        return ret;
    }
    
    public int findLongestChain(int[][] pairs)
    {
        Arrays.sort(pairs, (a, b)-> (a[0]- b[0]));
        memo= new HashMap<>();
        
        return call(pairs, Integer.MIN_VALUE);
    }
}

// greedy
class Solution {
    public int findLongestChain(int[][] pairs) 
    {
        Arrays.sort(pairs, (a, b)-> (a[1]- b[1]));
        int start= Integer.MIN_VALUE;
        
        int ans= 0;
        for(int i=0;i<pairs.length;i++)
        {
            ans++;
            int val= pairs[i][1];
            while(i!= pairs.length && pairs[i][0]<= val)
                i++;
            i--;
        }
        
        return ans;
    }
}
