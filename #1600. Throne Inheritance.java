// 1600. Throne Inheritance

class ThroneInheritance 
{
    HashSet<String> dead;
    List<List<String>> list= new ArrayList<>();
    HashMap<Integer, String> map;
    HashMap<String, Integer> mapIndex;
    
    public ThroneInheritance(String kingName) 
    {
        list.add(new ArrayList<>());
        map= new HashMap<>();
        mapIndex= new HashMap<>();
        dead= new HashSet<>();
        map.put(0, kingName);
        mapIndex.put(kingName, 0);
    }
    
    public void birth(String parentName, String childName) 
    {
        list.get(mapIndex.get(parentName)).add(childName);
        
        int index= list.size();
        map.put(index, childName);
        mapIndex.put(childName, index);
        list.add(new ArrayList<>());
    }
    
    public void death(String name) 
    {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() 
    {
        List<String> ans= new ArrayList<>();
        DFSREC(ans, 0);
        
        return ans;
    }
    
    public void DFSREC(List<String> ans, int curr)
    {
       // System.out.println(list);
        if(!dead.contains(map.get(curr)))
            ans.add(map.get(curr));
        
        for(String s: list.get(curr))
            DFSREC(ans, mapIndex.get(s));
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
