//100%RT


func jump(nums []int) int {
    n := len(nums)
    jumps := 0
    currentEnd := 0
    farthest := 0

    for i := 0; i < n-1; i++ {
        farthest = max(farthest, i+nums[i])
        if i == currentEnd {
            jumps++
            currentEnd = farthest
        }
    }
    return jumps
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}


/*
40%46RT
func jump(nums []int) int {
	// set variables
	jumps := 0
	maxDistance := 0
	currentPos := 0

	// loop through all items, except the last.
	for i := 0; i < len(nums)-1; i++ {
		// look for what is greater, current reach or new reachable.
		maxDistance = int(math.Max(float64(maxDistance), float64(nums[i]+i)))

		// if this iteration is the current step
		if currentPos == i {

			// increment jumps, set current position to maxDistance.
			jumps++
			currentPos = maxDistance
		}
	}

	// return total jumps
	return jumps
}
*/
