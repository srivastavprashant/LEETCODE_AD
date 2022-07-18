// #1887. Reduction Operations to Make the Array Elements Equal


class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b-a);
        for(int i: nums) map.put(i, map.getOrDefault(i, 0)+1);
        
        int ans = 0, currSum = 0;
        for(int i: map.keySet()) {
            if(map.lastKey() == i) continue;
            ans += (currSum + map.get(i));
            currSum += map.get(i);
        }
        
        return ans;
    }
}
