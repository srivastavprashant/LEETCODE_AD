// 1639. Number of Ways to Form a Target String Given a Dictionary

// Normal recursion (TLE)

class Solution 
{
    static long ans;
    static int lenn;
    static void call(ArrayList<ArrayList<ArrayList<Integer>>> arr, String target, int index, int val)
    {
        if(index< target.length() && val<lenn)
        {
            ArrayList<ArrayList<Integer>> list= arr.get(target.charAt(index)-'a');
            
            for(int i=0;i<list.size();i++)
            {
                int ind= binarySearch(list.get(i), 0, list.get(i).size()-1, val);
                
                for(;ind<list.get(i).size();ind++)
                {
                    //System.out.println("word= "+i+" index= "+i);
                    call(arr, target, index+1, list.get(i).get(ind)+1);
                }
            }
        }
        else if(index== target.length())
            ans= (ans+1)%1000000007;
            
    }
    
    static int binarySearch(ArrayList<Integer> arr, int start, int last, int find)
    {
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(arr.get(mid)== find)
                return mid;
            else if(arr.get(mid)> find)
                last= mid-1;
            else
                start= mid+1;
        }
        
        return start;
    }
    
    public int numWays(String[] words, String target) 
    {
        ArrayList<ArrayList<ArrayList<Integer>>> arr= new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            ArrayList<ArrayList<Integer>> temp= new ArrayList<>();
            for(int j=0;j<words.length;j++)
                temp.add(new ArrayList<>());
         
            arr.add(temp);
        }
        
        for(int ii=0;ii< words.length;ii++)
        {
            String s= words[ii];
            for(int i=0;i<s.length();i++)
                arr.get(s.charAt(i)-'a').get(ii).add(i);
            
        }
        
        ans=0;
        lenn= words[0].length();
        //System.out.println(arr);
        call(arr, target, 0, 0);
        
        return (int )ans;
    }
}

//TODO: Memoization 
