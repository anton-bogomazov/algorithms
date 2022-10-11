package data.structure.graph

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MutableGraphTest : FunSpec({

    context("createVertex") {
        test("Weighted") {
            val graph = MutableGraph<String, WeightedEdge<String>>()

            for (i in 0 until 10) {
                val vertex = graph.createVertex(i.toString())
                vertex.data shouldBe i.toString()
                vertex.index shouldBe i
            }
        }

        test("Unweighted") {
            val graph = MutableGraph<Int, Edge<Int>>()

            for (i in 0 until 10) {
                val vertex = graph.createVertex(i)
                vertex.data shouldBe i
                vertex.index shouldBe i
            }
        }
    }

    context("addEdge") {
        test("One edge - Undirected") {
            val graph = MutableGraph<String, Edge<String>>()
            val singapore = graph.createVertex("Singapore")
            val tokyo = graph.createVertex("Tokyo")

            graph.addEdge(Edge.EdgeType.UNDIRECTED, Edge(singapore, tokyo))

            val singaporeEdges = graph.edges(singapore)
            singaporeEdges.size shouldBe 1
            with (singaporeEdges.first()) {
                from shouldBe singapore
                to shouldBe tokyo
            }
            val tokyoEdges = graph.edges(tokyo)
            tokyoEdges.size shouldBe 1
            with (tokyoEdges.first()) {
                from shouldBe tokyo
                to shouldBe singapore
            }
        }

        test("One edge - Directed") {
            val graph = MutableGraph<String, Edge<String>>()
            val singapore = graph.createVertex("Singapore")
            val tokyo = graph.createVertex("Tokyo")

            graph.addEdge(Edge.EdgeType.DIRECTED, Edge(singapore, tokyo))

            val singaporeEdges = graph.edges(singapore)
            singaporeEdges.size shouldBe 1
            with (singaporeEdges.first()) {
                from shouldBe singapore
                to shouldBe tokyo
            }
            val tokyoEdges = graph.edges(tokyo)
            tokyoEdges.size shouldBe 0
        }

        test("Few edges") {
            val graph = MutableGraph<String, Edge<String>>()
            val singapore = graph.createVertex("Singapore")
            val tokyo = graph.createVertex("Tokyo")
            val hongKong = graph.createVertex("Hong Kong")

            graph.addEdge(Edge.EdgeType.UNDIRECTED, Edge(singapore, tokyo))
            graph.addEdge(Edge.EdgeType.UNDIRECTED, Edge(singapore, hongKong))
            graph.addEdge(Edge.EdgeType.DIRECTED, Edge(hongKong, tokyo))

            with (graph.edges(singapore)) {
                size shouldBe 2
                with(get(0)) {
                    from shouldBe singapore
                    to shouldBe tokyo
                }
                with(get(1)) {
                    from shouldBe singapore
                    to shouldBe hongKong
                }
            }
            val tokyoEdges = graph.edges(tokyo)
            tokyoEdges.size shouldBe 1
            with (tokyoEdges.first()) {
                from shouldBe tokyo
                to shouldBe singapore
            }
            with (graph.edges(hongKong)) {
                size shouldBe 2
                with(get(0)) {
                    from shouldBe hongKong
                    to shouldBe singapore
                }
                with(get(1)) {
                    from shouldBe hongKong
                    to shouldBe tokyo
                }
            }
        }
    }

    context("edges") {
        test("edges - few edges") {
            val graph = MutableGraph<String, Edge<String>>()
            val singapore = graph.createVertex("Singapore")
            val tokyo = graph.createVertex("Tokyo")
            val hongKong = graph.createVertex("Hong Kong")

            graph.addEdge(Edge.EdgeType.UNDIRECTED, Edge(singapore, tokyo))
            graph.addEdge(Edge.EdgeType.UNDIRECTED, Edge(singapore, hongKong))
            graph.addEdge(Edge.EdgeType.DIRECTED, Edge(hongKong, tokyo))

            graph.edges(hongKong).size shouldBe 2
        }

        test("edges - empty") {
            val graph = MutableGraph<String, Edge<String>>()
            val singapore = graph.createVertex("Singapore")

            graph.edges(singapore).size shouldBe 0
        }
    }

    context("toString") {
        test("unweighted") {
            val graph = MutableGraph<String, Edge<String>>()
            val singapore = graph.createVertex("Singapore")
            val tokyo = graph.createVertex("Tokyo")
            val hongKong = graph.createVertex("Hong Kong")

            graph.addEdge(Edge.EdgeType.UNDIRECTED, Edge(singapore, tokyo))
            graph.addEdge(Edge.EdgeType.UNDIRECTED, Edge(singapore, hongKong))
            graph.addEdge(Edge.EdgeType.DIRECTED, Edge(hongKong, tokyo))

            val expectedString =
                        "Index    Source       Destinations        \n" +
                        "0        Singapore    Tokyo, Hong Kong    \n" +
                        "1        Tokyo        Singapore           \n" +
                        "2        Hong Kong    Singapore, Tokyo    \n"

            graph.toString() shouldBe expectedString
        }

        test("weighted") {
            val graph = MutableGraph<String, WeightedEdge<String>>()
            val singapore = graph.createVertex("Singapore")
            val tokyo = graph.createVertex("Tokyo")
            val hongKong = graph.createVertex("Hong Kong")

            graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(singapore, tokyo, 10.0))
            graph.addEdge(Edge.EdgeType.UNDIRECTED, WeightedEdge(singapore, hongKong, 15.0))
            graph.addEdge(Edge.EdgeType.DIRECTED, WeightedEdge(hongKong, tokyo, 5.0))

            val expectedString =
                        "Index    Source       Destinations                    \n" +
                        "0        Singapore    Tokyo<10.0>, Hong Kong<15.0>    \n" +
                        "1        Tokyo        Singapore<10.0>                 \n" +
                        "2        Hong Kong    Singapore<15.0>, Tokyo<5.0>     \n"

            graph.toString() shouldBe expectedString
        }
    }
})
