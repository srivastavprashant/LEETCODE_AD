#869. Reordered Power of 2


class Solution {
    public boolean reorderedPowerOf2(int n) {
        int power= 1;
        int len= (n+"").length();
        while(len> (power+"").length()) power<<= 1;
        
        while(len== (power+"").length()) {
            if(check(power, len, n)) return true;
            power<<= 1;
        }
        return false;
    }
    
    boolean check(int power, int len, int n) {
        if((power+"").length()!= len) return false;
        else {
            int[] map= new int[10];
            for(char c: (power+"").toCharArray()) map[c-'0']++;
            for(char c: (n+"").toCharArray()) map[c-'0']--;
            for(int i: map) if(i!= 0) return false;
        }
        
        System.out.println(power);
        
        return true;
    }
}
