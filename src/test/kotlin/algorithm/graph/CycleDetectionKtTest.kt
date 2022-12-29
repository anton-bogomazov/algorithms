package algorithm.graph

import data.structure.graph.Edge
import data.structure.graph.WeightedEdge
import data.structure.graph.WeightedGraph
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CycleDetectionKtTest : StringSpec({
    "detect cycle in a graph" {
        val graph = WeightedGraph<Int>()

        val vertex1 = graph.createVertex(1)
        val vertex2 = graph.createVertex(2)
        val vertex3 = graph.createVertex(3)
        val vertex4 = graph.createVertex(4)

        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(vertex1, vertex2, 10.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(vertex2, vertex3, 10.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(vertex3, vertex4, 10.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(vertex4, vertex1, 10.0))

        hasCycle(graph) shouldBe true
    }

    "detect no cycle in a graph" {
        val graph = WeightedGraph<Int>()

        val vertex1 = graph.createVertex(1)
        val vertex2 = graph.createVertex(2)
        val vertex3 = graph.createVertex(3)
        val vertex4 = graph.createVertex(4)

        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(vertex1, vertex2, 10.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(vertex2, vertex3, 10.0))
        graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(vertex3, vertex4, 10.0))

        hasCycle(graph) shouldBe false
    }
})
