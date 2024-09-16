package LeetCodeJ;//#848. Shifting Letters

class Solution {
    public String shiftingLetters(String s, int[] _shifts) {
        long shifts= 0;
        char[] arr= s.toCharArray();
        for(int i=arr.length-1;i>=0;i--) {
            shifts+= _shifts[i];
            arr[i]= (char)((arr[i]-97+ shifts)%26+ 97);
        }
        
        return new String(arr);
    }
}
