//506. Relative Ranks


/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    var sorted_score= [...score];
    sorted_score.sort((i, j)=> (j-i));
    
    var ans= score.map((ele)=> {
        if(sorted_score.indexOf(ele)== 0) return "Gold Medal";
        else if(sorted_score.indexOf(ele)== 1) return "Silver Medal";
        else if(sorted_score.indexOf(ele)== 2) return "Bronze Medal";
        else return sorted_score.indexOf(ele)+1+"";
    });
        
    return ans;
};
