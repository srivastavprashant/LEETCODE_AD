
class Solution {
    public int maxCoins(int[] piles) 
    {
        long ans=0;
        int start=1, last= piles.length-1;
        Arrays.sort(piles);
        
        int[] arr=new int[piles.length];
        for(int i=0;i<piles.length;i++)
            arr[i]= piles[piles.length-i-1];
        
        while(start<last)
        {
            ans+= arr[start];
            last--;
            start+=2;
        }
        return (int )ans;
    }
}
