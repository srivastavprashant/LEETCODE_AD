#973. K Closest Points to Origin



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        TreeSet<int[]> distance= new TreeSet<>((i, j)-> (i[1]== j[1]? i[0]-j[0]: i[1]-j[1]));
        for(int i=0;i<points.length;i++) {
            int dist= points[i][0]* points[i][0]+ points[i][1]* points[i][1];
            distance.add(new int[]{i, dist});
        }
        
        int[][] ans= new int[k][2];
        for(int i=0;i<k;i++) ans[i]= points[distance.pollFirst()[0]];
        return ans;
    }
}
