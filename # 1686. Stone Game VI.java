# 1686. Stone Game VI



class Solution 
{
    public int stoneGameVI(int[] aliceValues, int[] bobValues) 
    {
        int[] sum= new int[aliceValues.length];
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<aliceValues.length;i++)
        {
            sum[i]+= aliceValues[i]+ bobValues[i];
            arr.add(i);
        }
        
        Collections.sort(arr, (a, b) -> (sum[b]-sum[a]));
        int sum_a= 0, sum_b= 0;
        for(int i=0;i<arr.size();i++)
        {
            if(i%2==0)
                sum_a+= aliceValues[arr.get(i)];
            else
                sum_b+= bobValues[arr.get(i)];
        }
        
        return (sum_a> sum_b? 1: (sum_a== sum_b? 0: -1));
    }
}
