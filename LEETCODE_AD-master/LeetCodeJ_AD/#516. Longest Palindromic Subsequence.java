package LeetCodeJ;// #516. Longest Palindromic Subsequence



class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder br= new StringBuilder(s);
        br.reverse();
        return longestCommonSubsequence(s, br.toString());
    }
    
    int longestCommonSubsequence(String text1, String text2)     
    {
        char[] arr= text1.toCharArray();
        char[] arr2= text2.toCharArray();
        
        int[] tab= new int[arr.length];
        for(int i=0;i<arr2.length;i++)
        {
            int[] temp= new int[arr.length];
            for(int j=0;j<temp.length;j++)
                temp[j]= Math.max(Math.max(tab[j], (j!= 0? temp[j-1]: 0)), (arr[j]== arr2[i]?1: 0)+ (j!=0? tab[j-1]: 0));
                
            tab= temp;
            // for(int j=0;j<tab.length;j++)
            //     System.out.print(tab[j]+" ");
            // System.out.println();
        }
        
        return tab[tab.length-1];
    }
}
