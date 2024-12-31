#73.07% run time

class Solution(object):
    '''
    Variables:
      - window:    words queue appeared in order.
      - localCout:     appeared times of each word in current window.

    Processing:
      - if current word is not in `words`, then we should re-start calculating from
        next word.
      - if current word is in `words` and it's appeared times beyond that in `words`,
        then we should set the left boundary of `window` to position next to that in
        which current word appeared the first time.
      - if the length of window equals to that of `words`, then we get one pefect
        position.
    '''
    def findSubstring(self, s, words):
        n, m, r = len(words), len(words[0]) if words else 0, []
        counter = collections.Counter(words)

        for i in xrange(m):
            localCout = collections.defaultdict(int)
            window = collections.deque()

            for j in xrange(i, len(s), m):
                word = s[j:j + m]
                if word in counter:
                    localCout[word] += 1
                    window.append(word)

                    while localCout[word] > counter[word]:
                        localCout[window.popleft()] -= 1

                    if len(window) == n:
                        r.append(j - (n - 1) * m)
                else:
                    localCout.clear()
                    window.clear()
        return r
