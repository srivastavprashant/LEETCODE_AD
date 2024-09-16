package LeetCodeJ;

class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors= new ArrayList<>();
        for(int i=1;i*i<= n;i++) {
            if(n%i== 0) {
                factors.add(i);
                if(i*i!= n) factors.add(n/i);
            }
        }
        
        Collections.sort(factors);
        // System.out.println(factors);
        if(factors.size()< k) return -1;
        else return factors.get(k-1);
    }
}
