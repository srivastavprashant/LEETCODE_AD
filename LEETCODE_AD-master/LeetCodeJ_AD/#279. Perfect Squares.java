package LeetCodeJ;// #279. Perfect Squares



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


// Lagrange's four square theorem.
class Solution {
    HashSet<Integer> square;
    public int numSquares(int n) {
        square= new HashSet<>();
        call(n);
        
        if(square.contains(n)) return 1;
        else if(twoSquare(n)) return 2;
        else if(threeSquare(n)) return 3;
        else return 4;
    }
    
    private void call(int n) {
        for(int i=1;i*i<=n;i++)
            square.add(i*i);
    }
    
    private boolean twoSquare(int n) {
        for(int i: square) {
            if(square.contains(n-i)) return true;
        }
        
        return false;
    }
    
    private boolean threeSquare(int n) {
        for(int i: square) {
            int val= n-i;
            if(twoSquare(val)) return true;
        }
        
        return false;
    }
    
}
