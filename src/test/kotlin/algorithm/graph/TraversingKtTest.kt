package algorithm.graph

import data.structure.graph.Edge
import data.structure.graph.WeightedEdge
import data.structure.graph.WeightedGraph
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TraversingKtTest : StringSpec({

    val graph = WeightedGraph<String>()

    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Austin Texas")
    val seattle = graph.createVertex("Seattle")
    val sakhalin = graph.createVertex("Sakhalin")

    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(singapore, tokyo, 500.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(singapore, hongKong, 300.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(hongKong, tokyo, 250.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(hongKong, sanFrancisco, 600.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(tokyo, detroit, 450.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(tokyo, washingtonDC, 300.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(detroit, austinTexas, 50.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(austinTexas, washingtonDC, 300.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(sanFrancisco, washingtonDC, 340.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(washingtonDC, seattle, 280.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(sanFrancisco, seattle, 220.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(austinTexas, sanFrancisco, 290.0))
    graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(seattle, tokyo, 1500.0))


    "breadthFirstSearch" {
        graph.breadthFirstSearch(singapore).map { it.index } shouldBe arrayListOf(0, 1, 2, 3, 5, 7, 4, 6)
        graph.breadthFirstSearch(singapore).map { it.data } shouldBe
                arrayListOf(
                    "Singapore",
                    "Tokyo",
                    "Hong Kong",
                    "Detroit",
                    "Washington DC",
                    "Seattle",
                    "San Francisco",
                    "Austin Texas"
                )
    }

    "depthFirstSearch" {
        graph.depthFirstSearch(singapore).map { it.index } shouldBe arrayListOf(0, 1, 2, 4, 5, 6, 3, 7)
        graph.depthFirstSearch(singapore).map { it.data } shouldBe
                arrayListOf(
                    "Singapore",
                    "Tokyo",
                    "Hong Kong",
                    "San Francisco",
                    "Washington DC",
                    "Austin Texas",
                    "Detroit",
                    "Seattle"
                )
    }
})
