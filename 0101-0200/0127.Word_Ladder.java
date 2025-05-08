//64ms


class Pair{
    String first;
    int second;
    Pair(String f,int s){
        first = f;
        second = s;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;

        Queue<Pair> q = new LinkedList();
        q.add(new Pair (beginWord,1));

        while(!q.isEmpty()){
            String word = q.peek().first;
            int length = q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return length;
            }
            char[] replacedArray = word.toCharArray();
            for(int i = 0;i<replacedArray.length;i++){
                char OriginalChar = replacedArray[i];
                for(char ch = 'a';ch<='z';ch++){
                    replacedArray[i] = ch;
                    String replacedString = new String(replacedArray);
                    if(wordSet.contains(replacedString)){
                        wordSet.remove(replacedString);
                        q.add(new Pair(replacedString,length+1));
                    }
                }
                replacedArray[i] = OriginalChar;

            }
        }
        return 0;
    }
}





//64ms


class Pair{
    String first;
    int second;
    Pair(String f,int s){
        first = f;
        second = s;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;

        Queue<Pair> q = new LinkedList();
        q.add(new Pair (beginWord,1));

        while(!q.isEmpty()){
            String word = q.peek().first;
            int length = q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return length;
            }
            char[] replacedArray = word.toCharArray();
            for(int i = 0;i<replacedArray.length;i++){
                char OriginalChar = replacedArray[i];
                for(char ch = 'a';ch<='z';ch++){
                    replacedArray[i] = ch;
                    String replacedString = new String(replacedArray);
                    if(wordSet.contains(replacedString)){
                        wordSet.remove(replacedString);
                        q.add(new Pair(replacedString,length+1));
                    }
                }
                replacedArray[i] = OriginalChar;

            }
        }
        return 0;
    }
}





//42ms




class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String word: wordList) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                String key = word.substring(0, i) + '*' + word.substring(i + 1);
                map.computeIfAbsent(key, x -> new ArrayList<>());
                map.get(key).add(word);
            }
        }

        Queue<String> bq = new LinkedList<>();
        Set<String> bVisited = new HashSet<>();
        bq.offer(beginWord);
        bVisited.add(beginWord);
        Queue<String> eq = new LinkedList<>();
        Set<String> eVisited = new HashSet<>();
        eq.offer(endWord);
        eVisited.add(endWord);

        int steps = 0;

        while (!bq.isEmpty() && !eq.isEmpty()) {
            steps++;
            if (bq.size() < eq.size()) {
                int size = bq.size();
                while (size-- > 0) {
                    String cur = bq.poll();
                    if (eVisited.contains(cur)) {
                        return steps;
                    }
                    for (int i = 0; i < cur.length(); i++) {
                        String key = cur.substring(0, i) + '*' + cur.substring(i + 1);
                        if (map.containsKey(key)) {
                            for (String next: map.get(key)) {
                                if (!bVisited.contains(next)) {
                                    bq.offer(next);
                                    bVisited.add(next);
                                }
                             }
                        }
                    }
                }
            } else {
                int size = eq.size();
                while (size-- > 0) {
                    String cur = eq.poll();
                    if (bVisited.contains(cur)) {
                        return steps;
                    }

                    for (int i = 0; i < cur.length(); i++) {
                        String key = cur.substring(0, i) + '*' + cur.substring(i + 1);
                        if (map.containsKey(key)) {
                            for (String next: map.get(key)) {
                                if (!eVisited.contains(next)) {
                                    eq.offer(next);
                                    eVisited.add(next);
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}



