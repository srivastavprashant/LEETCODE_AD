// #813. Largest Sum of Averages



class Solution {
    double[][] memo;
    int[] presum;
    double call(int[] arr, int k, int curr)
    {
        if(curr>= arr.length && k!=0) return Integer.MIN_VALUE;
        else if(memo[curr][k]!= 0.0d) return memo[curr][k];
        else
        {
            double val= 0;
            if(k== 1)
                val= (presum[arr.length-1]- (curr!= 0? presum[curr-1]: 0))/(1.0d*(arr.length- curr));
            else
            {
                for(int i= curr;i<=arr.length-k;i++)
                {
                    double avg= (presum[i]- (curr!= 0? presum[curr-1]:0))/(1.0d*(i- curr+ 1));
                    val= Math.max(val, avg+ call(arr, k-1, i+1));
                }
            }
                    
            memo[curr][k]= val;
            return val;
        }
        
    }
    
    public double largestSumOfAverages(int[] A, int K) 
    {
        memo= new double[A.length][K+1];
        presum= new int[A.length];
        
        for(int i=0;i<A.length;i++)
            presum[i]= A[i]+ (i!=0? presum[i-1]: 0);
            
        return call(A, K, 0);
    }
}
