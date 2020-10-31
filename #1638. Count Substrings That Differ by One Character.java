//1638. Count Substrings That Differ by One Character

class Solution {
    public int countSubstrings(String s, String t) 
    {
        HashMap<Integer, ArrayList<String>> sub1= new HashMap<>();
        HashMap<Integer, ArrayList<String>> sub2= new HashMap<>();
        
        call(s, sub1);
        call(t, sub2);
        
        int ans=0;
        for(Integer len: sub1.keySet())
        {
            ArrayList<String > temp1= sub1.getOrDefault(len, new ArrayList<>());
            ArrayList<String > temp2= sub2.getOrDefault(len, new ArrayList<>());   
            for(String s1: temp1)
            {
                for(String s2: temp2)
                    if(check(s1, s2))
                    {
                        //System.out.println(s1+" "+s2);
                        ans++;
                    }
            }
        }
        
        return ans;        
    }
    
    static void call(String s, HashMap<Integer, ArrayList<String>> sub1)
    {
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                String val= s.substring(i, j+1);
                if(sub1.containsKey(val.length()))
                    sub1.get(val.length()).add(val);
                else
                {
                    ArrayList<String> temp= new ArrayList<>();
                    temp.add(val);
                    
                    sub1.put(val.length(), temp);
                }
            }
        }
    }
    
    static boolean check(String a, String b)
    {
        int mismatch=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!= b.charAt(i))
                mismatch++;
            
            if(mismatch>1)
                return false;
        }
        
        return mismatch!=0;
    }
}
