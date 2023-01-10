package data.structure.container.set

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DisjointSetTest : StringSpec({

    "test find function" {
        val ds = DisjointSet(arrayOf(1, 2, 3))
        ds.find(1) shouldBe 1
        ds.find(2) shouldBe 2
        ds.find(3) shouldBe 3
    }

    "test union function" {
        val ds = DisjointSet(arrayOf(1, 2, 3, 4, 5))
        ds.union(1, 2)
        ds.find(1) shouldBe 2
        ds.find(2) shouldBe 2
        ds.union(2, 3)
        ds.find(1) shouldBe 3
        ds.find(2) shouldBe 3
        ds.find(3) shouldBe 3
        ds.union(4, 5)
        ds.find(4) shouldBe 5
        ds.find(5) shouldBe 5
    }

})
