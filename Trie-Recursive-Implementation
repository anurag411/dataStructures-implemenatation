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
        insertRecursive(root, word, 0);
    }
    
    private void insertRecursive(TrieNode root, String word, int index) {
        if(index == word.length()) {
            root.endOfWord = true;
            return ;
        }
        if(root.children.get(word.charAt(index)) == null) {
            root.children.put(word.charAt(index), new TrieNode()); 
        } 
        insertRecursive(root.children.get(word.charAt(index)), word, ++index);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }
    
    private boolean searchRecursive(TrieNode root, String word, int index) {
        if(index == word.length()) {
            if(root.endOfWord)
                return true;
            return false;
        }
        char ch = word.charAt(index);
        if(root.children.get(ch) == null)
            return false;
        return searchRecursive(root.children.get(ch), word, index+1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWithRecursive(root, prefix, 0);
    }
    private boolean startsWithRecursive(TrieNode root, String prefix, int index) {
        if(index == prefix.length()) {
            return true;
        }
        char ch = prefix.charAt(index);
        if(root.children.get(ch) == null)
            return false;
        
        return startsWithRecursive(root.children.get(ch), prefix, index+1);
    }
}
