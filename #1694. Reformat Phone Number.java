// #1694. Reformat Phone Number


class Solution 
{
    public String reformatNumber(String number) 
    {
        int count= 0;
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<number.length();i++)
        {
            char c= number.charAt(i);
            if(c>=48 && c<=57)
            {
                ans.append(c);
                count++;
                if(count%3== 0 && count!=0 && i!= number.length()-1)
                    ans.append("-");
            }
        }
        
        String fans= ans.toString();
        if(fans.charAt(fans.length()-1)=='-')
            fans= fans.substring(0, fans.length()-1);
        if(count%3==1)
            return ans.substring(0, fans.length()-3)+"-"+fans.charAt(fans.length()-3)+fans.charAt(fans.length()-1);
        
        return fans;
            
        
    }
}
