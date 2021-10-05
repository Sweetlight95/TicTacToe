package tictac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        int[][] newTicTacToe = ticTacToe.getBoard();
//    assert
        for (int[] ints : newTicTacToe) {
            for (int anInt : ints) {
                assertEquals(0, anInt);
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
    void testThatTicTacToeCanDisplayWhenPlayerOnePlays() {
        ticTacToe.play(1);
        assertEquals(PLAYER2, ticTacToe.getPlayer());
    }

    @Test
    void testThatNoPlayerCanPlayAtTheSamePositionTwice(){
        //give//whenn
        ticTacToe.play(1);
        //assert
        assertThrows(IllegalArgumentException.class,()->ticTacToe.play(1));
    }
    @Test
    void testThatWinnerCanBeDeterminedAtRow1ForPlayerTwo() {
        ticTacToe.play(5);
        ticTacToe.play(1);
        ticTacToe.play(4);
        ticTacToe.play(2);
        ticTacToe.play(7);
        ticTacToe.play(3);
        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
@Test
    void testThatWinnerCanBeDeterminedAtRow2ForPlayerTwo() {
        ticTacToe.play(9);
        ticTacToe.play(6);
        ticTacToe.play(1);
        ticTacToe.play(5);
        ticTacToe.play(2);
        ticTacToe.play(4);


        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }

    @Test
    void testThatWinnerCanBeDeterminedAtRow3ForPlayerTwo() {
        ticTacToe.play(2);
        ticTacToe.play(9);
        ticTacToe.play(3);
        ticTacToe.play(7);
        ticTacToe.play(6);
        ticTacToe.play(8);


        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtColumn1ForPlayerTwo() {
        ticTacToe.play(2);
        ticTacToe.play(7);
        ticTacToe.play(8);
        ticTacToe.play(1);
        ticTacToe.play(5);
        ticTacToe.play(4);


        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtColumn2ForPlayerTwo() {
        ticTacToe.play(1);
        ticTacToe.play(2);
        ticTacToe.play(9);
        ticTacToe.play(8);
        ticTacToe.play(7);
        ticTacToe.play(5);


        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtColumn3ForPlayerTwo() {
        ticTacToe.play(1);
        ticTacToe.play(6);
        ticTacToe.play(4);
        ticTacToe.play(9);
        ticTacToe.play(2);
        ticTacToe.play(3);


        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtDiagonal1ForPlayerTwo() {
        ticTacToe.play(6);
        ticTacToe.play(3);
        ticTacToe.play(1);
        ticTacToe.play(5);
        ticTacToe.play(8);
        ticTacToe.play(7);


        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }

    @Test
    void testThatWinnerCanBeDeterminedAtDiagonal2ForPlayerTwo() {
        ticTacToe.play(6);
        ticTacToe.play(1);
        ticTacToe.play(7);
        ticTacToe.play(5);
        ticTacToe.play(8);
        ticTacToe.play(9);


        ticTacToe.checkIfPlayerTwoIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtRow1() {
        ticTacToe.play(1);
        ticTacToe.play(2);
        ticTacToe.play(4);
        ticTacToe.play(5);
        ticTacToe.play(7);
        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
@Test
    void testThatWinnerCanBeDeterminedAtRow2() {
        ticTacToe.play(8);
        ticTacToe.play(9);
        ticTacToe.play(5);
        ticTacToe.play(1);
        ticTacToe.play(2);


        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }

    @Test
    void testThatWinnerCanBeDeterminedAtRow3() {
        ticTacToe.play(9);
        ticTacToe.play(2);
        ticTacToe.play(3);
        ticTacToe.play(7);
        ticTacToe.play(6);


        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtColumn1() {
        ticTacToe.play(7);
        ticTacToe.play(2);
        ticTacToe.play(1);
        ticTacToe.play(8);
        ticTacToe.play(4);


        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtColumn2() {
        ticTacToe.play(2);
        ticTacToe.play(1);
        ticTacToe.play(8);
        ticTacToe.play(9);
        ticTacToe.play(5);


        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtColumn3() {
        ticTacToe.play(6);
        ticTacToe.play(1);
        ticTacToe.play(9);
        ticTacToe.play(4);
        ticTacToe.play(3);


        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }
    @Test
    void testThatWinnerCanBeDeterminedAtDiagonal1() {
        ticTacToe.play(3);
        ticTacToe.play(6);
        ticTacToe.play(5);
        ticTacToe.play(1);
        ticTacToe.play(7);


        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }

    @Test
    void testThatWinnerCanBeDeterminedAtDiagonal2() {
        ticTacToe.play(1);
        ticTacToe.play(6);
        ticTacToe.play(5);
        ticTacToe.play(7);
        ticTacToe.play(9);


        ticTacToe.checkIfPlayerOneIsTheWinner();
        ticTacToe.displayBoard();
        assertEquals(Winner.WON, ticTacToe.getWinner());
    }



    @Test
    void testThatWinnerCanBeDetermined() {
        ticTacToe.play(4);
        ticTacToe.play(1);
        ticTacToe.play(6);
        ticTacToe.play(2);
        ticTacToe.play(5);
        ticTacToe.play(3);

        ticTacToe.displayBoard();

        assertEquals(PLAYER2,ticTacToe.checkWinner());
    }
    @Test
    void testThatGameCanEnd() {

        ticTacToe.play(4);
        ticTacToe.play(1);
        ticTacToe.play(6);
        ticTacToe.play(2);
        ticTacToe.play(5);
        ticTacToe.play(3);

        ticTacToe.displayBoard();

        assertEquals(PLAYER2, ticTacToe.checkWinner());

    }

}


