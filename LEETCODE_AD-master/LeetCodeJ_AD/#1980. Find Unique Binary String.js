// 1980. Find Unique Binary String

/**
 * @param {string[]} nums
 * @return {string}
 */
var findDifferentBinaryString = function(nums) {
    var n= nums.length;
    var start= 0, last= (1<<n)-1;
    while(start<= last) {
        var key= "", temp= start, count= n;
        while(count!= 0) {
            key+= temp&1;
            temp>>= 1;
            count--;
        }
        if(nums.indexOf(key)!= -1) start++;
        else return key;
    }
    
    return "";
};
