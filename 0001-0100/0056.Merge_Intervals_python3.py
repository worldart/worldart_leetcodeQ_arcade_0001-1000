#100%RT

  class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x : x[0])
        curr= intervals[0]
        n=len(intervals)
        res = []
        for i in range(1,n):
            #end less than start
            if curr[1]<intervals[i][0]:
                res.append((curr))
                curr=intervals[i]
            else:
                curr=(curr[0],max(curr[1],intervals[i][1]))
        res.append(curr)
        return res
              

            

            
