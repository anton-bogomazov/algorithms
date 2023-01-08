package problem.string

import data.structure.tree.Trie

// Find the longest common prefix between a given set of strings.
// Complexity time/space: O(n)/O(n)
fun longestCommonPrefix(strings: Set<String>): String {
    if (strings.isEmpty()) return ""

    val trie = Trie()

    strings.forEach { string ->
        if (string.isEmpty()) return ""
        trie.insert(string)
    }

    var current = trie.root
    var prefixLength = 0
    while (current.hasOnlyChild()) {
        current = current.children.firstNotNullOf { it.value }
        prefixLength++
        if (current.isWord) break
    }

    return strings.first().substring(0, prefixLength)
}
