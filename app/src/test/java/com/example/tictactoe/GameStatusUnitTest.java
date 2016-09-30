package com.example.tictactoe;

import com.example.tictactoe.controller.GameStatusHandler;
import com.example.tictactoe.model.GameStatus;
import com.example.tictactoe.model.PlayerType;

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
    public void row0_hasWinner() throws Exception {
        GameStatus gameStatus = new GameStatus();
        GameStatusHandler game = new GameStatusHandler(gameStatus);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(1, 0)); // O

        assertFalse(game.play(0, 1)); // X

        assertFalse(game.play(1, 1)); // O

        assertTrue(game.play(0, 2)); // X

        System.out.println(gameStatus.toString());
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
    public void column0_hasWinner() throws Exception {
        GameStatus gameStatus = new GameStatus();
        GameStatusHandler game = new GameStatusHandler(gameStatus);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(0, 1)); // O

        assertFalse(game.play(1, 0)); // X

        assertFalse(game.play(1, 1)); // O

        assertTrue(game.play(2, 0)); // X

        System.out.println(gameStatus.toString());
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
    public void column1_hasWinner() throws Exception {
        GameStatus gameStatus = new GameStatus();
        GameStatusHandler game = new GameStatusHandler(gameStatus);

        assertFalse(game.play(0, 1)); // X

        assertFalse(game.play(0, 2)); // O

        assertFalse(game.play(1, 1)); // X

        assertFalse(game.play(1, 2)); // O

        assertTrue(game.play(2, 1)); // X

        System.out.println(gameStatus.toString());
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
    public void diagonal00_hasWinner() throws Exception {
        GameStatus gameStatus = new GameStatus();
        GameStatusHandler game = new GameStatusHandler(gameStatus);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(0, 2)); // O

        assertFalse(game.play(1, 1)); // X

        assertFalse(game.play(2, 0)); // O

        assertTrue(game.play(2, 2)); // X

        System.out.println(gameStatus.toString());
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
    public void diagonal02_hasWinner() throws Exception {
        GameStatus gameStatus = new GameStatus();
        GameStatusHandler game = new GameStatusHandler(gameStatus);

        assertFalse(game.play(0, 2)); // X

        assertFalse(game.play(0, 0)); // O

        assertFalse(game.play(1, 1)); // X

        assertFalse(game.play(2, 2)); // O

        assertTrue(game.play(2, 0)); // X

        System.out.println(gameStatus.toString());
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
    public void bigGame_hasWinner() throws Exception {
        GameStatus gameStatus = new GameStatus();
        GameStatusHandler game = new GameStatusHandler(gameStatus);

        assertFalse(game.play(0, 0)); // X

        assertFalse(game.play(1, 1)); // O

        assertFalse(game.play(2, 0)); // X

        assertFalse(game.play(1, 0)); // O

        assertFalse(game.play(0, 2)); // X

        assertFalse(game.play(2, 2)); // O

        assertTrue(game.play(0, 1)); // X

        System.out.println(gameStatus.toString());
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
    public void stateCheck_samePosition() throws Exception {
        GameStatus gameStatus = new GameStatus();
        GameStatusHandler game = new GameStatusHandler(gameStatus);

        assertFalse(game.play(0, 2)); // X

        assertFalse(game.play(0, 2)); // O

        System.out.println(gameStatus.toString());
    }
}