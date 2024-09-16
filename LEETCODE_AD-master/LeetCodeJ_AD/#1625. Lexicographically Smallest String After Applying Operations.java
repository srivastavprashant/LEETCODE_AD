package LeetCodeJ;// #1625. Lexicographically Smallest String After Applying Operations



class Solution 
{
    HashSet<String> set;
    String min;
    void call(char[] arr, int a, int b, int n)
    {
        if(set.contains(new String(arr))) return;
        else
        { 
            String s= new String(arr);
            set.add(s);
            
            if(s.compareTo(min)<0)
                min= new String(s);
        }

        char[] temp= new char[n];
        for(int i=0;i<n;i++)
            temp[(i+b)%n]= arr[i];
        
        call(temp, a, b, n);
        
        for(int i=1;i<n;i+=2)
            arr[i]= (char)(((arr[i]- 48)+ a)%10 +48);
        
        call(arr, a, b, n);
    }
    public String findLexSmallestString(String s, int a, int b) 
    {
        set= new HashSet<>();
        min= s;
        call(s.toCharArray(), a%10, b%s.length(), s.length());  
        
        return min;
    }
}
