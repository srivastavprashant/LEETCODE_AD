package LeetCodeJ;

class Solution {
    public List<String> simplifiedFractions(int n) {
        Map<Integer, Set<Integer>> map= new HashMap<>();
        for(int i=1;i<=n;i++) map.put(i, new HashSet<>());
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<i;j++) {
                int gcd= gcd(i, j);
                map.get(i/gcd).add(j/gcd);
            }
        }
        
        List<String> ans= new ArrayList<>();
        for(int i: map.keySet()) {
            for(int j: map.get(i)) ans.add(j+"/"+i);
        }
        
        return ans;
    }
    
    int gcd(int a, int b) {
        if(b== 0) return a;
        else return gcd(b, a%b);
    }
}
