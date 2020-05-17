class Trie {

    /** Initialize your data structure here. */
    class TrieNode {
        boolean endOfWord;
        Map <Character, TrieNode> children;
        public TrieNode() {
            this.endOfWord = false;
            this.children = new HashMap<>();
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            if(node.children.get(word.charAt(i)) == null) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
       node.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            if(node.children.get(word.charAt(i)) == null) {
                return false;
            }
            node = node.children.get(word.charAt(i)); 
        }
        if(node.endOfWord == true)
            return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++) {
            if(node.children.get(prefix.charAt(i)) == null)
                return false;
            node = node.children.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
