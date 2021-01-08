// 873. Length of Longest Fibonacci Subsequence


class Solution 
{
    public int lenLongestFibSubseq(int[] arr) 
    {
        HashSet<Integer> set= new HashSet<>();
        for(int i: arr)
            set.add(i);
        
        int max= 0;
        for(int i= 0;i<arr.length;i++)
        {
            for(int j= i+1;j<arr.length;j++)
            {
                int f1= arr[i], f2= arr[j];
                
                int count= 2;
                while(set.contains(f1+ f2))
                {
                    f2= f1+f2;
                    f1= f2-f1;
                    count++;
                }
                max= Math.max(max, count);
            }
        }
        
        return max== 2? 0: max;
    }
}
