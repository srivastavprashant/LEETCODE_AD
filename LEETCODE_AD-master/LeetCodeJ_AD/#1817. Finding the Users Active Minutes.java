package LeetCodeJ;// #1817. Finding the Users Active Minutes

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map= new HashMap<>();
        for(int[] i: logs){
            if(map.containsKey(i[0])) map.get(i[0]).add(i[1]);
            else {
                Set<Integer> temp= new HashSet<>();
                temp.add(i[1]);
                map.put(i[0], temp);
            }
        }
        int[] ans= new int[k];
        for(int i: map.keySet()) {
            ans[map.get(i).size()-1]++;
        }
            
        return ans;
    }
}
