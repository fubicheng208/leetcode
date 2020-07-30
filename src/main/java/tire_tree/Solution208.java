package tire_tree;

class Trie {
    //从根节点开始构造一个n叉树
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    //Time:O(m), 空间：O(m)， m为字符串长度
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            //该节点下是否已经存在对应的字符节点，如果不存在则要创建
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    //查找前缀，返回最后的节点
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);//移动到下一层，判断下一个单词
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;
        private final int R = 26;

        TrieNode() {
            links = new TrieNode[R];
        }

        //下一层是否有该字母对应的节点
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        //返回下一层的指定节点
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        //指定下一层某个节点为指定节点
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        //指定某个节点是否为结束节点
        public void setEnd() {
            isEnd = true;
        }

        //判断当前节点是否是结束节点
        public boolean isEnd() {
            return isEnd;
        }
    }
}