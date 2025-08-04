//77ms






/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumGap = function (nums) {
  if (nums.length <= 1) return 0

  nums = radixSort(nums)

  let maxDiff = Math.abs(nums[0] - nums[1])

  for (let i = 1; i < nums.length - 1; i++) {

    let currDiff = Math.abs(nums[i] - nums[i + 1])
    maxDiff = Math.max(maxDiff, currDiff)
  }

  return maxDiff
};

const radixSort = (nums) => {
  const mostDigit = mostDigits(nums)

  for (let k = 0; k < mostDigit; k++) {
    let buckets = Array.from({ length: 10 }, () => [])

    for (let i = 0; i < nums.length; i++) {
      let digit = getDigit(nums[i], k)

      buckets[digit].push(nums[i])
    }
    nums = [].concat(...buckets)
  }

  return nums
}

const getDigit = (num, place) => {
  return Math.floor(Math.abs(num) / Math.pow(10, place)) % 10
}

const digitCount = (num) => {
  if (num === 0) return 1

  return Math.floor(Math.log10(Math.abs(num))) + 1
}

const mostDigits = (nums) => {
  let mostDigitCount = 0

  for (let num of nums) {
    mostDigitCount = Math.max(mostDigitCount, digitCount(num))
  }

  return mostDigitCount
}






//33ms






/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumGap = function(nums) {
    const n = nums.length
    if(n < 2){
        return 0
    }
    let maxGap = 0

    let min = Math.min(...nums)
    let max = Math.max(...nums)

    const bucketSize = Math.ceil((max-min)/(n-1))
    const minOfBucket = new Array(n-1).fill(Infinity)
    const maxOfBucket = new Array(n-1).fill(-1)

// set the min and max of bucket means put the value to the min and max bucket
    for(let i=0;i<n;i++){
        if(nums[i] === min || nums[i] === max){
            continue
        }
        const buckIndxForCurrEle = Math.floor((nums[i]-min)/bucketSize)
        minOfBucket[buckIndxForCurrEle] = Math.min(minOfBucket[buckIndxForCurrEle], nums[i])
        maxOfBucket[buckIndxForCurrEle] = Math.max(maxOfBucket[buckIndxForCurrEle], nums[i])
    }

// Now we get the diff with max of prev bucket and min of next bucket.
    for(let i=0;i<n-1;i++){
        if(maxOfBucket[i] === -1){
            continue
        }
        maxGap = Math.max(maxGap, minOfBucket[i] - min)
        min = maxOfBucket[i]
    }
    return Math.max(maxGap, max-min)
};
