package LeetCodeJ;// #1807. Evaluate the Bracket Pairs of a String


class Solution {
    public String evaluate(String _s, List<List<String>> knowledge) {
        HashMap<String, String> map= new HashMap<>();
        for(List<String> s: knowledge) {
            map.put(s.get(0), s.get(1));
        }
        
        StringBuilder ans= new StringBuilder();
        char[] arr= _s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            char c= arr[i];
            if(c== '(') {
                i++;
                StringBuilder key= new StringBuilder();
                while(arr[i]!= ')') {
                    key.append(arr[i]);
                    i++;
                }
                
                ans.append(map.getOrDefault(key.toString(), "?"));
            }
            else
                ans.append(c);
        }
        
        return ans.toString();
    }
}
