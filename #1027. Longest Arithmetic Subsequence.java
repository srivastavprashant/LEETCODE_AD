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

// We can just use an array as a map that would be much faster and easier to implement.
class Solution {
    public int longestArithSeqLength(int[] arr) {
        int[][] map= new int[arr.length][1001];
        int max= 0;
        
        for(int i= arr.length-1;i>=0;i--) {
            for(int j= i+1;j< arr.length;j++) {
                int diff= arr[i]- arr[j];
                diff+= 500;
                map[i][diff]= Math.max(map[i][diff], map[j][diff]+1);
                max= Math.max(max, map[i][diff]);
            }
        }
        
        return max+1;
    }
}
