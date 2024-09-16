package LeetCodeJ;


class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        n= (1<< n);
        int index= -1;
        List<Integer> gray_code= new ArrayList<>();
        for(int i=0;i<n;i++) {
            gray_code.add(i^(i>>1));
            index= start== gray_code.get(i)? i: index;
        }
        
        List<Integer> ans= new ArrayList<>();
        for(int i= index;i!= n+index;i++) ans.add(gray_code.get(i%n));
        return ans;
    }
}
