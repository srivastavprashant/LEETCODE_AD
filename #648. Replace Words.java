// 648. Replace Words

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        HashSet<String> set= new HashSet<>(dictionary);
        sentence+=" ";
        
        StringBuilder ans= new StringBuilder("");
        StringBuilder br= new StringBuilder("");
        boolean skip= false;
        for(char c: sentence.toCharArray())
        {
            if(c==' ')
            {
                ans.append(br.toString()+" ");
                br= new StringBuilder("");
                skip= false;
            }
            else if(!skip)
            {
                br.append(c);
                if(set.contains(br.toString()))
                    skip= true;
            }
        }
        return ans.substring(0, ans.length()-1).toString();
    }
}
