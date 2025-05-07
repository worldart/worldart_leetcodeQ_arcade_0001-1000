#47ms


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordList = set(wordList)  # converting the given list to set to perform optimized set reduction
        result = []
        layer = set()
        layer.add(beginWord)  # maintaining each layer to do bfs for the next layer
        # a dictionary to maintain the parent of each word, note in this bfs, one node can have multiple parent
        # e.g.: we can arrive at 'cog' from 'dog' and 'log'
        # this parent chaining will help us save some memory and create the required list later using build_path
        parent = defaultdict(set)
        while layer:
            new_layer = set()
            for word in layer:
                for i in range(len(beginWord)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        new = word[:i] + c + word[i + 1:]
                        if new in wordList and new != word:
                            parent[new].add(word)
                            new_layer.add(new)
            wordList -= new_layer
            layer = new_layer

        def build_path(last, lst):
            if last == beginWord:
                result.append(list(reversed(lst))) # since we build the path bottom up, so reversing
                return
            for word in parent[last]:
                build_path(word, lst + [word])

        build_path(endWord, [endWord])
        return result




#11ms


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordList = set(wordList)
        if endWord not in wordList:
            return []

        pattern_to_words = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                pattern = word[:i] + "*" + word[i+1:]
                pattern_to_words[pattern].append(word)

        parents = defaultdict(set)
        visited = set([beginWord])
        q = deque([beginWord])
        found = False
        while q:
            level_visited = set()
            for _ in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    found = True
                if found:
                    continue
                for i in range(len(word)):
                    pattern = word[:i] + "*" + word[i+1:]
                    for neighbor in pattern_to_words[pattern]:
                        if neighbor not in visited:
                            if neighbor not in level_visited:
                                q.append(neighbor)
                                level_visited.add(neighbor)
                            parents[neighbor].add(word)
            if found:
                break
            visited.update(level_visited)

        if not found:
            return []

        res = []
        path = [endWord]

        def dfs(word):
            if word == beginWord:
                res.append(path[::-1])
                return
            for parent in parents[word]:
                path.append(parent)
                dfs(parent)
                path.pop()

        dfs(endWord)
        return res

