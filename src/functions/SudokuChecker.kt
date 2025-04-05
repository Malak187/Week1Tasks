package functions

import kotlin.math.sqrt

fun main() {

}

fun checkSudokuGrid(sudokuGrid: List<List<String>>): Boolean {
    return (checkGridSize(sudokuGrid)
            && checkRowAndColumnConflicts(sudokuGrid)
            && checkSubGridConflicts(sudokuGrid))
}

fun checkGridSize(sudokuGrid: List<List<String>>): Boolean {
    return sudokuGrid.size == sudokuGrid[0].size
}

fun checkRowAndColumnConflicts(sudokuGrid: List<List<String>>): Boolean {
    for (i in 0..<sudokuGrid[0].size) {
        val seenRowValues = mutableListOf<String>()
        val seenColValues = mutableListOf<String>()

        for (j in 0..<sudokuGrid[0].size) {
            val rowCell = sudokuGrid[i][j]
            val colCell = sudokuGrid[j][i]
            if (rowCell != "-") {
                val rowInt = rowCell.toIntOrNull()
                if (rowCell in seenRowValues || rowInt == null || rowInt !in 1..sudokuGrid[0].size) return false
                seenRowValues.add(rowCell)
            }

            if (colCell != "-") {
                val colInt = colCell.toIntOrNull()
                if (colCell in seenColValues || colInt == null || colInt !in 1..sudokuGrid[0].size) return false
                seenColValues.add(colCell)
            }
        }
    }
    return true
}


fun checkSubGridConflicts(sudokuGrid: List<List<String>>): Boolean {
    for (i in sudokuGrid.indices step sqrt(sudokuGrid.size.toDouble()).toInt()) {
        for (j in sudokuGrid.indices step sqrt(sudokuGrid.size.toDouble()).toInt()) {
            val seenValues = mutableListOf<String>()
            for (k in 0..<sqrt(sudokuGrid.size.toDouble()).toInt()) {
                for (l in 0..<sqrt(sudokuGrid.size.toDouble()).toInt()) {
                    if (sudokuGrid[i + k][j + l] == "-") {
                        continue
                    }
                    val sudokuCell = sudokuGrid[i+k][j+l].toIntOrNull()
                    if (sudokuGrid[i + k][j + l] in seenValues || sudokuCell == null || sudokuCell !in (1..sudokuGrid.size)) {
                        return false
                    }
                    seenValues.add(sudokuGrid[i + k][j + l])
                }

            }
        }
    }
    return true
}

