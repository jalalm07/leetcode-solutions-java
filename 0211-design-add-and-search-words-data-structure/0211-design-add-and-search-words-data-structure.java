class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode root){
        TrieNode curr = root;
        for(int j = i; j < word.length(); j++){
            char ch = word.charAt(j);
            if(ch == '.'){
                for(TrieNode child: curr.children){
                    if(child !=null && dfs(word, j + 1, child)) return true;
                }
                return false;
            } else {
                if(curr.children[ch - 'a'] == null) return false;
                curr = curr.children[ch - 'a'];
            }
        }
        return curr.isWord;
    }
}

public class TrieNode{
    boolean isWord;
    TrieNode[] children;

    public TrieNode(){
        isWord = false;
        children = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */