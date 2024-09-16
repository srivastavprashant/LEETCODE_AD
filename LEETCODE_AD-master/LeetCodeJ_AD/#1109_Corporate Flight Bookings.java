package LeetCodeJ;

/*
  LINK: https://leetcode.com/problems/corporate-flight-bookings/submissions/
  Approach 1: ( Naive Approach ) 
              we could just iterate from index to index and add the booked seats.
              O( No.of bookings* No. of flights ) ~ 4* 10^8.
  
  Approach 2: To reduce the time complexity we can just iterate through the bookings and 
              place the booked seats at start and -1* booked seats at end.
              Then we can just add the values and store the value of sum at that particular index.
              O( No of flights ). ~ 2* 10^4.
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) 
    {
        int[] ans=new int[n];
        
        for(int[] i: bookings)
        {
            ans[i[0]-1]+= i[2];
            if(i[1]!=n) ans[i[1]]+= -1* i[2];
        }
        
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+= ans[i];
            ans[i]= sum;
        }
        return ans;
    }
}
