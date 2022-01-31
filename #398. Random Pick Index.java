

class Solution {
    HashMap<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        map= new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int key = nums[i];
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> arr= map.get(target);
        int index= (int)(Math.random()*arr.size());
        return arr.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
