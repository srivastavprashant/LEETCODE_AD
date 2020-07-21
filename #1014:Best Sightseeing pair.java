/*
  LINK: https://leetcode.com/problems/best-sightseeing-pair/submissions/
  Approach 1: ( Naive Approach)
              iterate the array: i
              And find the best value for it.
              O( N*N )
              
  Approach 2: We could make an array that store the best value which we can get at every index
              i.e we can achieve this by iterating from back and keeping track of the max element and storing it in array 
                  only key here is that at every iteration max value will be reduced by 1 due to the distance.
                  arr[]={8,1,5,2,6};
                  best[]={8,4,5,5,6};
                  
              And then all we have to do is find the max of arr[i]+ best[i+1], return the max-1.
*/
class Solution {
    public int maxScoreSightseeingPair(int[] arr) 
    {
        ArrayList<Integer> best=new ArrayList<Integer>();
        
        int max=0, c=0;
        for(int i=arr.length-1;i>=0;i--, max--)
        {
            max= Math.max(max, arr[i]);
            best.add(max);
        }
        
        Collections.reverse(best);
        for(int i=0;i<arr.length-1;i++)
            max= Math.max(max, arr[i]+ best.get(i+1));
        
        return --max;
    }
}

// we can concise the above soln even more but thats a little complex but runs in O( 1 ) extra space and takes only 1 traversal of the array.
class Solution {
    public int maxScoreSightseeingPair(int[] arr) 
    {
        int ans=0;
        
        int max=0, c=0;
        for(int i=arr.length-1;i>0;i--, max--)
        {
            max= Math.max(max, arr[i]);
            ans= Math.max(ans, max+ arr[i-1]);
        }
        
        return --ans;
    }
}
