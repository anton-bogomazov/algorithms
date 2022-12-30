package util

import exception.InvalidArgumentException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import util.Matrix.Companion.init
import util.Matrix.Companion.intMatrix

class MatrixTest : FunSpec({
    context("create generic matrix") {
        val obj = object {}
        withData(
            nameFn = { "width: ${it.a}, height:${it.b}, initWith:${it.c}" },
            row(5, 10, obj),
            row(15, 10, ""),
            row(5500, 1000, 1)
        ) { (width, height, initWith) ->
            val matrix = init(height, width, initWith)

            matrix.forEach { row ->
                row.size shouldBe width
                row.forEach { cell ->
                    cell shouldBe initWith
                }
            }
            matrix.size shouldBe height
        }
    }

    context("create generic matrix - error") {
        val obj = object {}
        withData(
            nameFn = { "width: ${it.a}, height:${it.b}, initWith:${it.c}" },
            row(-1, 1, obj),
            row(1, -1, ""),
            row(0, 1, 1),
            row(1, 0, 10.0),
        ) { (width, height, initWith) ->
            shouldThrow<InvalidArgumentException> {
                init(height, width, initWith)
            }.message shouldBe "Height and width should be positive"
        }
    }

    context("create concrete matrix") {
        withData(
            nameFn = { "width: ${it.a}, height:${it.b}" },
            row(100, 5000),
            row(1, 1),
            row(10, 1)
        ) { (width, height) ->
            val matrix = intMatrix(height, width)

            matrix.forEach { row ->
                row.size shouldBe width
                row.forEach { cell ->
                    cell shouldBe 0
                }
            }
            matrix.size shouldBe height
        }
    }
})
