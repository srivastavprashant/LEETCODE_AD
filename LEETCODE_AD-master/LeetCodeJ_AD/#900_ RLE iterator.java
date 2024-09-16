package LeetCodeJ;/*
  Approach 1: Just make an array that has the elements given no of time.(Naive Approach)
              Cons: Wastage a lot of memory as frequency can be 10^9
                    Creating that array will be time taking O( 500 * 10^9) in worst case
              Pros: Altough creating the array will take time but once created then, 
                    We can handle all the next operations in O( 1 ) time.
                    
  Approach 2: Use the presum approach i.e. make two arrays one containing the value at index i and
              other contains the last index of that value in our imaginary array which we did'nt created to save space.
              So, creating the array or implemnting that array will be in O( A.length ) time complexity which is max 1000.
              And now for the next operation we can save index by constanly adding the index till which we have exhausted and then find 
              the value associated with the last index exhausted.
              So, now time complexity is O( no of next operation* log N). Which is a huge improvement from previous approach. 
*/

class RLEIterator 
{
    ArrayList<Integer> value;
    ArrayList<Long> freq;
    long index; 
    
    public RLEIterator(int[] A) 
    {
        index=0;
        value= new ArrayList<Integer>();
        freq=new ArrayList<Long>();
        
        long val=0;
        
        for(int i=0;i<A.length;i+=2)
        {
            if(A[i]==0)
                continue;
            value.add(A[i+1]);
            val+= A[i];
            freq.add(val);
        }
    }
    
    public int next(int n) 
    {
        index+= n;
        int val= binarySearch(index);
        
        if(val== freq.size())
            return -1;
        else
            return value.get(val);
    }
    
    int binarySearch(long key) // returns the index of the key or the next higher value.
    {
        int start=0, end=value.size()-1;
        while(start<= end)
        {
            int mid= start+ (end- start)/2;
            
            if(freq.get(mid)== key)
                return mid;
            else if(freq.get(mid)>key)
                end= mid-1;
            else
                start+= 1;
        }
        return start;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
