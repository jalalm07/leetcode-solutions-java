class Solution {
    class Pair{
            String word;
            int step;
            Pair(String word, int step){
                this.word = word;
                this.step = step;
            }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String w: wordList){
            set.add(w);
        }
        set.remove(beginWord);

        queue.add(new Pair(beginWord, 1));

        while(!queue.isEmpty()){
            String word = queue.peek().word;
            int steps = queue.peek().step;
            if(word.equals(endWord)) return steps;
            queue.remove();

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] wordChar = word.toCharArray();
                    wordChar[i] = ch;
                    String newWord = new String(wordChar);
                    if(set.contains(newWord)){
                        queue.add(new Pair(newWord, steps + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}