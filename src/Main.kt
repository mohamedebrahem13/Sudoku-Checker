import kotlin.math.sqrt

fun main() {
    // Valid Sudoku Cases
    println("Valid 16x16 Sudoku: " + isValidSudoku(valid16x16Sudoku))
    println("Valid 9x9 Sudoku: " + isValidSudoku(validSudoku9x9))
    println("Valid 4x4 Sudoku: " + isValidSudoku(validSudoku4x4))
    println("Valid 3x3 Sudoku: " + isValidSudoku(validSudoku3x3))

    // Valid Empty Cases
    println("Valid 16x16 Sudoku (Empty Column): " + isValidSudoku(validWithEmptyColumn16x16))
    println("Valid 16x16 Sudoku (Empty Row): " + isValidSudoku(validWithEmptyRow16x16))
    println("Valid 9x9 Sudoku (Empty Column): " + isValidSudoku(validWithEmptyColumn9x9))
    println("Valid 9x9 Sudoku (Empty Row): " + isValidSudoku(validWithEmptyRow9x9))
    println("Valid 4x4 Sudoku (Empty Column): " + isValidSudoku(validWithEmptyColumn4x4))
    println("Valid 4x4 Sudoku (Empty Row): " + isValidSudoku(validWithEmptyRow4x4))
    println("Valid 3x3 Sudoku (Empty Column): " + isValidSudoku(validWithEmptyColumn3x3))
    println("Valid 3x3 Sudoku (Empty Row): " + isValidSudoku(validWithEmptyRow3x3))

    // Invalid Sudoku Cases
    println("Invalid 16x16 Sudoku: " + isValidSudoku(invalid16x16Sudoku))
    println("Invalid 3x3 Sudoku: " + isValidSudoku(invalidSudoku3x3))

    // Invalid Duplicate Cases
    println("Invalid Sudoku (Duplicate in Row - 16x16): " + isValidSudoku(invalidRowSudoku16x16))
    println("Invalid Sudoku (Duplicate in Row - 9x9): " + isValidSudoku(invalidRowSudoku9x9))
    println("Invalid Sudoku (Duplicate in Row - 4x4): " + isValidSudoku(invalidRowSudoku4x4))
    println("Invalid Sudoku (Duplicate in Row - 3x3): " + isValidSudoku(invalidRowSudoku3x3))

    println("Invalid Sudoku (Duplicate in Column - 16x16): " + isValidSudoku(invalidColumnSudoku16x16))
    println("Invalid Sudoku (Duplicate in Column - 9x9): " + isValidSudoku(invalidColumnSudoku9x9))
    println("Invalid Sudoku (Duplicate in Column - 4x4): " + isValidSudoku(invalidColumnSudoku4x4))
    println("Invalid Sudoku (Duplicate in Column - 3x3): " + isValidSudoku(invalidColumnSudoku3x3))

    // Invalid Subgrid Cases
    println("Invalid Sudoku (Duplicate in Subgrid - 16x16): " + isValidSudoku(invalidSubgridSudoku16x16))
    println("Invalid Sudoku (Duplicate in Subgrid - 9x9): " + isValidSudoku(invalidSubgridSudoku9x9))
    println("Invalid Sudoku (Duplicate in Subgrid - 4x4): " + isValidSudoku(invalidSubgridSudoku4x4))

    // Invalid Format Cases
    println("Invalid Sudoku (Non-Numeric 9x9): " + isValidSudoku(invalidNonNumericSudoku9x9))
    println("Invalid Sudoku (Non-Numeric 4x4): " + isValidSudoku(invalidNonNumericSudoku4x4))
    println("Invalid Sudoku (Non-Numeric 3x3): " + isValidSudoku(invalidNonNumericSudoku3x3))
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = board.size
    val cols = board[0].size

    // Check if all rows have the same length
    if (!areRowsEqualLength(board, rows)) {
        return false
    }
    // Get the valid characters based on the grid size
    val validChars = getValidChars(rows)


    // Special handling for 3x3 Sudoku, where no sub grids are needed
    if (rows == 3 && rows == cols) {
        return isValid3x3(board, validChars, rows)
    }

    // General validation for non-3x3 grids
    val rowSets = Array(rows) { mutableSetOf<Char>() }
    val colSets = Array(cols) { mutableSetOf<Char>() }
    val squareSets = mutableMapOf<Pair<Int, Int>, MutableSet<Char>>()

    // Subgrid size calculation for non-standard grids
    val subGridRowSize = sqrt(rows.toDouble()).toInt()
    val subGridColSize = sqrt(cols.toDouble()).toInt()

    // If it's not a perfect square, return false
    if (subGridRowSize * subGridRowSize != rows || subGridColSize * subGridColSize != cols) {
        return false
    }

    for (r in 0..<rows) {
        for (c in 0..<cols) {
            val char = board[r][c]

            if (char == '-') continue // Ignore empty cells
            if (char !in validChars) return false // Invalid character

            if (char in rowSets[r]) return false // Duplicate in row
            rowSets[r].add(char)

            if (char in colSets[c]) return false // Duplicate in column
            colSets[c].add(char)

            // Check subgrid
            val subgridKey = Pair(r / subGridRowSize, c / subGridColSize)
            val subgridSet = squareSets.getOrPut(subgridKey) { mutableSetOf() }

            if (char in subgridSet) return false // Check for duplicates in subgrid
            subgridSet.add(char)
        }
    }
    return true
}


fun areRowsEqualLength(board: Array<CharArray>, rows: Int): Boolean {
    if (rows <= 0) return false
    val cols = board[0].size
    for (r in 1..<rows) {
        if (board[r].size != cols) {
            return false // Uneven row sizes
        }
    }
    return true
}

// Function to define valid characters based on the grid size
fun getValidChars(rows: Int): Iterable<Char> {
    return if (rows >= 16) {
        ('1'..'9') + ('A'..'G') // For 16x16 or larger grids, valid characters are '1'-'9' and 'A'-'G'
    } else {
        ('1'..'9') // For smaller grids (e.g., 3x3, 9x9), only '1'-'9' are valid
    }
}

fun isValid3x3(board: Array<CharArray>, validChars: Iterable<Char>, rows: Int): Boolean {
    val rowSets = Array(rows) { mutableSetOf<Char>() }
    val colSets = Array(rows) { mutableSetOf<Char>() }

    for (r in 0..<rows) {
        for (c in 0..<rows) {
            val char = board[r][c]

            if (char == '-') continue // Ignore empty cells
            if (char !in validChars) return false // Invalid character

            if (char in rowSets[r]) return false // Duplicate in row
            if (char in colSets[c]) return false // Duplicate in column

            rowSets[r].add(char)
            colSets[c].add(char)
        }
    }
    return true
}