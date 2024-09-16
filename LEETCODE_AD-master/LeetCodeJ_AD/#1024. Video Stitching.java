package LeetCodeJ;// #1024. Video Stitching

// Dont know why people went for Nlogn soln instead of this.

class Solution {
    private int ans;
    private int[] max;
    
    private void helper(int curr, int clips_used, int t) {
        if(curr>= t) ans= Math.min(ans, clips_used);
        else {
            int last= max[curr];
            if(last== curr) return;
            
            helper(last, clips_used+1, t);
        }
    }
    
    private void findMax(int[][] clips) {
        max= new int[101];
        for(int[] i: clips)
            max[i[0]]= Math.max(max[i[0]], i[1]);
        
        int val= 0;
        for(int i=0;i<101;i++) {
            val= Math.max(max[i], val);
            max[i]= val; 
        }
    }
    
    public int videoStitching(int[][] clips, int t) {
        ans= Integer.MAX_VALUE;
        findMax(clips);
        helper(0, 0, t);
        
        return ans== Integer.MAX_VALUE? -1: ans;
    }
}

// type of query on which i am focusing is :
    // start should be less than specified value and 
    // at the same time i want last value to be max.
