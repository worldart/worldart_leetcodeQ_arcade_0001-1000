#243ms




'''
general idea:
cnt num islands = 0
double for loop on each ele in the 2d grid
if ele == water, skip
if ele == land, we begin land covering procedure:
    cnt += 1
    stack = [that ele with land]
    while stack:
        pop the ele.
        mark the ele from land to water (to mark it as traversed)
        for dir in the 4 dirs:
            update new coords to find new element,
            checking bounds to make sure the element exists
            if it's land, add it to stack
    return cnt
time: m*n, space:m*n
'''

class Solution:
    DIRS = ((1,0), (-1,0), (0, 1), (0, -1))

    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0

        m = len(grid)       # x coord bound
        n = len(grid[0])        # y coord bound
        out = 0

        for x in range(m):
            for y in range(n):
                if grid[x][y] == "0":
                    continue
                # coord must be land here
                out += 1
                grid[x][y] = "0"
                
                
                # expand from the land_coord and cover the entire island that contains that coord, marking seen coords as water 
                s = [(x,y)]     # stack invariant: contain confirmed land coordinates of the current island that are already marked as water
                while s:
                    land_x, land_y = s.pop()
                    for perturb in self.DIRS:
                        nx, ny = land_x + perturb[0], land_y + perturb[1]

                        # if perterbed_dir in bounds AND grid[perterbed_dir] is land
                        if (0 <= nx < m) and (0 <= ny < n) and (grid[nx][ny] == "1"):
                            grid[nx][ny] = "0"
                            s.append((nx, ny))
                
        return out





#247ms




class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        def dfs(i,j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != '1':
                return
            grid[i][j] = 0 # marked as visited
            dfs(i+1,j)
            dfs(i-1,j)
            dfs(i,j+1)
            dfs(i,j-1)

        island_count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    island_count += 1
                    dfs(i,j)
        return island_count






#68ms





def numIslands(grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    res += 1
                    stack = [(i, j)]
                    grid[i][j] = '0'  
                    while stack:
                        x, y = stack.pop()
                        nx = x + 1
                        if nx < m and grid[nx][y] == '1':
                            grid[nx][y] = '0'
                            stack.append((nx, y))
                        nx = x - 1
                        if nx >= 0 and grid[nx][y] == '1':
                            grid[nx][y] = '0'
                            stack.append((nx, y))
                        ny = y + 1
                        if ny < n and grid[x][ny] == '1':
                            grid[x][ny] = '0'
                            stack.append((x, ny))
                        ny = y - 1
                        if ny >= 0 and grid[x][ny] == '1':
                            grid[x][ny] = '0'
                            stack.append((x, ny))
        return res

with open('user.out','w') as file:
    for g in stdin:
        g = loads(g)
        c = numIslands(g)
        file.write(str(c)+'\n')

exit()
