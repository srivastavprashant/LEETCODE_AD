package LeetCodeJ;// #1870. Minimum Speed to Arrive on Time



class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        long ret= -1, s= 1, l= Integer.MAX_VALUE;
        
        while(s<= l) {
            long m= s+(l-s)/2;
            
            if(check(dist, hour, m)) {
                ret= m;
                l= m-1;
            }
            else s= m+1;
        }
        
        return (int)ret;
    }
    
    boolean check(int[] d, double hr, long m) {
        double curr= 0.0d;
        for(int i=0;i<d.length;i++) {
            double time;
            if(i!= d.length-1) time= Math.ceil(d[i]*1.0d/m);
            else time= d[i]*1.0d/m;
            curr+= time;            
        }
        
        return curr<= hr;
    }
}
