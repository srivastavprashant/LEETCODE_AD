package LeetCodeJ;// #1806. Minimum Number of Operations to Reinitialize a Permutation

class Solution {
    public int reinitializePermutation(int n) {
        int[] prem= new int[n];
        for(int i=0;i<n;i++)
            prem[i]= i;
        
        int count= 0;
        while(true) {
            count++;
            int[] temp= new int[n];
            for(int i=0;i<n;i++) {
                if(i%2== 0) temp[i]= prem[i/2];
                else temp[i]= prem[n/2+ (i-1)/2];
            }
            
            if(check(temp)) return count;
            prem= temp;
        }
    }
    
    boolean check(int[] arr) {
        for(int i=0;i<arr.length;i++)
            if(arr[i]!= i) return false;
        return true;
    }
}
