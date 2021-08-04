// 1551. Minimum Operations to Make Array Equal

var minOperations = function(n) {
    let sum= 0;
    for(let i=0;i<n;i++) sum+= (2*i)+ 1;
    
    sum/= n;
    let ans= 0;
    for(let i= 0;i<n;i++) ans+= Math.abs(((2*i)+1)- sum);
    return ans>>1;
};
