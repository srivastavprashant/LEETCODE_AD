// #473. Matchsticks to Square


// A dumb way to solve it.
class Solution 
{
    int size;
    boolean call(List<Integer> arr, int curr, List<List<Integer>> group, int[] sum)
    {
        if(curr== arr.size())
        {
            if(size!= arr.size())
                return sum[0] == sum[1];   
            
            List<List<Integer>> temp1= new ArrayList<>();
            List<List<Integer>> temp2= new ArrayList<>();
            temp1.add(new ArrayList<>());
            temp1.add(new ArrayList<>());
            temp2.add(new ArrayList<>());
            temp2.add(new ArrayList<>());
            
            if(sum[0]== sum[1] && call(group.get(0), 0, temp1, new int[]{0, 0}) 
              && call(group.get(1), 0, temp2, new int[]{0, 0}))
                return true; 
            return false;
        }
        
        int val= arr.get(curr);
        boolean found= false;
        
        sum[0]+= val;
        group.get(0).add(val);
        found|= call(arr, curr+1, group, sum);
        sum[0]-= val;
        group.get(0).remove(group.get(0).size()-1);
        
        sum[1]+= val;
        group.get(1).add(val);
        found|= call(arr, curr+1, group, sum);
        sum[1]-= val;
        group.get(1).remove(group.get(1).size()-1);
        
        return found;
    }
    
    public boolean makesquare(int[] nums) 
    {
        if(nums.length<4) return false;
        size= nums.length;
        List<Integer> arr= new ArrayList<>();
        for(int i: nums)
            arr.add(i);
        
        List<List<Integer>> temp= new ArrayList<>();
        temp.add(new ArrayList<>());
        temp.add(new ArrayList<>());
        return call(arr, 0, temp, new int[]{0, 0});
    }
}

// Approach 2:
