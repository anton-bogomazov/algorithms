package problem.array

val set = mutableSetOf<Any>()

fun <T> permute(array: Array<T>, left: Int, right: Int) {
    var array = array

    if (left == right) {
        set.add(array)
    } else {
        for (i in left..right) {
            array = swap(array, left, i)
            permute(array, left + 1, right)
            array = swap(array, left, i)
        }
    }
}

private fun <T> swap(array: Array<T>, i: Int, j: Int): Array<T> {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
    return array.clone()
}
