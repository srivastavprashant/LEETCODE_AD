// #1839. Longest Substring Of All Vowels in Order


class Solution {
    private Set<Character> v= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public int longestBeautifulSubstring(String word) {
        int max= 0, count= 0;
        char l= 'a';
        Set<Character> set= new HashSet<>();
        for(char c: word.toCharArray()) {
            if(c< l) {
                l= c;
                count= 1;
                set= new HashSet<>();
                set.add(c);
            }
            else {
                count++;
                l= c;
                set.add(c);
            }
            
            if(set.size()== 5)
                    max= Math.max(max, count);
        }
            
        return max;
    }
}
