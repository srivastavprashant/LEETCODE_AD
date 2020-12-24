// #491. Increasing Subsequences



class Solution 
{
    List<List<Integer>> ans;
    void call(int[] nums, int curr, int n, List<Integer> arr)
    {
        if(arr.size()>1)
            ans.add(new ArrayList<>(arr));
        if(curr==n) return;
        
        HashSet<Integer> set= new HashSet<>();
        int last= (arr.size()==0? Integer.MIN_VALUE: arr.get(arr.size()-1));
        
        for(int i=curr;i<n;i++)
        {
            if(set.contains(nums[i]) || last> nums[i]) continue;
            
            arr.add(nums[i]);
            call(nums, i+1, n, arr);
            arr.remove(arr.size()-1);
            set.add(nums[i]);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        ans= new ArrayList<>();
        call(nums, 0, nums.length, new ArrayList<>());        
        
        return ans;
    }
}
