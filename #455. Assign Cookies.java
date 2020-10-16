// 455. Assign Cookies


class Solution {
    public int findContentChildren(int[] g, int[] s)
    {
        Arrays.sort(s);
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int content=0;
        
        for(int i: g)
            q.add(i);
        
        for(int i=0;i<s.length && !q.isEmpty();i++)
            if(s[i]>=q.peek())
            { content++; q.poll(); }
        
        return content;        
    }
}
