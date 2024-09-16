package LeetCodeJ;// #1418. Display Table of Food Orders in a Restaurant

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders)
    {
        HashMap<Integer, HashMap<String, Integer>> map=new HashMap<>();
        HashSet<String> dishes=new HashSet<>();
        
        for(List<String> i: orders)
        {
            int table= Integer.parseInt(i.get(1));
            String dish= i.get(2);
            dishes.add(dish);
            
            if(map.containsKey(table))
            {
                HashMap<String, Integer> temp=map.get(table);
                
                if(temp.containsKey(dish))
                    temp.put(dish, temp.get(dish)+1);
                else
                    temp.put(dish, 1);
            }
            else
            {
                HashMap<String, Integer> temp=new HashMap<>();
                temp.put(dish, 1);
                map.put(table, temp);
            }
        }
        
        List<List<String>> ans=new ArrayList<>();
        List<String> dish=new ArrayList<>(dishes);
        List<Integer> table=new ArrayList<>(map.keySet());
        Collections.sort(dish);
        Collections.sort(table);
        
        List<String> temp=new ArrayList<>();
        temp.add("Table");
        temp.addAll(dish);
        ans.add(temp);
        
        for(int i: table)
        {
            temp=new ArrayList<>();
            HashMap<String, Integer> table_map= map.get(i);
            temp.add(i+"");
            
            for(String s: dish)
                temp.add(table_map.containsKey(s)? (table_map.get(s)+""): ("0"));
            
            ans.add(temp);
        }
        return ans;
    }
}
