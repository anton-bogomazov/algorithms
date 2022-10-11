package util

import exception.invalidArgumentError


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
    }

    init {
        val isColNamesMatchesContent = columnNames?.let { it.size == data.first().size } ?: true
        val isRowNamesMatchesContent = rowNames?.let { it.size == data.size } ?: true

        if (!isColNamesMatchesContent || !isRowNamesMatchesContent) {
            namesValidationError(rowNames?.size ?: 0, columnNames?.size ?: 0)
        }
    }

    private val table = buildTable()

    private fun buildTable(): List<List<String>> {
        val namedRowsTable = { data.mapIndexed { i, row -> listOf(rowNames!![i]) + row } }
        val namedRowsTableHeader = { listOf(EMPTY_STRING) + columnNames!! }
        return when (rowNames) {
            null -> if (columnNames == null) data else listOf(columnNames) + data
            else -> if (columnNames == null) namedRowsTable() else listOf(namedRowsTableHeader()) + namedRowsTable()
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

    private fun namesValidationError(rows: Int, columns: Int): Nothing =
        invalidArgumentError("Expected number of row names=${data.size}, column names=${data.first().size}, but passed $rows and $columns")
}
