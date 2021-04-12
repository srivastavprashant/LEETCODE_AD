// #670. Maximum Swap



class Solution {
    public int maximumSwap(int num) {
        char[] arr= (num+"").toCharArray();
        char[] max= new char[arr.length];
        
        char val= '0';
        for(int i= arr.length-1;i>=0;i--) {
            if(val< arr[i]) val= arr[i];
            max[i]= val;
        }
        
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!= max[i]) {
                char temp= arr[i];
                arr[i]= max[i];
                
                for(int j= arr.length-1;j>=0;j--) {
                    if(arr[j]== max[i]) {
                        arr[j]= temp;
                        return Integer.parseInt(new String(arr));
                    }
                }
            }
        }
        
        return Integer.parseInt(new String(arr));
    }
}

// so idealy we will want the digits to be sorted in decreasing order.
// so just swap the very first digit which has a value greater than it on his right side.
