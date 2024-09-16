// #1974. Minimum Time to Type Word Using Special Typewriter
/**
 * @param {string} word
 * @return {number}
 */
var minTimeToType = function(arr) {
    var ans= 0;
    for(var i=0;i<arr.length;i++) {
        var dist= Math.abs(arr.charCodeAt(i)- (i==0? 97: arr.charCodeAt(i-1)));
        ans+= Math.min(dist, 26- dist);
    }
    
    return ans+ arr.length;
};
