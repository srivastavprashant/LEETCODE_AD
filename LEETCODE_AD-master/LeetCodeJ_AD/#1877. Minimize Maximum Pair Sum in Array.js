#1877. Minimize Maximum Pair Sum in Array

var minPairSum = function(nums) {
    nums.sort((i, j)=> (i-j));
    let i= 0, j= nums.length-1;
    
    // console.log(nums);
    
    let ans= -1;
    while(i<j) {
        ans= Math.max(nums[i]+ nums[j], ans);
        i++;
        j--;
    }
    return ans;
};
