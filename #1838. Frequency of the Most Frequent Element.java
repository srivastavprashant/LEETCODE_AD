// #1838. Frequency of the Most Frequent Element


class Solution {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i, 0)+ 1);
        
        List<Integer> set= new ArrayList<>(map.keySet());
        Collections.sort(set);
        
        int max= 0;
        for(int i=0;i<set.size();i++) {
            int freq= map.get(set.get(i));
            
            int temp= k, j= i-1;
            while(temp!= 0 && j!= -1) {
                int diff= set.get(i)- set.get(j);
                int add= Math.min(temp/diff, map.get(set.get(j)));
                freq+= add;
                
                temp-= add*diff;
                if(temp<diff) break;
                j--;
            }
            
            max= Math.max(max, freq);
        }
        
        return max;
    }
}
