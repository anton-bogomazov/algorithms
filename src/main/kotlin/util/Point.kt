package util

data class Point(val x: Int, val y: Int)

infix fun Int.with(that: Int): Point = Point(this, that)

fun Matrix<*>.isInBounds(point: Point) = point.x in this.columns.indices && point.y in this.rows.indices
