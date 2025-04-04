package functions

import kotlin.math.sqrt

fun main() {

}

fun checkSudokuGrid(sudokuGrid: List<List<String>>): Boolean {
    return (checkGridSize(sudokuGrid) &&
            checkRowConflicts(sudokuGrid)
            && checkColumnConflicts(sudokuGrid)
            && checkSubGridConflicts(sudokuGrid))
}

fun checkGridSize(sudokuGrid: List<List<String>>): Boolean {
    return sudokuGrid.size == sudokuGrid[0].size
}

fun checkRowConflicts(sudokuGrid: List<List<String>>): Boolean {
    for (i in 0..<sudokuGrid[0].size) {
        val seenValues = mutableListOf<String>()
        for (j in 0..<sudokuGrid[0].size) {
            if (sudokuGrid[i][j] == "-") {
                continue
            }
            val sudokuCell = sudokuGrid[i][j].toIntOrNull()
            if (sudokuGrid[i][j] in seenValues || sudokuCell == null || sudokuCell !in (1..sudokuGrid.size)) {
                return false
            }
            seenValues.add(sudokuGrid[i][j])
        }
    }
    return true
}

// check for negative values
fun checkColumnConflicts(sudokuGrid: List<List<String>>): Boolean {
    for (i in 0..<sudokuGrid[0].size) {
        val seenValues = mutableListOf<String>()
        for (j in 0..<sudokuGrid[0].size) {
            if (sudokuGrid[j][i] == "-") {
                continue
            }
            val sudokuCell = sudokuGrid[j][i].toIntOrNull()
            if (sudokuGrid[j][i] in seenValues || sudokuCell == null || sudokuCell !in (1..sudokuGrid.size)) {
                return false
            }
            seenValues.add(sudokuGrid[j][i])
        }
    }
    return true
}

//simplify to 2 functions
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

