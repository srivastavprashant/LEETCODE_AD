// 740. Delete and Earn



class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0)+ i);
        
        List<Integer> arr= new ArrayList<>(map.keySet());
        Collections.sort(arr);
        
        int[] dp= new int[arr.size()];
        for(int i= 0;i<arr.size();i++) {
            dp[i]= map.get(arr.get(i));
            for(int j= 0;j< i;j++) 
                if(arr.get(i)- arr.get(j)!= 1) dp[i]= Math.max(dp[i], dp[j]+ map.get(arr.get(i)));
        }
        
        int max= Integer.MIN_VALUE;
        for(int i: dp)
            max= Math.max(i, max);
        
        return max; 
    }
}
