// 797ms






object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        
        val m = grid.length
        val n = grid(0).length

        def dfs(row: Int, col: Int): Unit = {
            if(row < 0 || row >= m || col < 0 || col >= n || grid(row)(col).equals('0')) ()
            else {
                grid(row)(col) = '0'
                for {
                    dirX <- (-1 to 1)
                    dirY <- (-1 to 1)
                    if dirX.abs != dirY.abs
                } dfs(row + dirX, col + dirY)
            }
        }

        val islands = for {
            row <- (0 until m)
            col <- (0 until n)
            if(grid(row)(col).equals('1'))
        } yield dfs(row, col)

        islands.length
    }
}





//703ms





object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        val visited = Array.fill(grid.length)(Array.fill(grid.head.length)(false))
        var count = 0
        (0 until grid.length).foreach { x =>
            (0 until grid.head.length).foreach { y =>
                if (!visited(x)(y) && grid(x)(y) == '1') {
                    count += 1
                    dfs(visited, grid, x, y)
                }
            }
        }
        count
    }

    def dfs(visited: Array[Array[Boolean]], grid: Array[Array[Char]], x: Int, y: Int): Unit = {
        if (isPosValid(x, y, grid) && !visited(x)(y) && grid(x)(y) == '1') {
            visited(x)(y) = true
            dfs(visited, grid, x - 1, y)
            dfs(visited, grid, x + 1, y)
            dfs(visited, grid, x, y - 1)
            dfs(visited, grid, x, y + 1)
        }
    }

    inline def isPosValid(x: Int, y: Int, grid: Array[Array[Char]]): Boolean = {
        x >= 0 && y >= 0 && x < grid.length && y < grid.head.length
    }
}





//700ms






object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        val rowN = grid.length
        val columnN = grid(0).length

        var result = 0
        var visited = Array.fill(rowN)(Array.fill(columnN)(false))

        def dfs(row: Int, col: Int): Unit = {
            if (row < 0 || row >= rowN) return ()
            if (col < 0 || col >= columnN) return ()
            if (grid(row)(col) != '1') return ()
            if (visited(row)(col)) return ()
            visited(row)(col) = true
            dfs(row+1, col)
            dfs(row-1, col)
            dfs(row, col+1)
            dfs(row, col-1)
        }



        var row = 0
        var col = 0

        while (row < rowN) {
            col = 0
            while (col < columnN) {
                if (!visited(row)(col) && grid(row)(col) == '1') {
                    result += 1
                    dfs(row, col)
                }
                col += 1
            }

            row += 1
        }

        return result

    }
}
