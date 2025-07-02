//20ms





var maxPoints = function(points) {
  let max = 0;
    // x -> x[0],x[1]  (x1,y1)
    for (const x of points) {
      const slopes = new Map();
    // y -> y[0],y[1]  (x2,y2)
    for (const y of points) {
      if (x === y) continue;
      let slope = Infinity;
      // if (x2 - x1 != 0)
      if (y[0] - x[0] !== 0) {
        // slope = (y2 - y1) / (x2 - x1)
        slope = (y[1] - x[1]) / (y[0] - x[0]);
      }
      if (slopes.has(slope)) {
        slopes.set(slope, slopes.get(slope) + 1);
      } else {
        slopes.set(slope, 1);
      }
      max = Math.max(max, slopes.get(slope));
    }
  }
  return max + 1;
};






//10ms








/**
 * @param {number[][]} points
 * @return {number}
 */
var maxPoints = function(points) {
    // brute force solution
    let n = points.length;
    let maxResult = 1;

    for (let i = 0; i < n; i++) {
        let p1 = points[i];
        let slopeMap = new Map();
        for (let j = i + 1; j < n; j++) {
            let slope;
            let p2 = points[j];

            if(p1[0] === p2[0]) {
                slope = 'inf';
            } else {
                slope = (p2[1] - p1[1]) / (p2[0] - p1[0]);
            }
            let count = slopeMap.get(slope) || 0;
            slopeMap.set(slope, count + 1);
            maxResult = Math.max(maxResult, slopeMap.get(slope) + 1);
        }
    }

    return maxResult;
};
