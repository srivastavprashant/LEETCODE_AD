#229. Majority Element II

// Follow up in O(1) space complexity.
var majorityElement = function(nums) {
    nums.push(1e9+1);
    let ans= [];
    nums.sort((i, j)=> (i-j));
    
    let count= 1;
    for(let i=1;i<nums.length;i++) {
        if(nums[i]== nums[i-1]) count++;
        else {
            if(Math.floor((nums.length-1)/3)< count) ans.push(nums[i-1]);
            count= 1;
        }   
    }
    
    return ans;
};
