package utils

// todo tests
class Table(
    private val data: List<List<String>>,
    private val columnNames: List<String>? = null,
    private val rowNames: List<String>? = null
) {

    companion object {
        const val NEW_LINE = "\n"
        const val EMPTY_STRING = ""
        const val SPACE_CHAR = " "

        const val SPACE_BETWEEN_COLUMNS = 4

        const val COLUMN_NAMES_SIZE_ERROR = "Impossible match table data with column names"
        const val ROW_NAMES_SIZE_ERROR = "Impossible match table data with column names"
        const val UNKNOWN_ERROR = "Unknown error"
    }

    private val table = buildTable()

    private fun buildTable(): List<List<String>> {
        if (columnNames != null && columnNames.size != data.first().size) error(COLUMN_NAMES_SIZE_ERROR)
        if (rowNames != null && rowNames.size != data.size) error(ROW_NAMES_SIZE_ERROR)

        return when {
            columnNames != null && rowNames == null -> listOf(columnNames) + data
            columnNames == null && rowNames != null -> data.mapIndexed { i, row -> listOf(rowNames[i]) + row }
            columnNames == null && rowNames == null -> data
            columnNames != null && rowNames != null -> listOf(listOf(EMPTY_STRING) + columnNames) +
                    data.mapIndexed { i, row -> listOf(rowNames[i]) + row }
            else -> error(UNKNOWN_ERROR)
        }
    }

    private fun columnWidths(): List<Int> {
        val contentLengths = table.map { row -> row.map { it.length } }

        val colIndices = contentLengths.first().indices
        val rowIndices = contentLengths.indices

        return buildList {
            for (i in colIndices) {
                add(buildList {
                    for (j in rowIndices) {
                        add(contentLengths[j][i])
                    }
                }.max() + SPACE_BETWEEN_COLUMNS)
            }
        }
    }

    override fun toString() = buildString {
        val columnWidths = columnWidths()

        table.forEach { row ->
            row.forEachIndexed { index, content ->
                append(content)
                repeat(columnWidths[index] - content.length) { append(SPACE_CHAR) }
            }
            append(NEW_LINE)
        }
    }
}
