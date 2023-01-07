package problem

import java.util.*

// A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
// Given the locations and heights of all the buildings, return the skyline formed by height change critical points.
// O(n^2), O(n)
fun getSkyline(buildings: Array<IntArray>): List<IntArray> {
    val result: MutableList<IntArray> = ArrayList()

    // map to HeightPoints and sort by coordinate and height
    val heightPoints =
        buildings.flatMap {
            listOf(
                HeightPoint(height = it[2], coordinate = it[0], type = HeightPoint.PointType.START),
                HeightPoint(height = it[2], coordinate = it[1], type = HeightPoint.PointType.END)
            )
        }.sortedWith(compareBy({ it.coordinate }, { it.height }))

    val queue = PriorityQueue<Int> { a, b -> b - a } // set desc ordering
    queue.offer(0) // set floor
    var maxHeight = -1

    for ((i, point) in heightPoints.withIndex()) {
        when (point.type) {
            HeightPoint.PointType.START -> queue.offer(point.height) // building started
            HeightPoint.PointType.END -> queue.remove(point.height) // building ended
        }

        val currentMaxHeight = queue.peek() // looking through all buildings to see the highest one
        // handle abutting buildings
        // if current building is last, nextBuildingCoordinate will be null
        val nextBuildingCoordinate = if (i + 1 in heightPoints.indices) heightPoints[i + 1].coordinate else null
        // if current building is last, next one isn't abutting so return false
        val isAbutting = nextBuildingCoordinate?.let { it == point.coordinate } ?: false
        if (isAbutting) continue
        // add to results critical point
        if (currentMaxHeight != maxHeight) {
            result.add(intArrayOf(point.coordinate, currentMaxHeight))
            maxHeight = currentMaxHeight
        }
    }

    return result
}

data class HeightPoint(
    val height: Int,
    val coordinate: Int,
    val type: PointType
) {
    enum class PointType { START, END }
}
