package tictac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static tictac.Player.PLAYER2;

class TicTacToeTest {
    TicTacToe ticTacToe;
    CellValue cellValue;

    @BeforeEach
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void testThat3By3Array() {
//    when
        int[][] newTicTacToe = ticTacToe.getTicTacToeArray();
//    assert
        for (int row = 0; row < newTicTacToe.length; row++) {
            for (int column = 0; column < newTicTacToe[row].length; column++) {
                assertEquals(0, newTicTacToe[row][column]);
            }

        }
    }

    @Test
    void testEnumCellValueArrayX() {
//    When
        ticTacToe.setCellValue(cellValue.X);
//    assert
        assertSame(CellValue.X, ticTacToe.getCellValue());
    }

    @Test
    void testEnumCellValueArrayO() {
//    When
        ticTacToe.setCellValue(cellValue.O);
//    assert
        assertSame(CellValue.O, ticTacToe.getCellValue());
    }

    @Test
    void testEnumCellValueArrayEMPTY() {
//    When
        ticTacToe.setCellValue(cellValue.EMPTY);
//    assert
        assertSame(CellValue.EMPTY, ticTacToe.getCellValue());
    }

    @Test
    void testThatTheirAreTwoPlayers() {
        Player player = Player.PLAYER1;
        ticTacToe.setPlayers(player);
        assertSame(Player.PLAYER1, ticTacToe.getPlayer());
    }

    @Test
    void testThatYouCanSwitchPLayers(){
        ticTacToe.switchPlayer();
        assertSame(PLAYER2, ticTacToe.getPLayer());
        ticTacToe.switchPlayer();
        assertSame(Player.PLAYER1, ticTacToe.getPLayer());
    }

    @Test
    void testThatTicTacToeCanDisplayWhenPlayerOnePlays(){
        ticTacToe.play(1);
        ticTacToe.switchPlayer();
        assertEquals(PLAYER2, ticTacToe.getPlayer());
        //ticTacToe.play(2);
        //ticTacToe.displayArray();
    }

    @Test
    void testThatNoPlayerCanPlayAtTheSamePositionTwice(){
        //give//whenn
        ticTacToe.play(1);
        //assert
        assertThrows(IllegalArgumentException.class,()->ticTacToe.play(1));
    }
    @Test
    void testThatWinnerCanBeDetermine() {
        ticTacToe.play(1);
        ticTacToe.play(4);
        ticTacToe.play(7);
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }

}

