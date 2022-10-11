package algorithm

import data.structure.graph.Edge
import data.structure.graph.MutableGraph
import data.structure.graph.WeightedEdge
import exception.InvalidArgumentException
import exception.NoSolutionException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class GraphAlgorithmsKtTest : FunSpec({
    val graph = MutableGraph<String, WeightedEdge<String>>()

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


    test("breadthFirstSearch") {
        graph.breadthFirstSearch(singapore).map { it.index } shouldBe arrayListOf(0, 1, 2, 3, 5, 7, 4, 6)
        graph.breadthFirstSearch(singapore).map { it.data } shouldBe
                arrayListOf("Singapore", "Tokyo", "Hong Kong", "Detroit", "Washington DC", "Seattle", "San Francisco", "Austin Texas")
    }

    test("depthFirstSearch") {
        graph.depthFirstSearch(singapore).map { it.index } shouldBe arrayListOf(0, 1, 2, 4, 5, 6, 3, 7)
        graph.depthFirstSearch(singapore).map { it.data } shouldBe
                arrayListOf("Singapore", "Tokyo", "Hong Kong", "San Francisco", "Washington DC", "Austin Texas", "Detroit", "Seattle")
    }

    context("findShortestPath") {
        withData(
            nameFn = { "from: ${it.a.data}, to: ${it.b.data}, cost: ${it.c}" },
            row(singapore, austinTexas, 1000),
            row(singapore, hongKong, 300),
            row(washingtonDC, tokyo, 300)
        ) {(from, to, expectedWeight) ->
            graph.findShortestPath(from, to).weight() shouldBe expectedWeight
        }
    }

    context("findShortestPath - errors") {
        test("same") {
            shouldThrow<InvalidArgumentException> {
                graph.findShortestPath(singapore, singapore)
            }.message shouldBe "From and To vertices are equals: Singapore"
        }
        test("no path") {
            shouldThrow<NoSolutionException> {
                graph.findShortestPath(singapore, sakhalin)
            }.message shouldBe "There is no solution"
        }
    }
})
