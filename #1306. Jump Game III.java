// BFS

class Solution {
    public boolean canReach(int[] arr, int start) 
    {
        final int UPPER_BOUND = arr.length;
        final int LOWER_BOUND = -1;
        
        Queue<Integer> q= new LinkedList<>();
        boolean[] seen=new boolean[UPPER_BOUND];
        q.add(start);
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size;i++)
            {
                int curr= q.poll();
                
                if(seen[curr])
                    break;
                else
                    seen[curr]= true;
                
                if(arr[curr]==0)
                    return true;
                
                if(curr- arr[curr]> LOWER_BOUND) 
                    q.add(curr- arr[curr]);
                
                if(curr+ arr[curr]<UPPER_BOUND)
                    q.add(curr+ arr[curr]);
            }
        }
        
        return false;        
    }
}
