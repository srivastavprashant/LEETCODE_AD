package LeetCodeJ;// 1539. Kth Missing Positive Number

class Solution {
    public int findKthPositive(int[] arr, int k) 
    {
        int i=1, c=0;
        while(k!=0)
        {
            if(c< arr.length && i== arr[c])
            { c++; i++;}
            
            else
            { i++; k--;}
        }
        
        return i-1;
    }
}
