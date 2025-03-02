//105ms 100%RT 20250302

object Solution {
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        val m: Int = board.length
        val n: Int = board(0).length
        val visited: Array[Array[Boolean]] = Array.ofDim(m, n)
        var isResultFound: Boolean = false
        for (i <- 0 until m if !isResultFound) {
            for (j <- 0 until n if !isResultFound) {
                if (word(0) == board(i)(j)) {
                    isResultFound = dfs(word, 1, i, j, m, n, board, visited)
                }
            }
        }
        isResultFound
    }
    def dfs(word: String, l: Int, i: Int, j: Int, m: Int, n: Int, board: Array[Array[Char]], visited: Array[Array[Boolean]]): Boolean = {
        if (l < word.length) {
            visited(i)(j) = true
            val top: Boolean = if (i > 0) !visited(i - 1)(j) && word(l) == board(i - 1)(j) && dfs(word, l + 1, i - 1, j, m, n, board, visited) else false
            val bottom: Boolean = if (i < m - 1) !visited(i + 1)(j) && word(l) == board(i + 1)(j) && dfs(word, l + 1, i + 1, j, m, n, board, visited) else false
            val left: Boolean = if (j > 0) !visited(i)(j - 1) && word(l) == board(i)(j - 1) && dfs(word, l + 1, i, j - 1, m, n, board, visited) else false
            val right: Boolean = if (j < n - 1) !visited(i)(j + 1) && word(l) == board(i)(j + 1) && dfs(word, l + 1, i, j + 1, m, n, board, visited) else false
            visited(i)(j) = false
            top || bottom || left || right
        } else true
    }
}
