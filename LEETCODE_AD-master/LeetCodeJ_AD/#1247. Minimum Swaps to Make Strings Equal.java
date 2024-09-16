package LeetCodeJ;


class Solution {
    public int minimumSwap(String s1, String s2) {
        char[] arr1= s1.toCharArray();
        char[] arr2= s2.toCharArray();
        
        int x= 0;
        for(int i=0;i<arr1.length;i++) {
            if(arr1[i]== 'x') x++;
            if(arr2[i]== 'x') x++;
        }
        
        if(x%2!= 0 || (2*arr1.length-x)%2!= 0) return -1;
        
        int type1= 0, type2= 0;            
        for(int i=0;i<s1.length();i++) {
            if(arr1[i]!= arr2[i]) {
                type1+= arr1[i]== 'x'? 1: 0;
                type2+= arr1[i]== 'y'? 1: 0;
            } 
        }
        
        return type1/2+ type2/2+ type1%2+ type2%2;
    }
}
