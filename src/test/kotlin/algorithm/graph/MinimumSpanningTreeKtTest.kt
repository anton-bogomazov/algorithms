package algorithm.graph

import data.structure.container.graph.Edge
import data.structure.container.graph.WeightedEdge
import data.structure.container.graph.WeightedGraph
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class MinimumSpanningTreeKtTest : StringSpec({
    "minimum spanning tree for a complete graph" {
        val graph = WeightedGraph<String>()
        val a = graph.createVertex("A")
        val b = graph.createVertex("B")
        val c = graph.createVertex("C")

        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(a, b, 10.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(a, c, 20.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(b, c, 30.0))

        val mst = minimumSpanningTree(graph)
        mst.size shouldBe 2
        mst shouldContain WeightedEdge(a, b, 10.0)
        mst shouldContain WeightedEdge(a, c, 20.0)
    }

    "minimum spanning tree for a disconnected graph" {
        val graph = WeightedGraph<String>()
        val a = graph.createVertex("A")
        val b = graph.createVertex("B")
        val c = graph.createVertex("C")
        val d = graph.createVertex("D")
        val e = graph.createVertex("E")

        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(a, b, 10.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(a, c, 20.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(b, c, 30.0))
        graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(d, e, 40.0))

        val mst = minimumSpanningTree(graph)
        mst.size shouldBe 3
        mst shouldContain WeightedEdge(a, b, 10.0)
        mst shouldContain WeightedEdge(a, c, 20.0)
        mst shouldContain WeightedEdge(d, e, 40.0)
    }
})
