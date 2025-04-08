//0ms

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if(matrix==null||matrix.length==0||matrix[0].length==0){
        return false;
    }
    let m= matrix.length;
    let n= matrix[0].length;
    let low=0;
    let high=m*n-1;
    while(low<=high){
        let mid=low+Math.floor((high-low)/2);
        let midvalue=matrix[Math.floor(mid/n)][Math.floor(mid%n)];
        if(midvalue==target){
                return true;
        }else if(midvalue<target){
                low=mid+1;
        }else{
                high=mid-1;
        }
    }
    return false;
};
