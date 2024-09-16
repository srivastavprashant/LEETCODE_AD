package LeetCodeJ;// #775. Global and Local Inversions


class Solution {
    public boolean isIdealPermutation(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(Math.abs(i- arr[i])>1) return false;
        }
        
        return true;
    }
}

// every local inversion is a global inversion with j= i+1.
// so for any index i if it has more than one value for j which satisfies conditions
// for global inversion that means the no of local!= global.

// but for some reason we have a permutation of [0, n-1] and not just random nos.
// .........................we can still complete the func in O(N) resonable time 
// without caring about the permutation though.

// OBSERVATIONS: 
//      1. for any no all elements ahead of him should be greater than it except for no just ahead of him.
//      2. for any no all element behind him should be smaller except for the no just behind him.
