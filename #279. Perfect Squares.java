// #279. Perfect Squares



class Solution {
    List<Integer> squares;
    public int numSquares(int n) {    
        int[] dp= new int[n+1];
        Arrays.fill(dp, 100000);
        dp[0]= 0;
        call(n);
        Collections.sort(squares);
        
        for(int i: squares) {
            int[] temp= new int[n+1];
            Arrays.fill(temp, 100000);
            temp[0]= 0;
            for(int sum= 1;sum<= n;sum++) {
                if(sum<i) temp[sum]= dp[sum];
                else if(temp[sum- i]!= 10000) 
                    temp[sum]= Math.min(dp[sum], temp[sum-i]+1);
            }
            dp= temp;
        }
        
        return dp[n];
    }
    
    private void call(int n) {
        squares= new ArrayList<>();
        for(int i=1;i*i<= n;i++) {
            squares.add(i*i);
        }
    }
}
