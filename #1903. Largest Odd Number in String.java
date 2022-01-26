

// Efficient soln O(n)

class Solution {
    public String largestOddNumber(String num) {
        char[] arr= num.toCharArray();
        int i= 0;
        for(i=arr.length-1;i>=0;i--) {
            if(arr[i]%2== 1) break; 
        }
        
        return num.substring(0, i+1);
    }
}
