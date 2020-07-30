package tire_tree;

import java.util.Stack;

public class Solution720 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int i = 0;
        for (String s : words) {
            //第一个取1是为了区别int的默认值为0的情况
            trie.insert(s, ++i);
        }
        //取一个分支即为解
        trie.words = words;
        return trie.dfs();

    }

    class Trie {
        TrieNode root;
        String[] words;

        Trie() {
            root = new TrieNode();
        }

        //具有前缀才能插入
        public void insert(String s, int index) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                //不存在这个节点，则要插入这个节点
                if (node.get(c) == null) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            //记录到当前节点为字符串中第几个元素
            node.setEnd(index);
        }

        public String dfs() {
            String ans = "";
            TrieNode node = root;
            Stack<TrieNode> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                //对于banana这样的情况，由于b的end为0,所以不会dfs；只有每个节点的存在的才会逐渐计算长度；
                //即只有当前前缀是words里的字符串时才会dfs下去,从而像banana这种不符合题意的字符串不会得到比较的机会
                if (node == root || node.end > 0) {
                    if (node != root) {
                        //对比更新ans
                        String word = words[node.end - 1];
                        //长度更大，或者长度相等，字典序更小则跟新
                        ans = (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) ? word : ans;
                    }
                    for (int i = 0; i < 26; i++) {
                        char c = (char) (i + 'a');
                        if (node.get(c) != null) {
                            stack.push(node.get(c));
                        }
                    }
                }
            }
            return ans;
        }
    }

    class TrieNode {
        private TrieNode[] links;
        private int end;

        TrieNode() {
            links = new TrieNode[26];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void setEnd(int index) {
            end = index;
        }
    }

}
