package LeetCodeJ;//1641. Count Sorted Vowel Strings


class Solution 
{
    static char[] vowel={'a', 'e', 'i', 'o', 'u'};
    static int ans;
    static void call(int n, int index, int len)
    {
        if(index<5 && len<n)
        {
            for(int i= index;i<vowel.length;i++)
            {
                call(n, i, len+1);
            }
        }
        else if(len== n)
            ans++;
    }
    
    public int countVowelStrings(int n) 
    {
        ans=0;
        call(n, 0, 0);
        
        return ans;
    }
}
