package algorithm.merge

// Merge Overlapping Intervals
// Given a set of time intervals in any order, merge all overlapping intervals into one and
// output the result which should have only mutually exclusive intervals.
// Worst case complexity time/space: O(n*log(n))/O(1)
fun mergeIntervals(intervals: Array<Interval>): Array<Interval> {
    intervals.sortBy { it.start }

    var index = 0
    for (i in 1..intervals.lastIndex) {
        if (intervals[index].end >= intervals[i].start) {
            intervals[index].end = intervals[index].end.coerceAtLeast(intervals[i].end)
        } else {
            index++
            intervals[index] = intervals[i]
        }
    }

    return intervals.sliceArray(0..index)
}

data class Interval(var start: Int, var end: Int)
