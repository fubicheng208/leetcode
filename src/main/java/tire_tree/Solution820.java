package tire_tree;

import java.util.Arrays;

public class Solution820 {

    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Trie trie = new Trie();
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String s : words) {
            res += trie.insert(s);
        }
        return res;
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        //向字典树中插入，若是新单词则加上单词长度+1，否则+0
        public int insert(String s) {
            TrieNode node = root;
            boolean isNew = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                //说明是新单词
                if (node.get(c) == null) {
                    node.set(c, new TrieNode());
                    isNew = true;
                }
                node = node.get(c);
            }
            return isNew ? s.length() + 1 : 0;
        }
    }

    class TrieNode {
        private TrieNode[] links;

        TrieNode() {
            links = new TrieNode[26];
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void set(char c, TrieNode node) {
            links[c - 'a'] = node;
        }
    }
}
