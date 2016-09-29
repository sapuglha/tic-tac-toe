package com.example.tictactoe;

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
     * - - -
     * - - -
     *
     * @throws Exception
     */
    @Test
    public void row0_hasWinner() throws Exception {
        GameStatus game = new GameStatus();

        assertTrue(game.play(0, 0, PlayerType.X));
        assertFalse(game.checkForWinner(0, 0, PlayerType.X));

        assertTrue(game.play(0, 1, PlayerType.X));
        assertFalse(game.checkForWinner(0, 1, PlayerType.X));

        assertTrue(game.play(0, 2, PlayerType.X));
        assertTrue(game.checkForWinner(0, 2, PlayerType.X));

        System.out.println(game.toString());
    }

    /**
     * Game:
     * X - -
     * X - -
     * X - -
     *
     * @throws Exception
     */
    @Test
    public void column0_hasWinner() throws Exception {
        GameStatus game = new GameStatus();

        assertTrue(game.play(0, 0, PlayerType.X));
        assertFalse(game.checkForWinner(0, 0, PlayerType.X));

        assertTrue(game.play(1, 0, PlayerType.X));
        assertFalse(game.checkForWinner(1, 0, PlayerType.X));

        assertTrue(game.play(2, 0, PlayerType.X));
        assertTrue(game.checkForWinner(2, 0, PlayerType.X));

        System.out.println(game.toString());
    }

    /**
     * Game:
     * - X -
     * - X -
     * - X -
     *
     * @throws Exception
     */
    @Test
    public void column1_hasWinner() throws Exception {
        GameStatus game = new GameStatus();

        assertTrue(game.play(0, 1, PlayerType.X));
        assertFalse(game.checkForWinner(0, 1, PlayerType.X));

        assertTrue(game.play(1, 1, PlayerType.X));
        assertFalse(game.checkForWinner(1, 1, PlayerType.X));

        assertTrue(game.play(2, 1, PlayerType.X));
        assertTrue(game.checkForWinner(2, 1, PlayerType.X));

        System.out.println(game.toString());
    }

    /**
     * Game:
     * X - -
     * - X -
     * - - X
     *
     * @throws Exception
     */
    @Test
    public void diagonal00_hasWinner() throws Exception {
        GameStatus game = new GameStatus();

        assertTrue(game.play(0, 0, PlayerType.X));
        assertFalse(game.checkForWinner(0, 0, PlayerType.X));

        assertTrue(game.play(1, 1, PlayerType.X));
        assertFalse(game.checkForWinner(1, 1, PlayerType.X));

        assertTrue(game.play(2, 2, PlayerType.X));
        assertTrue(game.checkForWinner(2, 2, PlayerType.X));

        System.out.println(game.toString());
    }

    /**
     * Game:
     * - - X
     * - X -
     * X - -
     *
     * @throws Exception
     */
    @Test
    public void diagonal02_hasWinner() throws Exception {
        GameStatus game = new GameStatus();

        assertTrue(game.play(0, 2, PlayerType.X));
        assertFalse(game.checkForWinner(0, 2, PlayerType.X));

        assertTrue(game.play(1, 1, PlayerType.X));
        assertFalse(game.checkForWinner(1, 1, PlayerType.X));

        assertTrue(game.play(2, 0, PlayerType.X));
        assertTrue(game.checkForWinner(2, 0, PlayerType.X));

        System.out.println(game.toString());
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
        GameStatus game = new GameStatus();

        assertTrue(game.play(0, 0, PlayerType.X));
        assertFalse(game.checkForWinner(0, 0, PlayerType.X));

        assertTrue(game.play(1, 1, PlayerType.O));
        assertFalse(game.checkForWinner(1, 1, PlayerType.O));

        assertTrue(game.play(2, 0, PlayerType.X));
        assertFalse(game.checkForWinner(2, 0, PlayerType.X));

        assertTrue(game.play(1, 0, PlayerType.O));
        assertFalse(game.checkForWinner(1, 0, PlayerType.O));

        assertTrue(game.play(0, 2, PlayerType.X));
        assertFalse(game.checkForWinner(0, 2, PlayerType.X));

        assertTrue(game.play(2, 2, PlayerType.O));
        assertFalse(game.checkForWinner(2, 2, PlayerType.O));

        assertTrue(game.play(0, 1, PlayerType.X));
        assertTrue(game.checkForWinner(0, 1, PlayerType.X));

        System.out.println(game.toString());
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
        GameStatus game = new GameStatus();

        assertTrue(game.play(0, 2, PlayerType.X));
        assertFalse(game.play(0, 2, PlayerType.O));

        System.out.println(game.toString());
    }
}