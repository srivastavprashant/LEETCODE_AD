package LeetCodeJ;// 2170. Minimum Operations to Make the Array Alternating

class Solution {
    public int minimumOperations(int[] nums) {
        int n= nums.length;
        if(n== 1) return 0;
        TreeSet<int[]> even= helper(nums, 0);
        TreeSet<int[]> odd= helper(nums, 1);
        if(even.first()[0]!= odd.first()[0]) return n- even.first()[1]- odd.first()[1];
        else {
            int[] e= even.pollFirst(), o= odd.pollFirst();
            return Math.min(n- e[1]- (odd.size()==0? 0: odd.first()[1]), n- o[1]- (even.size()== 0? 0: even.first()[1]));
        }
    }
    
    TreeSet<int[]> helper(int[] arr, int _i) {
        int[] map= new int[100002];
        TreeSet<int[]> set= new TreeSet<>((i, j)-> i[1]== j[1]? i[0]-j[0]: j[1]-i[1]);
        for(;_i<arr.length;_i+=2) map[arr[_i]]++;
        
        for(int i=1;i<map.length;i++) {
            if(map[i]!= 0)
                set.add(new int[]{i, map[i]});
        }
        
        return set;
    }
}
