// 1090. Largest Values From Labels

class Solution {
    public int largestValsFromLabels(int[] value, int[] labels, int num_wanted, int use_limit) 
    {
        List<Integer> list= new ArrayList<>();
        HashMap<Integer, Integer> label= new HashMap<>();
        
        int c=0;
        for(int i=0;i<labels.length;i++)
            label.put(labels[i], label.getOrDefault(labels[i], c++));
        for(int i=0;i<value.length;i++)
            list.add(i);
        
        int[] used= new int[labels.length];
        Comparator<Integer> comp= new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return value[b]- value[a];
            }
        };
        
        Collections.sort(list, comp);
        
        int i=0, ans=0;
        while(num_wanted!=0 && i<list.size())
        {
            int index= list.get(i);
            if(used[label.get(labels[index])]< use_limit)
            { ans+= value[index]; used[label.get(labels[index])]++; num_wanted--;}
            
            i++;
        }
        
        return ans;
    }
}
