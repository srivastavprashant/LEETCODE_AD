// #1818. Minimum Absolute Sum Difference

class Solution {
    Integer[] arr;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        arr= new Integer[nums1.length];
        for(int i=0;i<nums1.length;i++)
            arr[i]= nums1[i];
        
        Arrays.sort(arr);
        
        int ans= 0, save= 0;
        for(int i=0;i<nums1.length;i++) {
            ans+= Math.abs(nums2[i]- nums1[i]);
            ans= ans>= 1000000007? ans- 1000000007: ans;
            int small= binarySearchSmaller(nums2[i]);
            int great= binarySearchGreater(nums2[i]);
            int temp= Math.min(nums2[i]- small, great- nums2[i]);
            if(temp< Math.abs(nums2[i]- nums1[i]))
                save= Math.max(save, Math.abs(nums1[i]- nums2[i])- temp);  
        }
        
        System.out.println(ans+" "+save);
        return ans- save;
    }
    
    int binarySearchSmaller(int find) {
        int start= 0, last= arr.length-1, ret= 0;
        while(start<= last) {
            int mid= start+ (last- start)/2;
            if(arr[mid]== find) return arr[mid];
            else if(arr[mid]< find) {ret= arr[mid]; start= mid+1; }
            else last= mid-1;
        }
        return ret;
    }
    
    int binarySearchGreater(int find) {
        int start= 0, last= arr.length-1, ret= 1000000;
        while(start<= last) {
            int mid= start+ (last- start)/2;
            if(arr[mid]== find) return arr[mid];
            else if(arr[mid]> find) {ret= arr[mid]; last= mid-1; }
            else start= mid+1;
        }
        return ret;
    }
}
