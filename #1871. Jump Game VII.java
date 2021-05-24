// #1871. Jump Game VII


class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {    
        TreeSet<Integer> set= new TreeSet<>();
        set.add(0);
        
        for(int i= 0;i<s.length();i++) {
            if(set.contains(i) || s.charAt(i)== '1') continue;
            else {
                int max= i- minJump;
                if(set.floor(max)== null) continue;
                else {
                    int temp= set.floor(max);
                    if(temp>= i- maxJump) set.add(i);
                }
            }
        }
        
        return set.contains(s.length()-1);
    }
}
