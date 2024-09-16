package LeetCodeJ;/*
  Map the candidate with their votes(here a list of votes index i shows position).
  Sort them according to the given critera using comparator interface.
*/

class Solution {
    public String rankTeams(String[] votes) 
    {
        HashMap<Character, ArrayList<Integer>> map=new HashMap<Character, ArrayList<Integer>>();
        int n= votes[0].length();
        char[] ch= votes[0].toCharArray();
        
        Arrays.sort(ch);
        
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<n;j++)
                temp.add(0);
            
            map.put(ch[i], temp);
        }
        
        for(String s: votes)
        {
            char[] arr= s.toCharArray();
            for(int i=0;i<arr.length;i++)
            {
                ArrayList<Integer> temp= map.get(arr[i]);
                temp.set(i, temp.get(i)+1);
            }
        }
        
       // System.out.println(map);
        
        ArrayList<Character> sort=new ArrayList<>(map.keySet());
        Comparator<Character> comp=new Comparator<Character>()
        {
            @Override
            public int compare(Character a, Character b)
            {
                ArrayList<Integer> temp= map.get(a);
                ArrayList<Integer> temp2= map.get(b);
                
                for(int i=0;i<temp.size();i++)
                {
                    if(temp.get(i)>temp2.get(i))
                        return -1;
                    else if(temp.get(i)<temp2.get(i))
                        return 1;
                }
                
                return a-b;
            }
        };
        
        Collections.sort(sort, comp);
        return new String(sort.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}
