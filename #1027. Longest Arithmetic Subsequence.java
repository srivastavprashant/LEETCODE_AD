// #1027. Longest Arithmetic Subsequence



class Solution {
    public int longestArithSeqLength(int[] arr) {
        HashMap<Integer, Integer>[] map= new HashMap[arr.length];
        int max= 0;
        for(int i= arr.length-1;i>=0;i--) {
            map[i]= new HashMap<>();
            
            for(int j= i+1;j< arr.length;j++) {
                int diff= arr[i]- arr[j];
                int val= Math.max(map[j].getOrDefault(diff, 0)+1, map[i].getOrDefault(diff, 0));
                map[i].put(diff, val);
                max= Math.max(val, max);
            }
        }
        
        return max+1;
    }
}
