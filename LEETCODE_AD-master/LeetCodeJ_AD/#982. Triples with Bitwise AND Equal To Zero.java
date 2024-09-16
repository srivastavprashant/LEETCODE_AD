package LeetCodeJ;

class Solution {
    public int countTriplets(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<(1<<16);i++) map.put(i, count(nums, i));
        
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums.length;j++) {
                int val = nums[i] & nums[j];
                ans+= map.getOrDefault(val, 0);
            }
        }
        
        return ans;
    }
    
    public int count(int[] nums, int val) {
        int ret = 0;
        for(int i: nums) if((val & i) == 0) ret++;
        return ret;
    }
}
