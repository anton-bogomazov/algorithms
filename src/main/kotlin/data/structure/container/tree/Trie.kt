package data.structure.container.tree

// A tree-like data structure used to store a dictionary of words, where each node represents a prefix of a word.
// Used for efficient search and insertion of words in a dictionary, and for searching for words with a given prefix.
// Time complexity: O(L) for insertion, search, and prefix search, where L is the length of the word.
// Space complexity: O(AL), where A is the size of the alphabet and L is the maximum length of the words stored in the Trie.
class Trie {
    val root: TrieNode = TrieNode()

    class TrieNode {
        val children: MutableMap<Char, TrieNode> = mutableMapOf()
        var isWord: Boolean = false

        fun hasOnlyChild() = children.size == 1
    }

    fun insert(word: String) {
        var current = root
        for (c in word) {
            current = current.children.getOrPut(c) { TrieNode() }
        }
        current.isWord = true
    }

    fun search(word: String): Boolean {
        var current = root
        for (c in word) {
            current = current.children[c] ?: return false
        }
        return current.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var current = root
        for (c in prefix) {
            current = current.children[c] ?: return false
        }
        return true
    }
}
