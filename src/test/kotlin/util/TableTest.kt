package util

import exception.InvalidArgumentException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.Matcher
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldHaveLength
import io.kotest.matchers.string.shouldStartWith

class TableTest : FunSpec({

    val data = listOf(
        listOf("Distributed Systems", "Maarten van Steen", "4.6"),
        listOf("Domain Driven Design", "Eric Evans", "4.2"),
        listOf("Clean Code", "Robert Martin", "4.7"),
        listOf("Test-Driven Development", "Kent Beck", "4.3"),
        listOf("Rationality", "Eliezer Yudkowsky", "4.7"),
        listOf("Agile Software Development, Principles, Patterns, and Practices", "Robert Martin", "4.8")
    )
    val rowNames = data.indices.map { it.toString() }
    val columnNames = listOf("Title", "Author", "Rating")

    val invalidColumnNames = columnNames + "Amount"
    val invalidRowNames = rowNames + "100500"

    context("Creating Table instance") {

        context("happy path") {
            test("Only data") {
                Table(data = data)
            }

            test("With row names") {
                Table(data = data, rowNames = rowNames)
            }

            test("With row and column names") {
                Table(data = data, columnNames = columnNames, rowNames = rowNames)
            }
        }

        context("Init validation errors") {

            test("With invalid row names - when more") {
                shouldThrow<InvalidArgumentException> {
                    Table(data = data, rowNames = invalidRowNames)
                }.message shouldBe "Expected number of row names=6, column names=3, but passed 7 and 0"
            }

            test("With invalid column names - when more") {
                shouldThrow<InvalidArgumentException> {
                    Table(data = data, columnNames = invalidColumnNames)
                }.message shouldBe "Expected number of row names=6, column names=3, but passed 0 and 4"
            }

            test("With invalid row and column names - when more") {
                shouldThrow<InvalidArgumentException> {
                    Table(data = data, columnNames = invalidColumnNames, rowNames = invalidRowNames)
                }.message shouldBe "Expected number of row names=6, column names=3, but passed 7 and 4"
            }

            test("With invalid row names - when less") {
                shouldThrow<InvalidArgumentException> {
                    Table(data = data, rowNames = invalidRowNames.subList(0, 1))
                }.message shouldBe "Expected number of row names=6, column names=3, but passed 1 and 0"
            }

            test("With invalid column names - when less") {
                shouldThrow<InvalidArgumentException> {
                    Table(data = data, columnNames = invalidColumnNames.subList(0, 2))
                }.message shouldBe "Expected number of row names=6, column names=3, but passed 0 and 2"
            }

            test("With invalid row and column names - when less") {
                shouldThrow<InvalidArgumentException> {
                    Table(data = data, columnNames = invalidColumnNames.subList(0, 3), rowNames = invalidRowNames.subList(0, 1))
                }.message shouldBe "Expected number of row names=6, column names=3, but passed 1 and 3"
            }

            test("With invalid row and column names - when empty") {
                shouldThrow<InvalidArgumentException> {
                    Table(data = data, columnNames = listOf(), rowNames = listOf())
                }.message shouldBe "Expected number of row names=6, column names=3, but passed 0 and 0"
            }
        }
    }

    context("toString - full table") {
        test("data") {
            val expected =
                        "Distributed Systems                                                Maarten van Steen    4.6    \n" +
                        "Domain Driven Design                                               Eric Evans           4.2    \n" +
                        "Clean Code                                                         Robert Martin        4.7    \n" +
                        "Test-Driven Development                                            Kent Beck            4.3    \n" +
                        "Rationality                                                        Eliezer Yudkowsky    4.7    \n" +
                        "Agile Software Development, Principles, Patterns, and Practices    Robert Martin        4.8    \n"
            Table(data).toString() shouldBe expected
        }

        test("row named data") {
            val expected =
                        "0    Distributed Systems                                                Maarten van Steen    4.6    \n" +
                        "1    Domain Driven Design                                               Eric Evans           4.2    \n" +
                        "2    Clean Code                                                         Robert Martin        4.7    \n" +
                        "3    Test-Driven Development                                            Kent Beck            4.3    \n" +
                        "4    Rationality                                                        Eliezer Yudkowsky    4.7    \n" +
                        "5    Agile Software Development, Principles, Patterns, and Practices    Robert Martin        4.8    \n"
            Table(data, rowNames = rowNames).toString() shouldBe expected
        }

        test("col named data") {
            val expected =
                        "Title                                                              Author               Rating    \n" +
                        "Distributed Systems                                                Maarten van Steen    4.6       \n" +
                        "Domain Driven Design                                               Eric Evans           4.2       \n" +
                        "Clean Code                                                         Robert Martin        4.7       \n" +
                        "Test-Driven Development                                            Kent Beck            4.3       \n" +
                        "Rationality                                                        Eliezer Yudkowsky    4.7       \n" +
                        "Agile Software Development, Principles, Patterns, and Practices    Robert Martin        4.8       \n"
            Table(data, columnNames = columnNames).toString() shouldBe expected
        }

        test("row and col named data") {
            val expected =
                        "     Title                                                              Author               Rating    \n" +
                        "0    Distributed Systems                                                Maarten van Steen    4.6       \n" +
                        "1    Domain Driven Design                                               Eric Evans           4.2       \n" +
                        "2    Clean Code                                                         Robert Martin        4.7       \n" +
                        "3    Test-Driven Development                                            Kent Beck            4.3       \n" +
                        "4    Rationality                                                        Eliezer Yudkowsky    4.7       \n" +
                        "5    Agile Software Development, Principles, Patterns, and Practices    Robert Martin        4.8       \n"
            Table(data, rowNames = rowNames, columnNames = columnNames).toString() shouldBe expected
        }
    }

    context("format properties") {
        test("column spaces") {
            val row = listOf("Agile Software Development, Principles, Patterns, and Practices", "Robert Martin", "4.8")

            Table(listOf(row)).toString()
                .shouldHaveLength(row.sumOf { it.length } + Table.Companion.SPACE_BETWEEN_COLUMNS * row.size + 1)
                .shouldStartWith("Agile")
                .shouldEndWith("4.8    \n")
        }

        test("column spaces -") {
            val tableData = listOf(
                listOf("Rationality", "Eliezer Yudkowsky", "4.7"),
                listOf("Agile Software Development, Principles, Patterns, and Practices", "Robert Martin", "4.8"))
            val finalTableRows = Table(tableData).toString().split("\n")

            finalTableRows[0]
                .substringAfter("Rationality")
                .substringBefore("Eliezer Yudkowsky")
                .shouldHaveLength(tableData[1][0].length + Table.Companion.SPACE_BETWEEN_COLUMNS - "Rationality".length)

            finalTableRows[1]
                .substringAfter("Robert Martin")
                .substringBefore("4.8")
                .shouldHaveLength(tableData[0][1].length + Table.Companion.SPACE_BETWEEN_COLUMNS - "Robert Martin".length)

        }
    }
})
