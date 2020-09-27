//1599. Maximum Profit of Operating a Centennial Wheel

class Solution 
{
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) 
    {
        int max=Integer.MIN_VALUE;
        int rotation=0;
        
        int q= customers[0], i=0, cost=0;
        while(i< customers.length || q!=0)
        {
            cost+= boardingCost*(q>=4? 4: q)- runningCost;
            q-= (q>=4? 4: q);
            
            i++;
            if(i< customers.length)
                q+= customers[i];
            
            if(max< cost)
            {
                max= cost;
                rotation= i;
            }
            //System.out.println(cost+" "+q);
        }
        //System.out.println();
        return max<0? -1: rotation;
    }
}
