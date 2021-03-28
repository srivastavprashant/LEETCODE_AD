// #1805. Number of Different Integers in a String

class Solution {
    public int numDifferentIntegers(String word) {
        word+= 'l';
        HashSet<String> set= new HashSet<>();
        StringBuilder num= new StringBuilder();
        for(char c: word.toCharArray()) {
            if(c>= '0' && c<= '9')
                num.append(c);
            else {
                if(num.length()!= 0) {
                    set.add(removeZeros(num.toString()));
                    num= new StringBuilder();
                }
            }
        }
        
        return set.size();
    }
    
    String removeZeros(String s) {
        StringBuilder ans= new StringBuilder();
        boolean start= true;
        for(char c: s.toCharArray()) {
            if(!start)
                ans.append(c);
            else if(start && c!= '0') {
                start= false;
                ans.append(c);
            }
        }
            
        return ans.toString();
    }
}
