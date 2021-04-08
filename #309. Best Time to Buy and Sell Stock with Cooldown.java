// #309. Best Time to Buy and Sell Stock with Cooldown



class Solution {
    int[] memo;
    private int helper(int[] arr, int index) {
        if(index>= arr.length-1) return 0;
        else if(memo[index]!= 0) return memo[index];
        else {
            int profit= 0, min= arr[index];
            for(int i= index;i<arr.length;i++) {
                min= Math.min(min, arr[i]);
                if(arr[i]- min> 0)
                    profit= Math.max(profit, arr[i]- min+ helper(arr, i+2));
            }
            
            memo[index]= profit;
            return profit;
        }
    }
    public int maxProfit(int[] prices) {
        memo= new int[prices.length];
        return helper(prices, 0);
    }
}
