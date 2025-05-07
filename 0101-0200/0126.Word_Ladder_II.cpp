//43ms


class Solution {
public:
    bool neighbour(string a, string b){
        int cnt = 0 ;
        for(int i = 0 ; i < a.length() ; i++)
        {
            if(a[i] != b[i])
            {
                cnt++ ;
            }
        }
        return cnt == 1 ;
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        wordList.insert(wordList.begin(), beginWord);
        for(int i = 1 ; i < wordList.size() ; i++)
        {
            if(wordList[i] == wordList[0]) // string compare
            {
                wordList[i] = wordList.back() ;
                wordList.pop_back() ;
                break ;
            }
        }
        map<string, int> wti ; // word to index
        for(int i = 0 ; i < wordList.size() ; i++)
        {
            wti.insert({wordList[i], i}) ;
        }
        if(!wti.count(endWord)) 
        {
            return {} ;
        }
        vector<vector<int>> edges(wti.size()) ;
        for(int i = 0 ; i < wordList.size() ; i++)
        {
            for(int j = 0 ; j < wordList.size() ; j++)
            {
                if(i != j)
                {
                    if(neighbour(wordList[i], wordList[j]))
                    {
                        edges[i].push_back(j) ;
                    }
                }
            }
        }
        // BFS  
        int start_node = 0 , target_node = wti[endWord] , r = 0 , min_step = INT_MAX ;
        vector<int> vis(wordList.size(), INT_MAX) ;   
        vis[start_node] = 0 ;
        queue<int> q ;   
        q.push(start_node) ;
        while(!q.empty())
        {
            int sz  = q.size() ;
            for (int i = 0 ; i < sz ; i++)
            {
                int fr = q.front() ;  
                q.pop() ;
                if(fr == target_node)
                {
                    min_step = min(min_step , r) ;
                }
                for(int j = 0 ; j < edges[fr].size() ; j++)
                {
                    int update_node = edges[fr][j] ;
                    if(r + 1 < vis[update_node])
                    {
                        vis[update_node] = r + 1 ;
                        q.push(update_node);
                    }
                }
            }
            r++ ;
        }
        if(min_step == INT_MAX)
        {
            return {} ;
        }
        queue<vector<string>> q2 ; 
        q2.push({wordList[target_node]}) ;
        r = min_step ;
        while(r)
        {
             int sz  = q2.size() ;
             for(int i = 0 ; i < sz ; i++)
             {
                vector<string> seq = q2.front() ;
                q2.pop();
                string back = seq.back() ;
                int curr = wti[back] ;
                for (int j = 0 ; j < edges[curr].size() ; j++)
                {
                    int new_node = edges[curr][j] ;
                    if (vis[new_node] == r - 1)
                    {
                        seq.push_back(wordList[new_node]) ;
                        q2.push(seq) ;
                        seq.pop_back() ;
                    }
                }
            }
            r-- ;
        }
        vector<vector<string>> ans;
        while(!q2.empty())
        {
            vector<string> temp = q2.front() ;
            q2.pop() ;
            reverse(begin(temp) , end(temp)) ;
            ans.push_back(temp) ;
        }
        return ans ;
    }
};




//7ms

#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList) {
        vector<vector<string>> res;
        if (find(wordList.begin(), wordList.end(), endWord) == wordList.end()) {
            return res;
        }
        int n = static_cast<int>(wordList.size());
        int m = static_cast<int>(beginWord.size());
        auto differ_by_one_character = [&](auto &s, auto &t) {
            bool flag = false;
            for (int i = 0; i < m; i++) {
                if (s[i] != t[i]) {
                    if (flag) {
                        return false;
                    }
                    flag = true;
                }
            }
            return true;
        };
        vector<vector<int>> g(n + 1);
        int end_word_index = -1;
        for (int i = 0; i < n; i++) {
            if (wordList[i] == endWord) {
                end_word_index = i;
            }
            for (int j = i + 1; j < n; j++) {
                if (differ_by_one_character(wordList[i], wordList[j])) {
                    g[i].emplace_back(j);
                    g[j].emplace_back(i);
                }
            }
        }
        if (end_word_index == -1) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            if (differ_by_one_character(beginWord, wordList[i])) {
                g[n].emplace_back(i);
            }
        }
        const int INF = 1e9;
        int f[n + 1], gg[n + 1];
        memset(f, 0x3f, sizeof f);
        memset(gg, 0x3f, sizeof gg);
        int q[n + 1];
        bool st[n + 1];
        auto bfs = [&](int f[], int start) {
            memset(st, 0, sizeof st);
            st[start] = true;
            f[start] = 0;
            int hh = 0, tt = -1;
            q[++tt] = start;
            while (hh <= tt) {
                auto t = q[hh++];
                for (int ne: g[t]) {
                    if (!st[ne]) {
                        f[ne] = f[t] + 1;
                        q[++tt] = ne;
                        st[ne] = true;
                    }
                }
            }
        };
        bfs(f, n);
        bfs(gg, end_word_index);
        if (f[end_word_index] == INF) {
            return res;
        }
        vector<string> path = {beginWord};
        auto dfs = [&](auto &&dfs, int u) -> void {
            if (u == end_word_index) {
                res.emplace_back(path);
            } else {
                for (int ne: g[u]) {
                    if (f[ne] == f[u] + 1 && f[ne] + gg[ne] == f[end_word_index]) {
                        path.emplace_back(wordList[ne]);
                        dfs(dfs, ne);
                        path.pop_back();
                    }
                }
            }
        };
        dfs(dfs, n);
        return res;
    }
};





//10ms



class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (!dict.count(endWord)) return {};

        unordered_map<string, vector<string>> parents;
        unordered_set<string> current_level{beginWord};
        bool found = false;

        while (!current_level.empty() && !found) {
            for (const string& word : current_level)
                dict.erase(word);  // mark visited

            unordered_set<string> next_level;
            for (const string& word : current_level) {
                string temp = word;
                for (int i = 0; i < temp.size(); ++i) {
                    char orig = temp[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == orig) continue;
                        temp[i] = c;
                        if (!dict.count(temp)) continue;
                        next_level.insert(temp);
                        parents[temp].push_back(word);
                        if (temp == endWord) found = true;
                    }
                    temp[i] = orig;
                }
            }
            current_level = move(next_level);
        }

        if (!found) return {};

        // Backtrack to build paths
        vector<vector<string>> res;
        vector<string> path{endWord};
        dfs(endWord, beginWord, parents, path, res);
        return res;
    }

    void dfs(const string& word, const string& beginWord,
             unordered_map<string, vector<string>>& parents,
             vector<string>& path, vector<vector<string>>& res) {
        if (word == beginWord) {
            reverse(path.begin(), path.end());
            res.push_back(path);
            reverse(path.begin(), path.end());
            return;
        }
        for (const string& parent : parents[word]) {
            path.push_back(parent);
            dfs(parent, beginWord, parents, path, res);
            path.pop_back();
        }
    }
};



//25ms


class Solution
{
public:
    vector<vector<string>> res;
    vector<string> te;
    unordered_map<string, int> mp;
    string b;
    void dfs(string s)  // Step 2
    {
        te.push_back(s);
        if (s == b)
        {
            vector<string> x = te;
            reverse(x.begin(), x.end());
            res.push_back(x);
            te.pop_back();
            return;
        }
        int cur = mp[s];
        for (int i = 0; i < s.size(); i++)
        {
            char c = s[i];
            for (char cc = 'a'; cc <= 'z'; cc++)
            {
                s[i] = cc;
                if (mp.count(s) && mp[s] == cur - 1)
                    dfs(s);
            }
            s[i] = c;
        }
        te.pop_back();
        return;
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        b = beginWord;
        queue<string> q;
        int k = beginWord.size();
        q.push({beginWord});
        mp[beginWord] = 0;
        while (!q.empty())  // Step 1
        {
            int n = q.size();
            while (n--)
            {
                string t = q.front();
                q.pop();
                int x = mp[t] + 1;
                for (int i = 0; i < k; i++)
                {
                    string temp = t;
                    for (char ch = 'a'; ch <= 'z'; ch++)
                    {
                        temp[i] = ch;
                        if (!mp.count(temp) && dict.count(temp))
                            mp[temp] = x, q.push(temp);
                    }
                }
            }
        }
        if (mp.count(endWord))
            dfs(endWord);
        return res;
    }
};




