package LeetCodeJ;

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set= new HashSet<>();
        for(int i[]: triplets) {
            if(i[0]== target[0] && i[1]<= target[1] && i[2]<= target[2]) set.add(0);
            if(i[1]== target[1] && i[0]<= target[0] && i[2]<= target[2]) set.add(1);
            if(i[2]== target[2] && i[1]<= target[1] && i[0]<= target[0]) set.add(2);
        }
        
        return set.size()== 3;
    }
}
