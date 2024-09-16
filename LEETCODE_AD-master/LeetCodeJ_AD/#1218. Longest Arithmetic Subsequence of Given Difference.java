package LeetCodeJ;// #1218. Longest Arithmetic Subsequence of Given Difference

// memoization O(NlogN)
class Solution {
    private int[] dp;
    private Map<Integer, List<Integer>> map;
    private int helper(int[] arr, int d, int curr) {
        if(dp[curr]!= 0) return dp[curr];
        else {
            int find= arr[curr]+ d;
            if(!map.containsKey(find)) dp[curr]= 1;
            else {
                int index= binarySearch(map.get(find), curr);
                if(index== -1) dp[curr]= 1;
                else dp[curr]= 1+ helper(arr, d, map.get(find).get(index));
            }
            
            return dp[curr];
        }
    }
    
    private int binarySearch(List<Integer> arr, int find) {
        int ret= -1, start= 0, last= arr.size()-1;
        while(last>= start) {
            int mid= start+ (last- start)/2;
            if(arr.get(mid)> find) {
                last= mid-1;
                ret= mid;
            }
            else start= mid+ 1;
        }
        
        return ret;
    }
    
    public int longestSubsequence(int[] arr, int difference) {
        dp= new int[arr.length];
        map= new HashMap<>();        
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) map.get(arr[i]).add(i);
            else {
                List<Integer> temp= new ArrayList<>();
                temp.add(i);
                map.put(arr[i], temp);
            }
        }
        
        int max= 0;
        for(int i=0;i<arr.length;i++)
            max= Math.max(max, helper(arr, difference, i));
        
        return max;
    }
}

// Tabulation O(N)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map= new HashMap<>();
        int max= 0;
        for(int i: arr) {
            map.put(i, map.getOrDefault(i-difference, 0)+ 1);
            max= Math.max(max, map.get(i));
        }
        
        return max;
    }
}
