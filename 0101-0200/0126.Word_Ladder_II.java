//12ms


class Solution {
    private int L;
    private boolean hasPath;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        this.L = beginWord.length();
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if(!wordSet.contains(endWord)) return new ArrayList<>();

        // BFS
        // build a directed graph G with beginWord being the root
        // we guarantee in G, for all nodes, the dis from beginWord is the shortest
        Map<String, List<String>> adjList = new HashMap<String, List<String>>();
        wordSet.remove(beginWord); // beginWord in wordList is useless
        buildAdjList(beginWord, endWord, wordSet, adjList);
        if(this.hasPath==false) return new ArrayList<>();

        // DFS
        // get all paths from beginWord to endWord, knowing that all paths have the same shortest length
        // implement a cache to save branches that have already been visited
        return backtrack(adjList, beginWord, endWord, new HashMap<>());
    }

    public List<List<String>> backtrack(
        Map<String, List<String>> adjList, 
        String currWord, 
        String endWord,
        Map<String, List<List<String>>> cache
    ){
        if(cache.containsKey(currWord)) return cache.get(currWord);
        List<List<String>> result = new ArrayList<>();
        if(currWord.equals(endWord)){
            result.add(new ArrayList<>(Arrays.asList(currWord)));
        }else{
            List<String> neighbors = adjList.getOrDefault(currWord, new ArrayList<>());
            for(String neighbor: neighbors){
                List<List<String>> paths = backtrack(adjList, neighbor, endWord, cache);
                for(List<String> path: paths){
                    List<String> copy = new ArrayList<>(path);
                    copy.add(0, currWord);
                    result.add(copy);
                }
            }
        }
        cache.put(currWord, result);
        return result;
    }

    public void buildAdjList(String beginWord, String endWord, Set<String> unvisitedWords,  Map<String, List<String>> adjList){
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){
            if(this.hasPath) break;
            int size = q.size();
            Set<String> nextLevelWords = new HashSet<>();
            for(int i=0; i<size; i++){
                String currWord = q.poll();
                List<String> nextLevelNeighbors= getNextLevelNeighbors(currWord, unvisitedWords, adjList);
                // System.out.println(currWord+" neighbors: " + nextLevelNeighbors);
                for(String nextLevelNeighbor: nextLevelNeighbors){
                    if(!nextLevelWords.contains(nextLevelNeighbor)){
                        if(nextLevelNeighbor.equals(endWord)) this.hasPath = true;
                        nextLevelWords.add(nextLevelNeighbor);
                        q.add(nextLevelNeighbor);
                    }
                }
            }
            // only after adding all edges to next level
            // can we remove next level nodes
            for(String w: nextLevelWords){
                unvisitedWords.remove(w);
            }
        }
    }

    public List<String> getNextLevelNeighbors(String word, Set<String> unvisitedWords, Map<String, List<String>> adjList){
        // for every char -- K *
        // replace it with 26 letters -- 26 *
        // check if it exists in wordSet -- O(1)
        List<String> neighbors = new ArrayList<>();
        char[] wordSeq = word.toCharArray();
        for(int i=0; i<this.L; i++){
            char oldC = wordSeq[i];
            for(int j=0; j<26; j++){
                char newC = (char)('a'+j);
                if(newC==oldC) continue;
                wordSeq[i]=newC;
                String newWord = new String(wordSeq);
                if(unvisitedWords.contains(newWord)){
                    neighbors.add(newWord);
                }
                wordSeq[i] = oldC;
            }
        }
        adjList.put(word, neighbors);
        return neighbors;
    }
}






//3ms




class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      Callable<List<List<String>>>c=()->{  if(!wordList.contains(endWord)) return new ArrayList<>();
        return optimalFunc(beginWord, endWord, wordList);

};
try{
    FutureTask<List<List<String>>>ft=new FutureTask<>(c);
    new Thread(ft).start();return ft.get();
}catch(Exception e){
    return new ArrayList<>();
}
    }

    public static List<List<String>> optimalFunc(String beginWord,String endWord,List<String>wordList){
        HashMap<String,Integer>hs=(word_minStepsToMakeIt(beginWord, endWord, wordList));
        // System.out.println(hs);
        List<String>curr=new ArrayList<>();curr.add(endWord);
        List<List<String>>ans=new ArrayList<>();
        dfs(hs, endWord, beginWord, curr,ans);
        return(ans);
    }

    public static HashMap<String,Integer>word_minStepsToMakeIt(String beginWord,String endWord,List<String>wordList){
        HashSet<String>set=new HashSet<>(wordList);
        Queue<Pair>q=new LinkedList<>();
        HashMap<String,Integer>hs=new HashMap<>();
        hs.put(beginWord, 1);
        q.offer(new Pair(beginWord, 1));
        while (!q.isEmpty()) {

            Pair front=q.poll();

            if(front.s.equals(endWord)) break;

            String curr=front.s;
            int val=front.val;
            List<String>transformations=getTransformationsOf(curr, set);
            for(String e:transformations){
                q.offer(new Pair(e, val+1));
                hs.putIfAbsent(e, val+1);
                set.remove(e);
            }
        }
        return hs;
    }

    public static void dfs(HashMap<String,Integer>word_minStepsToReachIt,String currWord,String beginWord,List<String>currList,List<List<String>>ans){
        if(currWord.equals(beginWord)) {
            ans.add(new ArrayList<>(currList.reversed()));
            return;
        }
        for(int i=0;i<currWord.length();i++){
            for(char c='a';c<='z';c++){
                char arr[]=currWord.toCharArray();
                arr[i]=c;
                String newString=new String(arr);
                if (word_minStepsToReachIt.containsKey(newString) && word_minStepsToReachIt.get(newString)<word_minStepsToReachIt.get(currWord)) {
                    // System.out.println(currWord+" matches "+newString);
                    currList.add(newString);
                    dfs(word_minStepsToReachIt, newString, beginWord, currList,ans);
                    currList.remove(currList.size()-1);
                }
            }
        }
    }

    private static List<String> getTransformationsOf(String currrWord, HashSet<String> wordList) {
        List<String>li=new ArrayList<>();
        for(int i=0;i<currrWord.length();i++){
            for(char c='a';c<='z';c++){
                char arr[]=currrWord.toCharArray();
                arr[i]=c;
                String s=new String(arr);
                if(wordList.contains(s)) li.add(s);
            }
        }
        return li;
    }
}

class Pair {
    String s;
    int val;

    public Pair(String s, int val) {
        this.s = s;
        this.val = val;
    }
}






//11ms




class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null) {
            return result;
        }
        if (beginWord.equals(endWord)) {
            result.add(Arrays.asList(endWord));
            return result;
        }

        // Prepare edges
         // O(wordList.size() * endWord.length())
        Map<String, Set<String>> edges = new HashMap<>();
        boolean foundEnd = false;
        // O(wordList.size() * endWord.length())
        for (String w: wordList) {
            if (w.length() == endWord.length()) {
                if (!foundEnd && endWord.equals(w)) {
                    foundEnd = true;
                }

                char[] chars = w.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig = chars[i];
                    chars[i] = '*';
                    String s = new String(chars);
                    Set<String> neighbors = edges.getOrDefault(s, new HashSet<>());
                    neighbors.add(w);
                    edges.put(s, neighbors);
                    chars[i] = orig;
                }
            }
        }

        if (!foundEnd) {
            return result;
        }

        // Do BFS from both sides, while keeping the mapping of parents
        // There can be multiple parents to get to a word
         // O(wordList.size())
        Map<String, ParentDistance> bParents = new HashMap<>();
        Map<String, ParentDistance> eParents = new HashMap<>();

         // O(wordList.size())
        Deque<Pair<String, Integer>> bq = new LinkedList<>();
        Deque<Pair<String, Integer>> eq = new LinkedList<>();

        bParents.put(beginWord, new ParentDistance());
        eParents.put(endWord, new ParentDistance());

        bq.offerLast(new Pair(beginWord, 0));
        eq.offerLast(new Pair(endWord, 0));

        int maxDistB = Integer.MAX_VALUE;
        int maxDistE = Integer.MAX_VALUE;
        int maxDist = Integer.MAX_VALUE;

         // O(wordList.size())
        Set<String> links = new HashSet<>();

        // O(wordList.size() * endWord.length())
        while (!bq.isEmpty() || !eq.isEmpty()) {
            //System.out.println("56: bq: " + bq.peekFirst() + ", eq: " + eq.peekFirst());
            // O(endWord.length())
            Pair<String, Integer> bp = findLink(bq, bParents, eParents, edges, maxDistB, maxDist);
            Pair<String, Integer> ep = findLink(eq, eParents, bParents, edges, maxDistE, maxDist);
            //System.out.println("58: bp: " + bp + ", ep: " + ep);
            if (bp.getKey() != null) {
                String link = bp.getKey();
                maxDistB = bParents.get(link).distance;
                maxDistE = eParents.get(link).distance;

                if (maxDistB + maxDistE < maxDist) {
                    maxDist = maxDistB + maxDistE;
                    links.clear();
                }
                links.add(link);
                //System.out.println("65: link: " + bp.getKey() + " links: " + links + ", maxDistB: " + maxDistB + ", maxDistE: " + maxDistE + ", maxDist: " + maxDist);
            }
            if (ep.getKey() != null) {
                String link = ep.getKey();
                maxDistB = bParents.get(link).distance;
                maxDistE = eParents.get(link).distance;
                if (maxDistB + maxDistE < maxDist) {
                    maxDist = maxDistB + maxDistE;
                    links.clear();
                }
                links.add(link);
                //System.out.println("72: link: " + ep.getKey() + " links: " + links + ", maxDistB: " + maxDistB + ", maxDistE: " + maxDistE + ", maxDist: " + maxDist);
            }
        }

        // O(answer)
        Set<String> visited = new HashSet<>();

        for (String link: links) {
            List<List<String>> paths = getPaths(link, bParents, eParents);
            for (List<String> p: paths) {
                String ps = String.join(",", p);
                if (!visited.contains(ps)) {
                    result.add(p);
                    visited.add(ps);
                }
            }
        }
        // O(answer)
        return result;
    }

    private List<List<String>> getPaths(String mid, Map<String, ParentDistance> bParents, Map<String, ParentDistance> eParents) {
        List<List<String>> paths = new ArrayList<>();
        
        List<LinkedList<String>> bPaths = getPaths(mid, bParents, true);
        List<LinkedList<String>> ePaths = getPaths(mid, eParents, false);

        for (LinkedList el: ePaths) {
            if (!el.isEmpty()) {
                el.pollFirst();
            }
        }

        // cross join the two lists
        for (LinkedList bl: bPaths) {
            for (LinkedList el: ePaths) {
                List<String> l = new ArrayList<>();
                l.addAll(bl);
                l.addAll(el);
                paths.add(l);
            }
        }

        return paths;
    }

    private List<LinkedList<String>> getPaths(String mid, Map<String, ParentDistance> parentsMap, boolean to) {
        //System.out.println("94: mid: " + mid + ", to: " + to);
        List<LinkedList<String>> paths = new ArrayList<>();
        ParentDistance pd = parentsMap.get(mid);
        if (pd == null || pd.parents.isEmpty()) {
            LinkedList<String> singleList = new LinkedList<>();
            singleList.add(mid);
            paths.add(singleList);
            return paths;
        }

        for (String p: pd.parents) {
            List<LinkedList<String>> pPaths = getPaths(p, parentsMap, to);
            for (LinkedList pPath: pPaths) {
                if (to) {
                    pPath.addLast(mid);
                } else {
                    pPath.addFirst(mid);
                }
                paths.add(pPath);
            }

        }
        return paths;
    }

    private Pair<String, Integer> findLink(Deque<Pair<String, Integer>> q, Map<String, ParentDistance> fromParents, Map<String, ParentDistance> toParents, Map<String, Set<String>> edges, int fromDist, int maxTotalDist) {
        if (q.isEmpty()) {
            return new Pair(null, -1);
        }
        Pair<String, Integer> p = q.pollFirst();
        String s = p.getKey();
        int distance = p.getValue();

        if (distance > fromDist) {
            return new Pair(null, distance);
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char orig = chars[i];
            chars[i] = '*';
            Set<String> neighbors = edges.getOrDefault(new String(chars), new HashSet<>());
            for (String n: neighbors) {
                if (fromParents.containsKey(n) && fromParents.get(n).distance <= distance) {
                    // n is a parent of s -> skip
                    continue;
                }
                if (!fromParents.containsKey(n)) {
                    q.offerLast(new Pair(n, distance + 1));
                }
                ParentDistance pd = fromParents.getOrDefault(n, new ParentDistance(distance + 1));
                pd.parents.add(s);
                fromParents.put(n, pd);
            }
            chars[i] = orig;
        }

        if (toParents.containsKey(s)) {
            //found
            ParentDistance pd = toParents.get(s);
            if (pd.distance + distance <= maxTotalDist) {
                return p;
            }
        }
        return new Pair(null, distance);
    }

    static class ParentDistance {
        Set<String> parents;
        int distance;

        public ParentDistance() {
            parents = new HashSet<>();
            this.distance = 0;
        }

        public ParentDistance(int distance) {
            parents = new HashSet<>();
            this.distance = distance;
        }

        public ParentDistance(String parent, int distance) {
            parents = new HashSet<>();
            parents.add(parent);
            this.distance = distance;
        }
    }
}






//0ms




import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return new AbstractList<List<String>>() {
            private List<List<String>> resList;
            private void onload() {
                resList = new ArrayList<>();
                Set<String> wordSet = new HashSet<>(wordList);
                if (!wordSet.contains(endWord)) {
                    return;
                }
                Map<String, Set<String>> map = new HashMap<>();
                boolean flag = false;
                Set<String> currLevel = new HashSet<>();
                currLevel.add(beginWord);
                while (!currLevel.isEmpty() && !flag) {
                    wordSet.removeAll(currLevel); // Remove the used words
                    Set<String> nextLevel = new HashSet<>();
                    for (String currWord : currLevel) {
                        for (String nextWord : generate(currWord, wordSet)) {
                            if (nextWord.equals(endWord)) {
                                flag = true;
                            }
                            map.putIfAbsent(nextWord, new HashSet<>());
                            map.get(nextWord).add(currWord);
                            nextLevel.add(nextWord);
                        }
                    }
                    currLevel = nextLevel;
                }
                if (flag) { // There is path from beginWord to endWord
                    helper(endWord, map, new ArrayList<>());
                }
                return;
            }

            private List<String> generate(String currWord, Set<String> wordSet) {
                List<String> arr = new ArrayList<>();
                char[] chArr = currWord.toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    char old = chArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        chArr[i] = ch;
                        String nextWord = new String(chArr);
                        if (wordSet.contains(nextWord)) {
                            arr.add(nextWord);
                            ;
                        }
                    }
                    chArr[i] = old;
                }
                return arr;
            }

            private void helper(String currWord, Map<String, Set<String>> map, List<String> path) {
                path.add(currWord);
                if (currWord.equals(beginWord)) {
                    resList.add(new ArrayList<>(path).reversed());
                    path.remove(path.size() - 1);
                    return;
                }
                for (String prevWord : map.get(currWord)) {
                    helper(prevWord, map, path);
                }

                path.remove(path.size() - 1);
            }

            private void init() {
                if (null == resList) {
                    onload();
                    System.gc();
                }
            }

            @Override
            public List<String> get(int index) {
                init();
                return resList.get(index);
            }

            @Override
            public int size() {
                init();
                return resList.size();
            }

        };
    }
}






