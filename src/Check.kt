fun main() {
//region Valid Sudoku Boards
// 16x16
    check("Valid 16x16 Sudoku", isValidSudoku(valid16x16Sudoku), true)
    check("Valid Sudoku (16x16, Empty Column)", isValidSudoku(validWithEmptyColumn16x16), true)
    check("Valid Sudoku (16x16, Empty Row)", isValidSudoku(validWithEmptyRow16x16), true)
    check("Valid Sudoku (16x16, Fully Empty Board)", isValidSudoku(validWithFullyEmptyBoard16x16), true)
// 9x9
    check("Valid 9x9 Sudoku", isValidSudoku(validSudoku9x9), true)
    check("Valid Sudoku (9x9, Empty Column)", isValidSudoku(validWithEmptyColumn9x9), true)
    check("Valid Sudoku (9x9, Empty Row)", isValidSudoku(validWithEmptyRow9x9), true)
    check("Valid Sudoku (9x9, Fully Empty Board)", isValidSudoku(validWithFullyEmptyBoard9x9), true)
// 4x4
    check("Valid 4x4 Sudoku", isValidSudoku(validSudoku4x4), true)
    check("Valid Sudoku (4x4, Empty Column)", isValidSudoku(validWithEmptyColumn4x4), true)
    check("Valid Sudoku (4x4, Empty Row)", isValidSudoku(validWithEmptyRow4x4), true)
    check("Valid Sudoku (4x4, Fully Empty Board)", isValidSudoku(validWithFullyEmptyBoard4x4), true)
// 3x3
    check("Valid 3x3 Sudoku", isValidSudoku(validSudoku3x3), true)
    check("Valid Sudoku (3x3, Empty Column)", isValidSudoku(validWithEmptyColumn3x3), true)
    check("Valid Sudoku (3x3, Empty Row)", isValidSudoku(validWithEmptyRow3x3), true)
    check("Valid Sudoku (3x3, Fully Empty Board)", isValidSudoku(validWithFullyEmptyBoard3x3), true)
//endregion

//region Invalid Sudoku Boards
// 16x16
    check("Invalid 16x16 Sudoku (Duplicate in Column)", isValidSudoku(invalidColumnSudoku16x16), false)
    check("Invalid 16x16 Sudoku (Empty cells are not '-')", isValidSudoku(invalidEmptyCharacterBoard16x16), false)
    check("Invalid 16x16 Sudoku (miss in row)", isValidSudoku(invalid16x16Sudoku), false)
    check("Invalid 16x16 Sudoku (Duplicate in Row)", isValidSudoku(invalidRowSudoku16x16), false)
    check("Invalid 16x16 Sudoku (Uneven Row Sizes)", isValidSudoku(invalidUnevenBoard16x16), false)
    check("Invalid Sudoku (16x16 Board, Duplicate in Subgrid)", isValidSudoku(invalidSubgridSudoku16x16), false)

// 9x9
    check("Invalid 9x9 Sudoku (Duplicate in Column)", isValidSudoku(invalidColumnSudoku9x9), false)
    check("Invalid 9x9 Sudoku (Empty cells are not '-')", isValidSudoku(invalidEmptyCharacterBoard9x9), false)
    check("Invalid Sudoku (9x9 Board, Non-Numeric Characters in Row)", isValidSudoku(invalidNonNumericSudoku9x9), false)
    check("Invalid 9x9 Sudoku (Duplicate in Row)", isValidSudoku(invalidRowSudoku9x9), false)
    check("Invalid 9x9 Sudoku (Uneven Row Sizes)", isValidSudoku(invalidUnevenBoard9x9), false)
    check("Invalid Sudoku (9x9 Board, Duplicate in Subgrid)", isValidSudoku(invalidSubgridSudoku9x9), false)

// 4x4
    check("Invalid 4x4 Sudoku (Duplicate in Column)", isValidSudoku(invalidColumnSudoku4x4), false)
    check("Invalid 4x4 Sudoku (Empty cells are not '-')", isValidSudoku(invalidEmptyCharacterBoard4x4), false)
    check("Invalid 4x4 Sudoku (Non-Numeric Characters in Row)", isValidSudoku(invalidNonNumericSudoku4x4), false)
    check("Invalid 4x4 Sudoku (Duplicate in Row)", isValidSudoku(invalidRowSudoku4x4), false)
    check("Invalid 4x4 Sudoku (Uneven Row Sizes)", isValidSudoku(invalidUnevenBoard4x4), false)
    check("Invalid Sudoku (4x4 Board, Duplicate in Subgrid)", isValidSudoku(invalidSubgridSudoku4x4), false)

// 3x3
    check("Invalid 3x3 Sudoku (Duplicate in Column)", isValidSudoku(invalidColumnSudoku3x3), false)
    check("Invalid 3x3 Sudoku (Empty cells are not '-')", isValidSudoku(invalidEmptyCharacterBoard3x3), false)
    check("Invalid 3x3 Sudoku (Duplicate in Row)", isValidSudoku(invalidRowSudoku3x3), false)
    check("Invalid Sudoku (3x3 Board, Non-Numeric Characters in Row)", isValidSudoku(invalidNonNumericSudoku3x3), false)
    check("Invalid 3x3 Sudoku (Uneven Row Sizes)", isValidSudoku(invalidUnevenBoard3x3), false)

// Other invalid cases
    check("Invalid Sudoku (8x8 Board, Not a Perfect Square)", isValidSudoku(invalid8x8Board), false)
//endregion

}

fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}

//region Valid Sudoku Boards parameter

// A valid 9x9 Sudoku grid
val validSudoku9x9 = arrayOf(
    charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
    charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
    charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
    charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
    charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
    charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
    charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
    charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
    charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
)

// A valid 4x4 Sudoku grid
val validSudoku4x4 = arrayOf(
    charArrayOf('1', '2', '3', '4'),
    charArrayOf('3', '4', '1', '2'),
    charArrayOf('2', '1', '4', '3'),
    charArrayOf('4', '3', '2', '1')
)

// A valid 16x16 Sudoku grid
val valid16x16Sudoku = arrayOf(
    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
    charArrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
    charArrayOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
    charArrayOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),

    charArrayOf('2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F'),
    charArrayOf('6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3'),
    charArrayOf('A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7'),
    charArrayOf('E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B'),

    charArrayOf('3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E'),
    charArrayOf('7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2'),
    charArrayOf('B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6'),
    charArrayOf('F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A'),

    charArrayOf('4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D'),
    charArrayOf('8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1'),
    charArrayOf('C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5'),
    charArrayOf('G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9')
)


// 3×3 - Valid Empty Column
val validWithEmptyColumn3x3 = arrayOf(
    charArrayOf('1', '-', '3'),
    charArrayOf('2', '-', '1'),
    charArrayOf('3', '-', '2')
)

// 3×3 - Valid Empty Row
val validWithEmptyRow3x3 = arrayOf(
    charArrayOf('-', '-', '-'),
    charArrayOf('3', '1', '2'),
    charArrayOf('2', '3', '1')
)

// 3×3 - Fully Empty Board
val validWithFullyEmptyBoard3x3 = arrayOf(
    charArrayOf('-', '-', '-'),
    charArrayOf('-', '-', '-'),
    charArrayOf('-', '-', '-')
)

// 4×4 - Valid Empty Column
val validWithEmptyColumn4x4 = arrayOf(
    charArrayOf('1', '2', '-', '4'),
    charArrayOf('3', '4', '-', '1'),
    charArrayOf('2', '1', '-', '3'),
    charArrayOf('4', '3', '-', '2')
)

// 4×4 - Valid Empty Row
val validWithEmptyRow4x4 = arrayOf(
    charArrayOf('1', '2', '3', '4'),
    charArrayOf('3', '4', '1', '2'),
    charArrayOf('-', '-', '-', '-'), // Empty row placed carefully
    charArrayOf('4', '3', '2', '1')
)

// 4×4 - Fully Empty Board
val validWithFullyEmptyBoard4x4 = arrayOf(
    charArrayOf('-', '-', '-', '-'),
    charArrayOf('-', '-', '-', '-'),
    charArrayOf('-', '-', '-', '-'),
    charArrayOf('-', '-', '-', '-')
)

// 9×9 - Valid Empty Column
val validWithEmptyColumn9x9 = arrayOf(
    charArrayOf('5', '-', '3', '-', '7', '-', '-', '-', '-'),
    charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
    charArrayOf('-', '-', '8', '-', '-', '-', '-', '6', '-'),
    charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
    charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
    charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
    charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
    charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
    charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
)

// 9×9 - Valid Empty Row
val validWithEmptyRow9x9 = arrayOf(
    charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
    charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
    charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
    charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
    charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
    charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
    charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
    charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
    charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
)

// 9×9 - Fully Empty Board
val validWithFullyEmptyBoard9x9 = Array(9) { CharArray(9) { '-' } }

// 16×16 - Valid Empty Column
val validWithEmptyColumn16x16 = arrayOf(
    charArrayOf('1', '-', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
    charArrayOf('5', '-', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
    charArrayOf('9', '-', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
    charArrayOf('D', '-', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),
    charArrayOf('2', '-', '4', '1', '6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F'),
    charArrayOf('6', '-', '8', '5', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3'),
    charArrayOf('A', '-', 'C', '9', 'E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7'),
    charArrayOf('E', '-', 'G', 'D', '2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B'),
    charArrayOf('3', '-', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E'),
    charArrayOf('7', '-', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2'),
    charArrayOf('B', '-', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6'),
    charArrayOf('F', '-', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A'),
    charArrayOf('4', '-', '2', '3', '8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D'),
    charArrayOf('8', '-', '6', '7', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1'),
    charArrayOf('C', '-', 'A', 'B', 'G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5'),
    charArrayOf('G', '-', 'E', 'F', '4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9')
)

// 16×16 - Valid Empty Row
val validWithEmptyRow16x16 = arrayOf(
    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
    charArrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
    charArrayOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
    charArrayOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),
    charArrayOf('2', '3', '4', '1', '6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F'),
    charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'), // Empty row
    charArrayOf('A', 'B', 'C', '9', 'E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7'),
    charArrayOf('E', 'F', 'G', 'D', '2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B'),
    charArrayOf('3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E'),
    charArrayOf('7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2'),
    charArrayOf('B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6'),
    charArrayOf('F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A'),
    charArrayOf('4', '1', '2', '3', '8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D'),
    charArrayOf('8', '5', '6', '7', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1'),
    charArrayOf('C', '9', 'A', 'B', 'G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5'),
    charArrayOf('G', 'D', 'E', 'F', '4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9')
)

// 16×16 - Fully Empty Board
val validWithFullyEmptyBoard16x16 = Array(16) { CharArray(16) { '-' } }


// valid 3x3 Sudoku grid
val validSudoku3x3 = arrayOf(
    charArrayOf('1', '2', '3'),
    charArrayOf('3', '1', '2'),
    charArrayOf('2', '3', '1')
)

//endregion


//region inValid Sudoku Boards parameter

// invalid 3x3 Sudoku grid
val invalidSudoku3x3 = arrayOf(
    charArrayOf('1', '3', '3'), //duplicate in row
    charArrayOf('3', '1', '2'),
    charArrayOf('2', '3', '1')
)

// invalid 3x3 Sudoku grid
val invalidNonNumericSudoku3x3 = arrayOf(
    charArrayOf('1', 'A', '3'), //A
    charArrayOf('3', '1', '2'),
    charArrayOf('2', '3', '1')
)

// Invalid 3x3 board with duplicate in a row
val invalidRowSudoku3x3 = arrayOf(
    charArrayOf('1', '2', '2'), // Duplicate '2'
    charArrayOf('3', '-', '1'),
    charArrayOf('-', '3', '-')
)

//  Duplicate '4' in 2×2 subgrid
val invalidSubgridSudoku4x4 = arrayOf(
    charArrayOf('1', '2', '3', '4'),
    charArrayOf('4', '4', '1', '2'),
    charArrayOf('2', '3', '4', '1'),
    charArrayOf('4', '1', '2', '3')
)

// Invalid 4x4 board with duplicate in a row
val invalidRowSudoku4x4 = arrayOf(
    charArrayOf('1', '2', '3', '3'), // Duplicate '3'
    charArrayOf('4', '-', '2', '-'),
    charArrayOf('3', '-', '1', '-'),
    charArrayOf('-', '4', '-', '2')
)

// Invalid 9*9 Duplicate '8' in the top-left 3×3 subgrid (row 0-2, col 0-2)
val invalidSubgridSudoku9x9 = arrayOf(
    charArrayOf('5', '8', '-', '-', '7', '-', '-', '-', '-'),
    charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
    charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),

    charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
    charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
    charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),

    charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
    charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
    charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
)

// Invalid 9x9 board with duplicate in a row
val invalidRowSudoku9x9 = arrayOf(
    charArrayOf('5', '3', '-', '-', '7', '-', '5', '-', '-'), // Duplicate '5'
    charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
    charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
    charArrayOf('-', '-', '-', '-', '6', '-', '-', '-', '-'),
    charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
    charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
    charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
    charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
    charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
)

// Invalid 16*16 Duplicate '5' in the top-left 4×4 subgrid
val invalidSubgridSudoku16x16 = arrayOf(
    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
    charArrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
    charArrayOf('9', 'A', '5', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
    charArrayOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),

    charArrayOf('2', '3', '4', '1', '6', '7', '8', '5', 'A', 'B', 'C', '9', 'E', 'F', 'G', 'D'),
    charArrayOf('6', '7', '8', '5', 'A', 'B', 'C', '9', 'E', 'F', 'G', 'D', '2', '3', '4', '1'),
    charArrayOf('A', 'B', 'C', '9', 'E', 'F', 'G', 'D', '2', '3', '4', '1', '6', '7', '8', '5'),
    charArrayOf('E', 'F', 'G', 'D', '2', '3', '4', '1', '6', '7', '8', '5', 'A', 'B', 'C', '9'),

    charArrayOf('3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E'),
    charArrayOf('7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2'),
    charArrayOf('B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6'),
    charArrayOf('F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A'),

    charArrayOf('4', '1', '2', '3', '8', '5', '6', '7', 'C', '9', 'A', 'B', 'G', 'D', 'E', 'F'),
    charArrayOf('8', '5', '6', '7', 'C', '9', 'A', 'B', 'G', 'D', 'E', 'F', '4', '1', '2', '3'),
    charArrayOf('C', '9', 'A', 'B', 'G', 'D', 'E', 'F', '4', '1', '2', '3', '8', '5', '6', '7'),
    charArrayOf('G', 'D', 'E', 'F', '4', '1', '2', '3', '8', '5', '6', '7', 'C', '9', 'A', 'B')
)

// Invalid 16x16 board with duplicate in a row
val invalidRowSudoku16x16 = arrayOf(
    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'F'), // Duplicate 'F'
    charArrayOf('G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'),
    charArrayOf('V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G'),
    charArrayOf('F', 'E', 'D', 'C', 'B', 'A', '9', '8', '7', '6', '5', '4', '3', '2', '1', 'G'),
    charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'),
    charArrayOf('H', 'G', 'F', 'E', 'D', 'C', 'B', 'A', '9', '8', '7', '6', '5', '4', '3', '2'),
    charArrayOf('J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'),
    charArrayOf('Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J'),
    charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'),
    charArrayOf('P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'),
    charArrayOf('Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6'),
    charArrayOf('6', '5', '4', '3', '2', '1', 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q'),
    charArrayOf('B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'),
    charArrayOf('Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B'),
    charArrayOf('R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7'),
    charArrayOf('7', '6', '5', '4', '3', '2', '1', 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R')
)

// Invalid 3x3 board with duplicate in a column
val invalidColumnSudoku3x3 = arrayOf(
    charArrayOf('1', '2', '3'),
    charArrayOf('3', '-', '1'), // Duplicate '3' in column 1
    charArrayOf('3', '3', '-')
)

// Invalid 4x4 board with duplicate in a column
val invalidColumnSudoku4x4 = arrayOf(
    charArrayOf('1', '2', '3', '4'),
    charArrayOf('2', '-', '4', '-'), // Duplicate '2' in column 1
    charArrayOf('3', '-', '1', '-'),
    charArrayOf('4', '-', '-', '2')
)

// Invalid 9x9 board with duplicate in a column
val invalidColumnSudoku9x9 = arrayOf(
    charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
    charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
    charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
    charArrayOf('-', '-', '-', '-', '6', '-', '-', '-', '-'),
    charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
    charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
    charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
    charArrayOf('-', '3', '-', '4', '1', '9', '-', '-', '5'), // Duplicate '3' in column 1
    charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
)
// Invalid 16x16 board with duplicate in a column
val invalidColumnSudoku16x16 = arrayOf(
    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
    charArrayOf('H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'),
    charArrayOf('X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D'),
    charArrayOf('E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'),
    charArrayOf('U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A'),
    charArrayOf('B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'),
    charArrayOf('R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7'),
    charArrayOf('8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'),
    charArrayOf('O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4'),
    charArrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'),
    charArrayOf('L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1'),
    charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'),
    charArrayOf('I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'),
    charArrayOf('Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'),
    charArrayOf('F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'),
    charArrayOf('V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'F') // Duplicate 'F' in column 15
)



// Invalid 4x4 board containing non-numeric characters
val invalidNonNumericSudoku4x4 = arrayOf(
    charArrayOf('1', 'A', '3', 'B'),
    charArrayOf('C', '2', 'D', '4'),
    charArrayOf('3', 'B', '1', 'A'),
    charArrayOf('D', '4', 'C', '2')
)

// Invalid Sudoku 8x8 Board, Not a Perfect Square
val invalid8x8Board = Array(8) { CharArray(8) { '-' } }

// invalid Sudoku board 9*9 with a non-numeric character ('X')
val invalidNonNumericSudoku9x9 = arrayOf(
    charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
    charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', 'X'),
    charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
    charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
    charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
    charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
    charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
    charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
    charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
)

// Invalid 3x3 board containing empty spaces
val invalidEmptyCharacterBoard3x3 = arrayOf(
    charArrayOf('1', ' ', '3'),
    charArrayOf(' ', '2', ' '),
    charArrayOf('3', ' ', '1')
)

// Invalid 4x4 board containing empty spaces
val invalidEmptyCharacterBoard4x4 = arrayOf(
    charArrayOf('1', ' ', '3', ' '),
    charArrayOf(' ', '2', ' ', '4'),
    charArrayOf('3', ' ', '1', ' '),
    charArrayOf(' ', '4', ' ', '2')
)

// Invalid 16x16 board containing empty spaces
val invalidEmptyCharacterBoard16x16 = arrayOf(
    charArrayOf('1', ' ', '3', ' ', '5', ' ', '7', ' ', '9', ' ', 'B', ' ', 'D', ' ', 'F', ' '),
    charArrayOf(' ', '2', ' ', '4', ' ', '6', ' ', '8', ' ', 'A', ' ', 'C', ' ', 'E', ' ', 'G'),
    charArrayOf('3', ' ', '1', ' ', '7', ' ', '5', ' ', 'B', ' ', '9', ' ', 'F', ' ', 'D', ' '),
    charArrayOf(' ', '4', ' ', '2', ' ', '8', ' ', '6', ' ', 'C', ' ', 'A', ' ', 'G', ' ', 'E'),
    charArrayOf('5', ' ', '7', ' ', '1', ' ', '3', ' ', 'D', ' ', 'F', ' ', '9', ' ', 'B', ' '),
    charArrayOf(' ', '6', ' ', '8', ' ', '2', ' ', '4', ' ', 'E', ' ', 'G', ' ', 'A', ' ', 'C'),
    charArrayOf('7', ' ', '5', ' ', '3', ' ', '1', ' ', 'F', ' ', 'D', ' ', 'B', ' ', '9', ' '),
    charArrayOf(' ', '8', ' ', '6', ' ', '4', ' ', '2', ' ', 'G', ' ', 'E', ' ', 'C', ' ', 'A'),
    charArrayOf('9', ' ', 'B', ' ', 'D', ' ', 'F', ' ', '1', ' ', '3', ' ', '5', ' ', '7', ' '),
    charArrayOf(' ', 'A', ' ', 'C', ' ', 'E', ' ', 'G', ' ', '2', ' ', '4', ' ', '6', ' ', '8'),
    charArrayOf('B', ' ', '9', ' ', 'F', ' ', 'D', ' ', '3', ' ', '1', ' ', '7', ' ', '5', ' '),
    charArrayOf(' ', 'C', ' ', 'A', ' ', 'G', ' ', 'E', ' ', '4', ' ', '2', ' ', '8', ' ', '6'),
    charArrayOf('D', ' ', 'F', ' ', '9', ' ', 'B', ' ', '5', ' ', '7', ' ', '1', ' ', '3', ' '),
    charArrayOf(' ', 'E', ' ', 'G', ' ', 'A', ' ', 'C', ' ', '6', ' ', '8', ' ', '2', ' ', '4'),
    charArrayOf('F', ' ', 'D', ' ', 'B', ' ', '9', ' ', '7', ' ', '5', ' ', '3', ' ', '1', ' '),
    charArrayOf(' ', 'G', ' ', 'E', ' ', 'C', ' ', 'A', ' ', '8', ' ', '6', ' ', '4', ' ', '2')
)

//invalid board 9*9 containing empty spaces
val invalidEmptyCharacterBoard9x9 = arrayOf(
    charArrayOf('5', '3', ' ', ' ', '7', ' ', ' ', ' ', ' '), // Spaces instead of '-'
    charArrayOf('6', ' ', ' ', '1', '9', '5', ' ', ' ', ' '),
    charArrayOf(' ', '9', '8', ' ', ' ', ' ', ' ', '6', ' '),
    charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
    charArrayOf('4', ' ', ' ', '8', ' ', '3', ' ', ' ', '1'),
    charArrayOf('7', ' ', ' ', ' ', '2', ' ', ' ', ' ', '6'),
    charArrayOf(' ', '6', ' ', ' ', ' ', ' ', '2', '8', ' '),
    charArrayOf(' ', ' ', ' ', '4', '1', '9', ' ', ' ', '5'),
    charArrayOf(' ', ' ', ' ', ' ', '8', ' ', ' ', '7', '9')
)

//invalid 16x16 Sudoku board with missing rows
val invalid16x16Sudoku = arrayOf(
    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),//missing row
    charArrayOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
    charArrayOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),

    charArrayOf('2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F'),
    charArrayOf('6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3'),
    charArrayOf('A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7'),
    charArrayOf('E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B'),

    charArrayOf('3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E'),
    charArrayOf('7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2'),
    charArrayOf('B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6'),
    charArrayOf('F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A'),

    charArrayOf('4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D'),
    charArrayOf('8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1'),
    charArrayOf('C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5'),
    charArrayOf('G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9')
)

// Invalid 3x3 board with uneven row sizes
val invalidUnevenBoard3x3 = arrayOf(
    charArrayOf('1', '2', '3'),
    charArrayOf('4', '5'), // Shorter row
    charArrayOf('7', '8', '9')
)

// Invalid 4x4 board with uneven row sizes
val invalidUnevenBoard4x4 = arrayOf(
    charArrayOf('1', '2', '3', '4'),
    charArrayOf('5', '6', '7'), // Shorter row
    charArrayOf('9', 'A', 'B', 'C'),
    charArrayOf('D', 'E', 'F', 'G')
)

// Invalid 9x9 board with uneven row sizes
val invalidUnevenBoard9x9 = arrayOf(
    charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
    charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
    charArrayOf('-', '9', '8', '-', '-', '-'), // Shorter row
    charArrayOf('-', '-', '-', '-', '6', '-', '-', '-', '-'),
    charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
    charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
    charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
    charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
    charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
)

// Invalid 16x16 board with uneven row sizes
val invalidUnevenBoard16x16 = arrayOf(
    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
    charArrayOf('H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'), // Missing one column
    charArrayOf('X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D'),
    charArrayOf('E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'),
    charArrayOf('U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A'),
    charArrayOf('B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'),
    charArrayOf('R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7'),
    charArrayOf('8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'),
    charArrayOf('O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4'),
    charArrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'),
    charArrayOf('L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1'),
    charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'),
    charArrayOf('I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'),
    charArrayOf('Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'),
    charArrayOf('F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'),
    charArrayOf('V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B')
)
//endregion

