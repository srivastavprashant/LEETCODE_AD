package LeetCodeJ;

class Solution {
    public boolean checkPowersOfThree(int n) {
        int power= 1;
        TreeSet<Integer> set= new TreeSet<>();
        while(power<= (int)1e7) {
            set.add(power);
            power*= 3;
        }
        
        while(n!= 0) {
            if(set.floor(n)!= null) {
                int val= set.floor(n);
                set.remove(val);
                n-= val;
            } else return false;
        }
        
        return n== 0;
    }
}
