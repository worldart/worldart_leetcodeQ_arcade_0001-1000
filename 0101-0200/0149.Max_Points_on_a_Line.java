//26ms




class Solution {
    public int maxPoints(int[][] points) {
        int max=0;
        // x -> x[0],x[1]  (x1,y1)
        for(int[] x:points)
        {
            Map<Double,Integer> map= new HashMap<>();
            // y -> y[0],y[1]  (x2,y2)
            for(int[] y:points){
                if(x==y)
                  continue;
                
                double slope=0;
                // if (x2 - x1 == 0) 
                if(y[0]-x[0]==0)
                   slope=Double.POSITIVE_INFINITY; 
                else
                   // slope = (y2 - y1) / (x2 - x1)
                   slope = (y[1]-x[1])/(double)(y[0]-x[0]);
                
                map.put(slope,map.getOrDefault(slope,0)+1);
                max=Math.max(max,map.get(slope));
            }
        }
        return max+1;
    }
}







//6ms








class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int res = 2;
        for (int i = 0; i < points.length; i++) {
            res = Math.max(res, getMax(points, i));
        }
        return res;
    }
    public int getMax(int[][] points, int i) {
        Map<Double, Integer> slope = new HashMap<>();
        int max = 1;
        for (int j = i+1; j < points.length; j++) {
            double s;
            if (points[i][0] == points[j][0]) {
                s = Double.POSITIVE_INFINITY;
            } else if (points[i][1] == points[j][1]) {
                s = 0.0;
            } else {
                s = (double) (points[i][0] - points[j][0]) / (points[i][1] - points[j][1]);
            }
            int count = slope.getOrDefault(s, 1) + 1;
            slope.put(s, count);
            max = Math.max(max, count);
        }
        return max;
    }
}


