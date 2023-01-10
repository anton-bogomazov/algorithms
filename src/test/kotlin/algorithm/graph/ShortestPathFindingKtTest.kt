package algorithm.graph

import data.structure.container.graph.Edge
import data.structure.container.graph.WeightedEdge
import data.structure.container.graph.WeightedGraph
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShortestPathFindingKtTest : StringSpec({

    "should find the shortest path between two vertices" {
        val graph = WeightedGraph<Int>()
        val v1 = graph.createVertex(1)
        val v2 = graph.createVertex(2)
        val v3 = graph.createVertex(3)
        val v4 = graph.createVertex(4)
        val v5 = graph.createVertex(5)
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(v1, v2, 10.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(v1, v3, 20.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(v2, v4, 15.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(v3, v4, 30.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(v3, v5, 5.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(v4, v5, 10.0))

        val shortestPath = graph.findShortestPath(v1, v5)

        shortestPath shouldBe 25
    }

})
