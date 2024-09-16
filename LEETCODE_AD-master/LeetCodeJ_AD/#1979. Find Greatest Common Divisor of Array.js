//1979. Find Greatest Common Divisor of Array

/**
 * @param {number[]} nums
 * @return {number}
 */
var findGCD = function(nums) {
    // reduce with arrow function and implicit return
    var max= nums.reduce((max, val)=> (Math.max(max, val)));
    var min= nums.reduce((min, val)=> (Math.min(min, val)));
    function gcd(max, min) {return min== 0? max: gcd(min, max%min)};
    return gcd(max, min);
};
