

class Solution {
    public int numberOfBeams(String[] bank) {
        int ans= 0, prev= 0;
        for(String arr: bank) {
            int count= 0;
            for(char c: arr.toCharArray()) {
                if(c== '1') count++;
            }
            
            ans+= prev*count;
            if(count!= 0) prev= count;
        }
        
        return ans;
    }
}
