package LeetCodeJ;// 1637. Widest Vertical Area Between Two Points Containing No Points


class Solution {
    public int maxWidthOfVerticalArea(int[][] points) 
    {
        int max=0;
        ArrayList<Integer> arr= new ArrayList<>();
        for(int[] i: points)
            arr.add(i[0]);
        
        Collections.sort(arr);
        for(int i=1;i<arr.size();i++)
            max= Math.max(max, arr.get(i)- arr.get(i-1));
        
        return max;        
    }
}
