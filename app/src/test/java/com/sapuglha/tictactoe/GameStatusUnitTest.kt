package com.sapuglha.tictactoe

import com.sapuglha.tictactoe.controller.GameStatusHandler
import com.sapuglha.tictactoe.model.Board
import com.sapuglha.tictactoe.model.PlayerType

import org.junit.Test

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

/**
 * Tests for game status validation
 */
class GameStatusUnitTest {

    private fun boardToMatrix(board: Array<Array<PlayerType?>>): String {
        val matrix = StringBuilder()
        for (i in 0 until Board.MATRIX_SIZE) {
            for (j in 0 until Board.MATRIX_SIZE) {
                if (null != board!![i][j]) {
                    matrix.append(board!![i][j].toString())
                } else {
                    matrix.append("-")
                }
                matrix.append(" ")
            }
            matrix.append('\n')
        }
        return matrix.toString()
    }

    /**
     * Game:
     * X X X
     * O O -
     * - - -
     *
     * @throws Exception
     */
    @Test
    fun row0_hasWinner() {
        val board = Board()
        val game = GameStatusHandler(board)

        assertFalse(game.play(0, 0)) // X

        assertFalse(game.play(1, 0)) // O

        assertFalse(game.play(0, 1)) // X

        assertFalse(game.play(1, 1)) // O

        assertTrue(game.play(0, 2)) // X

        println(boardToMatrix(board.matrix))
    }

    /**
     * Game:
     * X O -
     * X O -
     * X - -
     *
     * @throws Exception
     */
    @Test
    fun column0_hasWinner() {
        val board = Board()
        val game = GameStatusHandler(board)

        assertFalse(game.play(0, 0)) // X

        assertFalse(game.play(0, 1)) // O

        assertFalse(game.play(1, 0)) // X

        assertFalse(game.play(1, 1)) // O

        assertTrue(game.play(2, 0)) // X

        println(boardToMatrix(board.matrix))
    }

    /**
     * Game:
     * - X O
     * - X O
     * - X -
     *
     * @throws Exception
     */
    @Test
    fun column1_hasWinner() {
        val board = Board()
        val game = GameStatusHandler(board)

        assertFalse(game.play(0, 1)) // X

        assertFalse(game.play(0, 2)) // O

        assertFalse(game.play(1, 1)) // X

        assertFalse(game.play(1, 2)) // O

        assertTrue(game.play(2, 1)) // X

        println(boardToMatrix(board.matrix))
    }

    /**
     * Game:
     * X - O
     * - X -
     * O - X
     *
     * @throws Exception
     */
    @Test
    fun diagonal00_hasWinner() {
        val board = Board()
        val game = GameStatusHandler(board)

        assertFalse(game.play(0, 0)) // X

        assertFalse(game.play(0, 2)) // O

        assertFalse(game.play(1, 1)) // X

        assertFalse(game.play(2, 0)) // O

        assertTrue(game.play(2, 2)) // X

        println(boardToMatrix(board.matrix))
    }

    /**
     * Game:
     * O - X
     * - X -
     * X - O
     *
     * @throws Exception
     */
    @Test
    fun diagonal02_hasWinner() {
        val board = Board()
        val game = GameStatusHandler(board)

        assertFalse(game.play(0, 2)) // X

        assertFalse(game.play(0, 0)) // O

        assertFalse(game.play(1, 1)) // X

        assertFalse(game.play(2, 2)) // O

        assertTrue(game.play(2, 0)) // X

        println(boardToMatrix(board.matrix))
    }


    /**
     * Game:
     * X X X
     * O O -
     * X - O
     *
     * @throws Exception
     */
    @Test
    fun bigGame_hasWinner() {
        val board = Board()
        val game = GameStatusHandler(board)

        assertFalse(game.play(0, 0)) // X

        assertFalse(game.play(1, 1)) // O

        assertFalse(game.play(2, 0)) // X

        assertFalse(game.play(1, 0)) // O

        assertFalse(game.play(0, 2)) // X

        assertFalse(game.play(2, 2)) // O

        assertTrue(game.play(0, 1)) // X

        println(boardToMatrix(board.matrix))
    }

    /**
     * Game:
     * - - X
     * - - -
     * - - -
     *
     * @throws Exception
     */
    @Test
    fun stateCheck_samePosition() {
        val board = Board()
        val game = GameStatusHandler(board)

        assertFalse(game.play(0, 2)) // X

        assertFalse(game.play(0, 2)) // O

        println(boardToMatrix(board.matrix))
    }
}