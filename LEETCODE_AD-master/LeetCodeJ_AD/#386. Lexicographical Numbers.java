package LeetCodeJ;// #386. Lexicographical Numbers



class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> ans= new ArrayList<>();
        for(int i=1;i<=n;i++) ans.add(i+"");
        Collections.sort(ans);
        
        List<Integer> ret= new ArrayList<>();
        for(String s: ans) ret.add(Integer.parseInt(s));
        return ret;
    }

}
