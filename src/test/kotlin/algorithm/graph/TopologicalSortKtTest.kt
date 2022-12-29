package algorithm.graph

import data.structure.graph.Edge
import data.structure.graph.WeightedEdge
import data.structure.graph.WeightedGraph
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TopologicalSortKtTest : StringSpec({

    "topological sort on a directed acyclic graph" {
        val graph = WeightedGraph<Int>()
        val v0 = graph.createVertex(0)
        val v1 = graph.createVertex(1)
        val v2 = graph.createVertex(2)
        val v3 = graph.createVertex(3)
        val v4 = graph.createVertex(4)
        val v5 = graph.createVertex(5)
        val v6 = graph.createVertex(6)
        val v7 = graph.createVertex(7)

        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v5, v1, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v7, v1, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v7, v0, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v3, v0, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v3, v4, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v0, v6, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v6, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v4, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v2, 1.0))

        val sortedVertices = topologicalSort(graph)

        sortedVertices.map { it.data } shouldBe listOf(3, 5, 7, 1, 0, 4, 2, 6)
    }

    "topological sort on a cycled graph" {
        val graph = WeightedGraph<Int>()
        val v0 = graph.createVertex(0)
        val v1 = graph.createVertex(1)
        val v2 = graph.createVertex(2)
        val v3 = graph.createVertex(3)
        val v4 = graph.createVertex(4)
        val v5 = graph.createVertex(5)
        val v6 = graph.createVertex(6)
        val v7 = graph.createVertex(7)

        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v5, v1, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v7, v1, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v7, v0, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v3, v0, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v3, v4, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v0, v6, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v6, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v4, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v1, v2, 1.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(v6, v3, 1.0))

        shouldThrow<IllegalArgumentException> { topologicalSort(graph) }

    }

})
