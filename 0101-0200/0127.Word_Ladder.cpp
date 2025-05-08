//13ms


class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if(dict.find(endWord) == dict.end()) return 0;
        unordered_set<string> beginSet{beginWord}, endSet{endWord};
        int level = 1;
        while(!beginSet.empty() && !endSet.empty()){
            if(beginSet.size() > endSet.size()) swap(beginSet, endSet);
            unordered_set<string> nextSet;
            for(auto word : beginSet){
                for(int i = 0; i < word.size(); i++){
                    char original = word[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        word[i] = c;
                        if(endSet.find(word) != endSet.end()) return level + 1;
                        if(dict.find(word) != dict.end()){
                            nextSet.insert(word);
                            dict.erase(word);
                        }
                    }
                    word[i] = original;
                }
            }
            beginSet = nextSet;
            level++;
        }
        return 0;
    }
};




//18ms


class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string, pair<int, int>> distance;
        for (string& w : wordList) {
            distance[w] = {0, 0};
        }
        if (!distance.contains(endWord)) {
            return 0;
        }

        queue<string> q1, q2;
        q1.push(beginWord);
        distance[beginWord].first = 1;
        q2.push(endWord);
        distance[endWord].second = 1;

        while (!q1.empty() && !q2.empty()) {
            int s1 = q1.size();
            int s2 = q2.size();

            if (s1 <= s2) {
                for (int i = 0; i < s1; i++) {
                    string w1 = q1.front();
                    q1.pop();
                    if (distance[w1].first != 0 && distance[w1].second != 0) {
                        return distance[w1].first + distance[w1].second - 1;
                    }
                    helper(q1, distance, w1, true);
                }
            } else {
                for (int i = 0; i < s2; i++) {
                    string w2 = q2.front();
                    q2.pop();
                    if (distance[w2].first != 0 && distance[w2].second != 0) {
                        return distance[w2].first + distance[w2].second - 1;
                    }
                    helper(q2, distance, w2, false);

                }
            }         
        }

        return 0;
    }

private:
    void helper(queue<string>& q, unordered_map<string, pair<int, int>>& distance, string& word, bool fromBegin) {
        for (int i = 0; i < word.size(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word[i]) {
                    continue;
                }
                string newWord = word;
                newWord[i] = c;
                if (distance.contains(newWord)) {
                    if (fromBegin && distance[newWord].first == 0) {
                        distance[newWord].first = distance[word].first + 1;
                        q.push(newWord);
                    } else if (!fromBegin && distance[newWord].second == 0) {
                        distance[newWord].second = distance[word].second + 1;
                        q.push(newWord);
                    }
                }
            }
        }
    }
};
