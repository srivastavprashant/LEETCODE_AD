// #1347. Minimum Number of Steps to Make Two Strings Anagram
class Solution {
    public int minSteps(String s, String t) 
    {
        int[] arr=new int[26];
        for(char c: s.toCharArray())
            arr[c-'a']++;
        
        int ans=0;
        for(char c: t.toCharArray())
            if(--arr[c-'a']<0)
                ans++;
        
        return ans;
    }
}
