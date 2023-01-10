package data.structure.container.tree

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TrieTest : StringSpec({
    "test insert and search - search for inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.search("hello") shouldBe true
    }

    "test insert and search - search for word that is a prefix of an inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.search("hell") shouldBe false
    }

    "test insert and search - search for word that is a suffix of an inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.search("ello") shouldBe false
    }

    "test insert and search - search for word that is not a prefix or suffix of an inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.search("abc") shouldBe false
    }

    "test startsWith - prefix is the same as inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.startsWith("hello") shouldBe true
    }

    "test startsWith - prefix is a proper prefix of inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.startsWith("hell") shouldBe true
    }

    "test startsWith - prefix is a proper suffix of inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.startsWith("ello") shouldBe false
    }

    "test startsWith - prefix is not a prefix or suffix of inserted word" {
        val trie = Trie()
        trie.insert("hello")

        trie.startsWith("abc") shouldBe false
    }

})
