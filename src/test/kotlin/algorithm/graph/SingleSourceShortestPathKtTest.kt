package algorithm.graph

import data.structure.container.graph.Edge
import data.structure.container.graph.WeightedEdge
import data.structure.container.graph.WeightedGraph
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SingleSourceShortestPathKtTest : StringSpec({
    "bellmanFord should return the correct shortest path for a simple graph" {
        val graph = WeightedGraph<String>()
        val a = graph.createVertex("A")
        val b = graph.createVertex("B")
        val c = graph.createVertex("C")
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(a, b, -2.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(b, c, 3.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(a, c, 2.0))

        val result = findSSShortestPath(graph, a)

        result.keys.size shouldBe 3
        result[a] shouldBe 0
        result[b] shouldBe -2
        result[c] shouldBe 1
    }

    "bellmanFord should return the correct shortest path for a graph with negative weight edges" {
        val graph = WeightedGraph<String>()
        val a = graph.createVertex("A")
        val b = graph.createVertex("B")
        val c = graph.createVertex("C")
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(a, b, -1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(b, c, -3.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(a, c, 0.0))

        val result = findSSShortestPath(graph, a)

        result.keys.size shouldBe 3
        result[a] shouldBe 0
        result[b] shouldBe -1
        result[c] shouldBe -4
    }

    "bellmanFord should return the correct shortest path for a graph with negative weight cycles" {
        val graph = WeightedGraph<String>()
        val a = graph.createVertex("A")
        val b = graph.createVertex("B")
        val c = graph.createVertex("C")
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(a, b, -1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(b, c, -3.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(c, a, -2.0))

        shouldThrow<IllegalArgumentException> { findSSShortestPath(graph, a) }
    }
})
