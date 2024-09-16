package LeetCodeJ;// #1684. Count the Number of Consistent Strings


class Solution {
    public int countConsistentStrings(String allowed, String[] words) 
    {
        HashSet<Character> set= new HashSet<>();
        for(char c: allowed.toCharArray())
            set.add(c);
        
        int ans=0;
        for(String s: words)
        {
            boolean bool= true;
            for(char c: s.toCharArray())
                if(!set.contains(c))
                    bool= false;
            
            if(bool) ans++;
        }
     
        return ans;
    }
}
