class Trie {

    private boolean isRoot;
    private boolean isWord;
    private char value;
    private Trie[] children;

    /** Initialize your data structure here. */
    public Trie() {
        isRoot = true;
        isWord = false;
        value = ' ';
        children = new Trie[26];
    }

    public Trie(char c) {
        isRoot = false;
        isWord = false;
        value = c;
        children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie head = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int charIndex = Trie.indexOf(c);
            if (head.children[charIndex] == null) {
                head.children[charIndex] = new Trie(c);
            }
            head = head.children[charIndex];
        }
        head.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie head = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            head = head.children[Trie.indexOf(c)];
            if (head == null) {
                return false;
            }
        }
        return head.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie head = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            head = head.children[Trie.indexOf(c)];
            if (head == null) {
                return false;
            }
        }
        return true;
    }

    /** Maps a-z to 0-25 */
    private static int indexOf(char c) {
        return c - 97;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
