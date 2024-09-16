package LeetCodeJ;// #1262. Greatest Sum Divisible by Three


class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer>[] map= new ArrayList[3];
        map[0]= new ArrayList<>();
        map[1]= new ArrayList<>();
        map[2]= new ArrayList<>();
        int sum= 0;
        for(int i: nums)
        {
            sum+= i;
            if(i%3== 0) map[0].add(i);
            else if(i%3== 1) map[1].add(i);
            else if(i%3== 2) map[2].add(i);
        }
        
        Collections.sort(map[0]);
        Collections.sort(map[1]);
        Collections.sort(map[2]);
        
        if(sum%3== 0) return sum;
        else {
            if(sum%3== 1) {
                int val= map[1].size()!= 0? map[1].get(0): Integer.MAX_VALUE;
                int val2= map[2].size()>= 2? map[2].get(0)+ map[2].get(1): Integer.MAX_VALUE;
                return sum- Math.min(val, val2);
            }
            else {
                int val= map[1].size()>=2 ? map[1].get(0)+ map[1].get(1): Integer.MAX_VALUE;
                int val2= map[2].size()!= 0 ? map[2].get(0): Integer.MAX_VALUE;
                return sum- Math.min(val, val2);
            }
        }
    }
}
