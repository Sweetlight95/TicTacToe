package tictac;

public class TicTacToe {
    private int[][] ticTacToeArray = new int[3][3];
    private CellValue cellValue = CellValue.EMPTY;
    private Player player = Player.PLAYER1;
    private Winner winner = Winner.DRAW;

    public int[][] getTicTacToeArray() {
        return ticTacToeArray;
    }

    public void setCellValue(CellValue cellValue) {
        this.cellValue = cellValue;
    }

    public CellValue getCellValue() {
        return cellValue;
    }

    public void setPlayers(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void validatePlay(int i) {

        for (int row = 0; row < ticTacToeArray.length; row++) {
            for (int column = 0; column < ticTacToeArray[row].length; column++) {
                if (i >= 1 && i <= 3) {
                    if (ticTacToeArray[0][i - 1] != 0) {
                        throw new IllegalArgumentException("Enter another number");
                    }
                }
                if (i >= 4 && i <= 6) {
                    if (ticTacToeArray[1][i % 3 - 1] != 0) {
                        throw new IllegalArgumentException("Enter another number");
                    }
                }
                if (i >= 7 && i <= 9) {
                    if (ticTacToeArray[2][i % 3 - 1] != 0) {
                        throw new IllegalArgumentException("Enter another number");
                    }
                }
            }
        }
    }

    public void play(int i) {
        validatePlay(i);
        if (player == Player.PLAYER1) {
            if (i == 1) ticTacToeArray[0][0] = 1;
            if (i == 2) ticTacToeArray[0][1] = 1;
            if (i == 3) ticTacToeArray[0][2] = 1;
            if (i == 4) ticTacToeArray[1][0] = 1;
            if (i == 5) ticTacToeArray[1][1] = 1;
            if (i == 6) ticTacToeArray[1][2] = 1;
            if (i == 7) ticTacToeArray[2][0] = 1;
            if (i == 8) ticTacToeArray[2][1] = 1;
            if (i == 9) ticTacToeArray[2][2] = 1;
        }
        if (player == Player.PLAYER2) {
            if (i == 1) ticTacToeArray[0][0] = 2;
            if (i == 2) ticTacToeArray[0][1] = 2;
            if (i == 3) ticTacToeArray[0][2] = 2;
            if (i == 4) ticTacToeArray[1][0] = 2;
            if (i == 5) ticTacToeArray[1][1] = 2;
            if (i == 6) ticTacToeArray[1][2] = 2;
            if (i == 7) ticTacToeArray[2][0] = 2;
            if (i == 8) ticTacToeArray[2][1] = 2;
            if (i == 9) ticTacToeArray[2][2] = 2;
        }
        switchPlayer();

    }

    public int[][] getPLayPosition() {
        return ticTacToeArray;
    }

    public void switchPlayer() {
        if (player == Player.PLAYER1) {
            player = Player.PLAYER2;
        } else if (player == Player.PLAYER2) {
            player = Player.PLAYER1;

        }
    }

    public Player getPLayer() {
        return player;
    }

    public void displayArray() {
        for (int row = 0; row < ticTacToeArray.length; row++) {
            for (int column = 0; column < ticTacToeArray[row].length; column++) {
                if (ticTacToeArray[row][column] == 1) {
                    System.out.print("X |");
                }
                if (ticTacToeArray[row][column] == 2) {
                    System.out.print("O |");
                }
                if (ticTacToeArray[row][column] == 0) {
                    System.out.print("  |");
                }

            }
            System.out.println();
        }
    }

    public Winner getWinner() {
       for (int row [] : ticTacToeArray){
           if (row[0] == row[1] && row[0] == row[2] ){
               winner = Winner.WON;
           }
       }
       for (int row = 0; row< ticTacToeArray.length; row++){
           for (int column = 0; column< ticTacToeArray[row].length; column++) {
               if (ticTacToeArray[row][0] == ticTacToeArray[row][1] && ticTacToeArray[row][2] == ticTacToeArray[row][0]){
                   winner = Winner.WON;
               }
           }
        }

    }
}