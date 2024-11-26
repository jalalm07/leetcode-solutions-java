class Solution {

    class Pair {
        String word;
        int step;
        Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        for(int i =0; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while(!queue.isEmpty()){
            String word = queue.peek().word;
            int step = queue.peek().step;
            queue.remove();

            if(word.equals(endWord)) return step;

            for(int i =0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedChars = word.toCharArray();
                    replacedChars[i] = ch;
                    String replacedString = new String(replacedChars);
                    if(set.contains(replacedString)){
                        set.remove(replacedString);
                        queue.add(new Pair(replacedString, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}