package com.sapuglha.tictactoe;

import com.sapuglha.tictactoe.controller.GameStatusHandler;
import com.sapuglha.tictactoe.model.Board;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for game status validation
 */
public class GameStatusUnitTest {
    /**
     * Game:
     * X X X
     * O O -
     * - - -
     *
     * @throws Exception
     */
    @Test
    public void row0_hasWinner() {
        Board board = new Board();
        GameStatusHandler game = new GameStatusHandler(board);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(1, 0)); // O

        assertFalse(game.play(0, 1)); // X

        assertFalse(game.play(1, 1)); // O

        assertTrue(game.play(0, 2)); // X

        System.out.println(board.getMatrix());
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
    public void column0_hasWinner() {
        Board board = new Board();
        GameStatusHandler game = new GameStatusHandler(board);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(0, 1)); // O

        assertFalse(game.play(1, 0)); // X

        assertFalse(game.play(1, 1)); // O

        assertTrue(game.play(2, 0)); // X

        System.out.println(board.getMatrix());
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
    public void column1_hasWinner() {
        Board board = new Board();
        GameStatusHandler game = new GameStatusHandler(board);

        assertFalse(game.play(0, 1)); // X

        assertFalse(game.play(0, 2)); // O

        assertFalse(game.play(1, 1)); // X

        assertFalse(game.play(1, 2)); // O

        assertTrue(game.play(2, 1)); // X

        System.out.println(board.getMatrix());
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
    public void diagonal00_hasWinner() {
        Board board = new Board();
        GameStatusHandler game = new GameStatusHandler(board);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(0, 2)); // O

        assertFalse(game.play(1, 1)); // X

        assertFalse(game.play(2, 0)); // O

        assertTrue(game.play(2, 2)); // X

        System.out.println(board.getMatrix());
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
    public void diagonal02_hasWinner() {
        Board board = new Board();
        GameStatusHandler game = new GameStatusHandler(board);

        assertFalse(game.play(0, 2)); // X

        assertFalse(game.play(0, 0)); // O

        assertFalse(game.play(1, 1)); // X

        assertFalse(game.play(2, 2)); // O

        assertTrue(game.play(2, 0)); // X

        System.out.println(board.getMatrix());
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
    public void bigGame_hasWinner() {
        Board board = new Board();
        GameStatusHandler game = new GameStatusHandler(board);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(1, 1)); // O

        assertFalse(game.play(2, 0)); // X

        assertFalse(game.play(1, 0)); // O

        assertFalse(game.play(0, 2)); // X

        assertFalse(game.play(2, 2)); // O

        assertTrue(game.play(0, 1)); // X

        System.out.println(board.getMatrix());
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
    public void stateCheck_samePosition() {
        Board board = new Board();
        GameStatusHandler game = new GameStatusHandler(board);

        assertFalse(game.play(0, 2)); // X

        assertFalse(game.play(0, 2)); // O

        System.out.println(board.getMatrix());
    }
}