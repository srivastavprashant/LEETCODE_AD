package LeetCodeJ;// #1792. Maximum Average Pass Ratio


class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) 
    {
        double[] orig= new double[classes.length];
        for(int i=0;i<orig.length;i++)
            orig[i]= classes[i][0]*1.0d/classes[i][1];
            
        PriorityQueue<double[]> q= new PriorityQueue<>((a, b)-> (a[1]>= b[1]? -1: 1));
        for(int i=0;i<classes.length;i++)
            q.add(new double[]{i*1.0d, (classes[i][0]+1)*1.0d/(classes[i][1]+1)- orig[i]});
        
        while(extraStudents!= 0)
        {
            double[] curr= q.poll();
            classes[(int)curr[0]][0]++;
            classes[(int)curr[0]][1]++;
            orig[(int)curr[0]]+= curr[1];
            
            int i= (int)curr[0];
            q.add(new double[]{i*1.0d, (classes[i][0]+1)*1.0d/(classes[i][1]+1)- orig[i]});
            extraStudents--;
        }
        
        double sum= 0.0d;
        for(double i: orig)
            sum+= i;
        
        return sum/classes.length;
    }
}
