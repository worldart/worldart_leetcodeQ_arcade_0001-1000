//37ms


class Solution {

    /**
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalRectangle($matrix) {
        // calculate heights for each row
        for($y=0;$y<count($matrix);$y++){
            for($x=0;$x<count($matrix[0]);$x++){
                $matrix[$y][$x] += $matrix[$y][$x] > 0 ? ($matrix[$y-1][$x] ?? 0) : 0;
            }
        }
        $res = 0;
        // find max rectangle for each row
        foreach($matrix as $y => $row){
            // append zero to complete algorithm
            $row[] = 0;
            $maxArea = 0;
            $stack = [];
            foreach($row as $x => $v){
                $start = $x;
                while(count($stack) > 0 && end($stack)[1] > $v){
                    [$index,$height] = array_pop($stack);
                    $maxArea = max($maxArea, $height * ($x - $index));
                    $start = $index;
                }
                $stack[] = [$start, $v];
            }
            $res = max($res, $maxArea);
        }
        return $res;
    }
}
