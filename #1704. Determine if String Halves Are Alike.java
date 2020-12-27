// #1704. Determine if String Halves Are Alike

class Solution {
    public boolean halvesAreAlike(String s) 
    {
        s= s.toLowerCase();
        int vowel= 0;
        HashSet<Character> vowels= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(int i=0;i<s.length()/2;i++)
            if(vowels.contains(s.charAt(i))) vowel++;
        
        for(int i=s.length()/2;i<s.length();i++)
            if(vowels.contains(s.charAt(i))) vowel--;
        
        return vowel== 0;
    }
}
