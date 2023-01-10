package data.structure.container.set

class DisjointSet<T>(universe: Array<T>) {
    private val parent: MutableMap<T, T> = HashMap()

    init {
        for (element in universe) {
            parent[element] = element
        }
    }

    fun find(k: T): T {
        return if (parent[k] == k) k else find(parent[k]!!)
    }

    fun union(a: T, b: T) {
        val x = find(a)
        val y = find(b)
        parent[x] = y
    }
}
