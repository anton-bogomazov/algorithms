package algorithm.graph

import data.structure.graph.Edge
import data.structure.graph.WeightedEdge
import data.structure.graph.WeightedGraph
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AllPairsShortestPathKtTest : StringSpec({
    "floydWarshall should return the correct shortest distances for a small graph" {
        val graph = WeightedGraph<String>()
        val v1 = graph.createVertex("A")
        val v2 = graph.createVertex("B")
        val v3 = graph.createVertex("C")
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v2, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v2, v3, 2.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v3, v1, 3.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v3, 4.0))

        val distances = findAllPairsShortestPath(graph)

        distances[Pair(v1, v2)] shouldBe listOf(v1, v2)
        distances[Pair(v1, v3)] shouldBe listOf(v1, v2, v3)
        distances[Pair(v2, v1)] shouldBe listOf(v2, v3, v1)
        distances[Pair(v2, v3)] shouldBe listOf(v2, v3)
        distances[Pair(v3, v1)] shouldBe listOf(v3, v1)
        distances[Pair(v3, v2)] shouldBe listOf(v3, v1, v2)
    }

    "floydWarshall should throw the error in case of negative loop" {
        val graph = WeightedGraph<String>()
        val v4 = graph.createVertex("D")
        val v5 = graph.createVertex("E")
        val v6 = graph.createVertex("F")
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v4, v5, -3.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v5, v4, -2.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v6, v4, 5.0))

        shouldThrow<IllegalArgumentException> { findAllPairsShortestPath(graph) }
    }
})
