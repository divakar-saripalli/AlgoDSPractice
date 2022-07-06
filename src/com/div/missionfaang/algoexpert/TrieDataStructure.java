package com.div.missionfaang.algoexpert;

import java.util.HashMap;
import java.util.Map;

class Trie {
    TrieNode root = new TrieNode();

    public void insertWord(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.hasChild(c)) {
                node = node.getChild(c);
            } else {
                node.addChild(c);
                node = node.getChild(c);
            }
        }
    }

    public boolean checkWord(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!node.hasChild(c)) {
                return false;
            } else {
                node = node.getChild(c);
            }
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void addChild(Character letter) {
        children.put(letter, new TrieNode());
    }

    public TrieNode getChild(Character letter) {
        return children.get(letter);
    }

    public boolean hasChild(Character letter) {
        return children.containsKey(letter);
    }

    @Override
    public String toString() {
        return children.toString();
    }
}

public class TrieDataStructure {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("abcdefghijklmnopqrstuvwxyz");
//		trie.insertWord("Akshara");
//		trie.insertWord("Anusha");
//		trie.insertWord("Mahitha");

        System.out.println(trie.checkWord("abc"));
        System.out.println(trie.checkWord("mnopqr"));
        System.out.println(trie.checkWord("wyz"));
        System.out.println(trie.checkWord("no"));
        System.out.println(trie.checkWord("e"));
        System.out.println(trie.checkWord("tuuv"));
    }
}
