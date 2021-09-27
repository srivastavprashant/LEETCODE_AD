// #791. Custom Sort String


class Solution {
    public String customSortString(String order, String s) {
        int[] map= new int[26];
        for(int i=0;i<order.length();i++) map[order.charAt(i)-'a']= i;
        List<Character> list= new ArrayList<>();
        for(char c: s.toCharArray()) list.add(c);
        Collections.sort(list, (i, j)->(map[i-'a']== map[j-'a']? i- j: map[i-'a']- map[j-'a']));
        StringBuilder ans= new StringBuilder("");
        for(char c: list) ans.append(c);
        return ans.toString();
    }
}
