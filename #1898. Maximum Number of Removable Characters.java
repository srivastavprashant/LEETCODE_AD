class Solution {
    public int maximumRemovals(String S, String p, int[] removable) {
        int s= 0, l= removable.length-1, ret= -1;
        while(s<= l) {
            int m= s+(l-s)/2;            
            if(predicate(S, p, removable, m)) {
                s= m+1;
                ret= m;
            }
            else l= m-1;
        }
        return ret+1;
    }
    
    private boolean predicate(String s, String p, int[] rem, int m) {
        char[] arr= s.toCharArray();
        for(int i=0;i<=m;i++) arr[rem[i]]= '.';
        // System.out.println(new String(arr)+" "+p);
        
        int ind= 0;
        for(char c: arr) if(ind< p.length() && c== p.charAt(ind)) ind++;
        // System.out.println(m+" "+s+" "+(ind== p.length()));
        return ind== p.length();
    }
}
