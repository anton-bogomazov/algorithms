package algorithm.array

// Implement a function that fills an area of the image with a solid color,
// starting from a given starting position and expanding outward to include all
// adjacent pixels that have the same color as the starting pixel.
// Complexity time/space: O(n)/O(n)
fun floodFill(image: Array<Array<Int>>, targetX: Int, targetY: Int, newColor: Int): Array<Array<Int>> {
    val colorToChange = image[targetX][targetY]
    if (colorToChange == newColor) return image

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(Pair(targetX, targetY))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        image[x][y] = newColor

        if (x > 0 && image[x - 1][y] == colorToChange) queue.add(Pair(x - 1, y))
        if (x < image.size - 1 && image[x + 1][y] == colorToChange) queue.add(Pair(x + 1, y))
        if (y > 0 && image[x][y - 1] == colorToChange) queue.add(Pair(x, y - 1))
        if (y < image[0].size - 1 && image[x][y + 1] == colorToChange) queue.add(Pair(x, y + 1))
    }

    return image
}
