#27ms






class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        if len(points) <= 2:
            return len(points)
        
        def find_slope(p1, p2):
            x1, y1 = p1
            x2, y2 = p2
            if x1-x2 == 0:
                return inf
            return (y1-y2)/(x1-x2)
        
        ans = 1
        for i, p1 in enumerate(points):
            slopes = defaultdict(int)
            for j, p2 in enumerate(points[i+1:]):
                slope = find_slope(p1, p2)
                slopes[slope] += 1
                ans = max(slopes[slope], ans)
        return ans+1






#19ms







class Solution:
    def maxPoints(self, points: list[list[int]]) -> int:
                                                #   points = [[1,0],[2,1],[3,4], [5,4]]

        points.sort()                           #   point1 point2 (dx,dy)    m     slope                M
        slope, M = defaultdict(int), 0          #   –––––– –––––– ––––––– –––––––  –––––––––––        –––––
                                                #   [1,0]  [2,1]   (1,1)   (1,1)   {(1,1):1}            1
        for i, (x1, y1) in enumerate(points):   #          [3,4]   (2,4)   (1,2)   {(1,1):1,(1,2):1}    1
                                                #          [5,4]   (4,4)   (1,1)   {(1,1):2,(1,2):1}    2
            slope.clear()                       #   [2,1]  [3,4]   (1,3)   (1,3)   {(1,3):1}            2
                                                #          [5,4]   (3,3)   (1,1)   {(1,3):1,(1,1):1}    2
            for x2, y2 in points[i + 1:]:       #   [3,4]  [5,4]   (3,0)   (1,0)   {(1,0):1}            2
                dx, dy = x2 - x1, y2 - y1
                                                #  M + 1 = 2 + 1 = 3 <-- return
                G = gcd(dx, dy)                 
                m = (dx//G,dy//G)
                
                slope[m] += 1
                if slope[m] > M: M = slope[m]
    
        return M + 1
