package LeetCodeJ;// #1710. Maximum Units on a Truck


class Solution 
{
    int units= 1, boxes= 0;
    public int maximumUnits(int[][] boxTypes, int truckSize)
    {
        Arrays.sort(boxTypes, (int[]a, int[] b) -> (b[units]- a[units]));
        
        int i= 0, ans= 0;
        while(truckSize>0 && i< boxTypes.length)
        {
            ans+= (boxTypes[i][units]* (truckSize>= boxTypes[i][boxes]? boxTypes[i][boxes]: truckSize));
            truckSize-= boxTypes[i++][boxes];
        }
        
        return ans;
    }
}
