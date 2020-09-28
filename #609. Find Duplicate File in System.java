// 609. Find Duplicate File in System

class Solution {
    public List<List<String>> findDuplicate(String[] paths) 
    {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        for(String s: paths)
        {
            List<List<String>> ret= call(s);
            for(List<String> temp: ret)
            if(map.containsKey(temp.get(0)))
                map.getOrDefault(temp.get(0), new ArrayList<>()).add(temp.get(1));
            else
                map.put(temp.get(0), new ArrayList<>(Arrays.asList(temp.get(1))));
        }
        
        List<List<String>> ans= new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> i: map.entrySet())
            if(i.getValue().size()>1)
                ans.add(i.getValue());
        
        //System.out.println(map);
        return ans;
    }
    
    static List<List<String>> call(String s)
    {
        int i;
        StringBuilder location= new StringBuilder("");
        List<List<String>> ret= new ArrayList<>();
       
        for(i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(c==' ')
            {
                StringBuilder br= new StringBuilder(location.toString()+"/");
                for(i+=1;i<s.length();i++)
                {
                    c= s.charAt(i);
                    if(c=='(')
                    {
                        i++;
                        StringBuilder key= new StringBuilder("");
                        while(s.charAt(i)!=')')
                            key.append(s.charAt(i++));
                            
                        ret.add(new ArrayList<>(Arrays.asList(key.toString(), br.toString())));
                        //System.out.println(ret);
                        br= new StringBuilder(location.toString()+"/");
                        i++;
                    }
                    else
                        br.append(c);
                }
            }
            else
                location.append(c);
        }
        
        return ret;
    }
}
