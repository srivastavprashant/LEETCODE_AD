// #1814. Count Nice Pairs in an Array


class Solution {
    int MOD= 1000000007;
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            StringBuilder rev= new StringBuilder(nums[i]+"");
            int _rev= Integer.parseInt(rev.reverse().toString());
            
            map.put(nums[i]- _rev, map.getOrDefault(nums[i]- _rev, 0)+ 1);
        }
        
        int ans= 0;
        for(int i=0;i<nums.length;i++) {
            StringBuilder rev= new StringBuilder(nums[i]+"");
            int _rev= Integer.parseInt(rev.reverse().toString());
            ans= add(ans, map.get(nums[i]- _rev)-1);
        }
        
        return (int)((ans*1l*500000004)% MOD);
    }
    
    int add(int a, int b) {
        if(a+b>= MOD) return a+b- MOD;
        return a+b;
    }
}
