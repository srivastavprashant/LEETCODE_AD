// #1405. Longest Happy String


class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q= new PriorityQueue<int[]>((_a,_b)->(_b[1]- _a[1]));
        if(a!= 0) q.add(new int[]{0, a}); 
        if(b!= 0) q.add(new int[]{1, b}); 
        if(c!= 0) q.add(new int[]{2, c});
        
        StringBuilder ans= new StringBuilder("");
        char[] arr= {'a', 'b', 'c'};
        while(!q.isEmpty()) {
            int[] curr= q.poll(), curr2= null;
            if(!q.isEmpty()) curr2= q.poll();
            
            if(curr[1]== 1) 
                ans.append(arr[curr[0]]);
            else {
                ans.append(arr[curr[0]]);
                ans.append(arr[curr[0]]);
                if((curr[1]-=2) != 0) q.add(curr);
            }
            
            if(curr2== null) break;
            if(curr2[1]> curr[1]) { q.add(curr2); continue; }
            ans.append(arr[curr2[0]]);
            
            if((curr2[1]-=1) != 0) q.add(curr2);
        }
        
        return ans.toString();
    }
}
