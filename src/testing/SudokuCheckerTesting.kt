package testing

import functions.checkSudokuGrid


fun main() {

    testGrid(
        name = "When the sudoku grid is 3*3 has elements in each square and valid it should return true",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = true
    )

    testGrid(
        name = "When the sudoku grid is 3*3 has negative element in any square it should return false",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "-6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    testGrid(
        name = "When the sudoku grid is is 3*3 and empty it should return true",
        result = checkSudokuGrid(
            List(9) { MutableList(9) { "-" } }
        ),
        correctResult = true
    )

    testGrid(
        name = "When the sudoku grid is 3*3 and has a duplicated element in any column (first here) it should return false",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("7", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    testGrid(
        name = "When the sudoku grid is 3*3 and has a duplicated element in any row (third here) it should return false",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "8", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    testGrid(
        name = "When the sudoku grid is 3*3 and has a duplicated element in any subgrid ( fourth here ) it should return false",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "1", "-", "6", "-"),
                listOf("8", "4", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "8", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    testGrid(
        name = "When the sudoku grid is 3*3, fully valid and completed ",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
                listOf("6", "7", "2", "1", "9", "5", "3", "4", "8"),
                listOf("1", "9", "8", "3", "4", "2", "5", "6", "7"),
                listOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
                listOf("4", "2", "6", "8", "5", "3", "7", "9", "1"),
                listOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
                listOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
                listOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
                listOf("3", "4", "5", "2", "8", "6", "1", "7", "9")
            )
        ),
        correctResult = true
    )


    testGrid(
        name = "When the sudoku grid is 3*3 and fully completed but not valid ",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
                listOf("6", "5", "2", "1", "9", "5", "3", "4", "8"),
                listOf("1", "9", "8", "3", "4", "2", "5", "6", "7"),
                listOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
                listOf("4", "2", "6", "8", "5", "3", "7", "9", "1"),
                listOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
                listOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
                listOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
                listOf("3", "4", "5", "2", "8", "6", "2", "7", "9")
            )
        ),
        correctResult = false
    )

    testGrid(
        name = "When the sudoku grid is 3*3 and has letters ",
        result = checkSudokuGrid(
            listOf(
                listOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
                listOf("6", "d", "2", "1", "9", "5", "3", "4", "8"),
                listOf("1", "9", "8", "3", "y", "2", "5", "6", "7"),
                listOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
                listOf("4", "2", "6", "g", "5", "3", "7", "9", "1"),
                listOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
                listOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
                listOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
                listOf("z", "4", "5", "2", "8", "6", "f", "7", "9")
            )
        ),
        correctResult = false
    )

    //trying different sizes
    testGrid(
        name = "When the sudoku grid 2*2 has has a duplicated element in any subgrid it should return false ",
        result = checkSudokuGrid(
            listOf(
                listOf("1", "_", "3", "4"),
                listOf("2", "1", "4", "3"),
                listOf("3", "_", "1", "2"),
                listOf("4", "_", "2", "1")
            )
        ),
        correctResult = false
    )

    testGrid(
        name = "When the sudoku grid 2*2 is fully completed and valid it should return true ",
        result = checkSudokuGrid(
            listOf(
                listOf("1", "2", "3", "4"),
                listOf("3", "4", "1", "2"),
                listOf("2", "1", "4", "3"),
                listOf("4", "3", "2", "1")
            )
        ),
        correctResult = true
    )

    testGrid(
        name = "When the sudoku grid is 4*4 is fully completed and valid it should return true ",
        result = checkSudokuGrid(
            listOf(
                listOf( "1",  "2",  "3",  "4",  "5",  "6",  "7",  "8",  "9", "10", "11", "12", "13", "14", "15", "16"),
                listOf( "5",  "6",  "7",  "8",  "1",  "2",  "3",  "4", "13", "14", "15", "16",  "9", "10", "11", "12"),
                listOf( "9", "10", "11", "12", "13", "14", "15", "16",  "1",  "2",  "3",  "4",  "5",  "6",  "7",  "8"),
                listOf("13", "14", "15", "16",  "9", "10", "11", "12",  "5",  "6",  "7",  "8",  "1",  "2",  "3",  "4"),

                listOf( "2",  "1",  "4",  "3",  "6",  "5",  "8",  "7", "10",  "9", "12", "11", "14", "13", "16", "15"),
                listOf( "6",  "5",  "8",  "7",  "2",  "1",  "4",  "3", "14", "13", "16", "15", "10",  "9", "12", "11"),
                listOf("10",  "9", "12", "11", "14", "13", "16", "15",  "2",  "1",  "4",  "3",  "6",  "5",  "8",  "7"),
                listOf("14", "13", "16", "15", "10",  "9", "12", "11",  "6",  "5",  "8",  "7",  "2",  "1",  "4",  "3"),

                listOf( "3",  "4",  "1",  "2",  "7",  "8",  "5",  "6", "11", "12",  "9", "10", "15", "16", "13", "14"),
                listOf( "7",  "8",  "5",  "6",  "3",  "4",  "1",  "2", "15", "16", "13", "14", "11", "12",  "9", "10"),
                listOf("11", "12",  "9", "10", "15", "16", "13", "14",  "3",  "4",  "1",  "2",  "7",  "8",  "5",  "6"),
                listOf("15", "16", "13", "14", "11", "12",  "9", "10",  "7",  "8",  "5",  "6",  "3",  "4",  "1",  "2"),

                listOf( "4",  "3",  "2",  "1",  "8",  "7",  "6",  "5", "12", "11", "10",  "9", "16", "15", "14", "13"),
                listOf( "8",  "7",  "6",  "5",  "4",  "3",  "2",  "1", "16", "15", "14", "13", "12", "11", "10",  "9"),
                listOf("12", "11", "10",  "9", "16", "15", "14", "13",  "4",  "3",  "2",  "1",  "8",  "7",  "6",  "5"),
                listOf("16", "15", "14", "13", "12", "11", "10",  "9",  "8",  "7",  "6",  "5",  "4",  "3",  "2",  "1")
            )),
        correctResult = true
    )

    testGrid(
        name = "When the sudoku grid is 4*4 and has a duplicated element in any row (first here) it should return false",
        result = checkSudokuGrid(
                listOf(
                listOf( "1",  "-",  "3",  "4",  "-",  "6",  "7",  "-",  "7", "10", "-", "12", "13", "-", "15", "16"),
                listOf( "5",  "6",  "-",  "8",  "1",  "-",  "3",  "4", "-", "14", "15", "-",  "9", "10", "-", "12"),
                listOf( "9", "-", "11", "12", "-", "14", "-", "16",  "1",  "-",  "3",  "4",  "-",  "6",  "7",  "-"),
                listOf("13", "14",  "-", "16",  "9",  "-", "11", "12",  "5",  "-",  "7",  "8",  "-",  "2",  "3",  "-"),

                listOf( "2",  "-",  "4",  "3",  "-",  "5",  "8",  "-", "10",  "-", "12", "11", "-", "13", "16", "-"),
                listOf( "6",  "5",  "-",  "7",  "2",  "-",  "4",  "3", "-", "13", "16", "-", "10",  "-", "12", "11"),
                listOf("10",  "-", "12", "11", "-", "13", "-", "15",  "2",  "-",  "4",  "3",  "-",  "5",  "8",  "-"),
                listOf("14", "13",  "-", "15", "10",  "-", "12", "11",  "-",  "5",  "-",  "7",  "-",  "1",  "4",  "-"),

                listOf( "3",  "-",  "1",  "2",  "-",  "8",  "5",  "-", "-", "12",  "9", "-", "15", "-", "13", "14"),
                listOf( "7",  "8",  "-",  "6",  "3",  "-",  "1",  "2", "15", "-", "13", "14", "-", "12",  "-", "10"),
                listOf("11", "-",  "9", "10", "-", "16", "-", "14",  "3",  "-",  "1",  "2",  "-",  "8",  "5",  "-"),
                listOf("15", "16",  "-", "14", "11",  "-",  "9", "10",  "-",  "8",  "-",  "6",  "-",  "4",  "1",  "-"),

                listOf( "4",  "-",  "2",  "1",  "-",  "7",  "6",  "-", "-", "11", "10", "-", "16", "-", "14", "13"),
                listOf( "8",  "7",  "-",  "5",  "4",  "-",  "2",  "1", "16", "-", "14", "13", "-", "11",  "-",  "9"),
                listOf("12", "-", "10",  "9", "-", "15", "-", "13",  "4",  "-",  "2",  "1",  "-",  "7",  "6",  "-"),
                listOf("16", "15",  "-", "13", "12",  "-", "10",  "9",  "-",  "7",  "-",  "5",  "-",  "3",  "2",  "-")
    )),
        correctResult = false
    )


    testGrid(
        name = "When the sudoku grid width and height are not equal it should return false",
        result = checkSudokuGrid(
            listOf(
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("7", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )
}

fun testGrid(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}