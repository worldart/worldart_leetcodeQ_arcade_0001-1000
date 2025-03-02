#3ms 99.03%RT

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
    
        # \U0001f50d Early exit if board doesn't have enough letters
        board_count = Counter(char for row in board for char in row)
        word_count = Counter(word)
        for char in word_count:
            if board_count[char] < word_count[char]:
                return False  # Impossible to form word
        
        # \U0001f504 Swap word order for efficiency (start with least common letter)
        if board_count[word[0]] > board_count[word[-1]]:
            word = word[::-1]

        def dfs(r: int, c: int, index: int) -> bool:
            if index == len(word):
                return True  # Found complete word
            
            if (
                r < 0 or r >= ROWS or c < 0 or c >= COLS  # Out of bounds
                or board[r][c] != word[index]  # Letter doesn't match
            ):
                return False
            
            # \U0001f50d Mark cell as visited (without extra space)
            temp, board[r][c] = board[r][c], "#"
            
            # Move in 4 directions (only if next character exists)
            found = (
                dfs(r + 1, c, index + 1) or
                dfs(r - 1, c, index + 1) or
                dfs(r, c + 1, index + 1) or
                dfs(r, c - 1, index + 1)
            )
            
            # \U0001f504 Backtrack
            board[r][c] = temp
            return found

        # \U0001f680 Start DFS from matching first letter
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == word[0] and dfs(r, c, 0):
                    return True  # Found word
        
        return False
