package com.div.missionfaang.practice;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructure {

}

class TrieNode {
	Map<Character, TrieNode> children = new HashMap<>();

	public TrieNode getChild(Character c) {
		return children.get(c);
	}

	public void addChild(TrieNode child, Character key) {
		children.put(key, child);
	}
}
