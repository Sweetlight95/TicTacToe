package tictac;

public class TicTacToe {
    private int[][] board = new int[3][3];
    private CellValue cellValue = CellValue.EMPTY;
    private Player player = Player.PLAYER1;
    private Winner winner = Winner.DRAW;

    public int[][] getBoard() {
        return board;
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

    private void loopThroughRowsInBoard(int i) {
        for (int row = 0; row < board.length; row++) {
            loopThroughColumns(i, board[row]);
        }
    }

    private void loopThroughColumns(int index, int[] row) {
        for (int column = 0; column < row.length; column++) {
            checkConditions(index);
        }
    }

    private void checkConditions(int i) {
        if (i >= 1 && i <= 3) {
            if (board[0][(i -1 )% 3] != 0) {
                throw new IllegalArgumentException("Enter another number");
            }
        }
        if (i >= 4 && i <= 6) {
            if (board[1][(i -1 )% 3] != 0) {
                throw new IllegalArgumentException("Enter another number");
            }
        }
        if (i >= 7 && i <= 9) {
            if (board[2][(i -1 )% 3] != 0) {
                throw new IllegalArgumentException("Enter another number");
            }
        }
    }

    public void validatePlay(int i) {
        loopThroughRowsInBoard(i);
    }

    public void play(int i) {
        validatePlay(i);
        switch(player){
            case PLAYER1 ->playForPlayerOne(i);
            case PLAYER2 -> playForPlayerTwo(i);
        }
    }

    private void playForPlayerTwo(int i) {
            if (i == 1) board[0][0] = 2;
            if (i == 2) board[0][1] = 2;
            if (i == 3) board[0][2] = 2;
            if (i == 4) board[1][0] = 2;
            if (i == 5) board[1][1] = 2;
            if (i == 6) board[1][2] = 2;
            if (i == 7) board[2][0] = 2;
            if (i == 8) board[2][1] = 2;
            if (i == 9) board[2][2] = 2;
        }

    private void playForPlayerOne(int i) {
            if (i == 1) board[0][0] = 1;
            if (i == 2) board[0][1] = 1;
            if (i == 3) board[0][2] = 1;
            if (i == 4) board[1][0] = 1;
            if (i == 5) board[1][1] = 1;
            if (i == 6) board[1][2] = 1;
            if (i == 7) board[2][0] = 1;
            if (i == 8) board[2][1] = 1;
            if (i == 9) board[2][2] = 1;
    }

    public int[][] getPLayPosition() {
        return board;
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

    public void displayBoard() {
        displayTheRowsAndColumns();
    }

    private void displayTheRowsAndColumns() {
        for (int row = 0; row < board.length; row++) {
            displayTheColumns(row);
            System.out.println();
        }
    }

    private void displayTheColumns(int row) {
        for (int column = 0; column < board[row].length; column++) {
            checkDisplayConditions(row, column);

        }
    }

    private void checkDisplayConditions(int row, int column) {
            if (board[row][column] == 1) {
                System.out.print(" X |");
        }
            if (board[row][column] == 2) {
                System.out.print(" O |");
        }
        else if (board[row][column] == 0) {
            System.out.print("   |");
        }
    }


    public Player checkIfPlayerOneIsTheWinner() {
            checkConditionForPlayerIsWinner();
            if (winner == Winner.WON)return player;
            return player;
    }

    private void checkConditionForPlayerIsWinner() {
        if (rowOneIsEqualToOne() == true) winner = Winner.WON;
        else if (rowTwoIsEqualToOne() == true) winner = Winner.WON;
        else if (rowThreeIsEqualToOne() == true) winner = Winner.WON;
        else if (columnOneIsEqualToOne() == true) winner = Winner.WON;
        else if (columnTwoIsEqualToOne() == true) winner = Winner.WON;
        else if (columnThreeIsEqualToOne() == true) winner = Winner.WON;
        else if (diagonalOneIsEqualToOne() == true) winner = Winner.WON;
        else if (diagonalTwoIsEqualToOne() == true) winner = Winner.WON;
    }

    private boolean diagonalOneIsEqualToOne() {
        boolean diagonalOne = false;
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
            diagonalOne = true;
        return diagonalOne;
    }
private boolean diagonalTwoIsEqualToOne() {
        boolean diagonalTwo = false;
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
            diagonalTwo = true;
        return diagonalTwo;
    }


    private boolean rowOneIsEqualToOne() {
        int numberOfOnes=0;
        boolean rowIsEqualToOne = false;
            for (int column = 0; column < board[0].length; column++) {
                if(board[0][column]==1) numberOfOnes+=1;
            }
            if (numberOfOnes ==3) rowIsEqualToOne=true;
            return rowIsEqualToOne;
    }

    private boolean rowTwoIsEqualToOne() {
        int numberOfOnes=0;
        boolean rowIsEqualToOne = false;
        for (int column = 0; column < board[1].length; column++) {
            if(board[1][column]==1) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) rowIsEqualToOne=true;
        return rowIsEqualToOne;
    }

    private boolean rowThreeIsEqualToOne() {
        int numberOfOnes=0;
        boolean rowIsEqualToOne = false;
        for (int column = 0; column < board[2].length; column++) {
            if(board[2][column]==1) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) rowIsEqualToOne=true;
        return rowIsEqualToOne;
    }
    private boolean columnOneIsEqualToOne() {
        int numberOfOnes=0;
        boolean columnIsEqualToOne = false;
        for (int row = 0; row < board[0].length; row++) {
            if(board[row][0]==1) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) columnIsEqualToOne=true;
        return columnIsEqualToOne;
    }
    private boolean columnTwoIsEqualToOne() {
        int numberOfOnes=0;
        boolean columnIsEqualToOne = false;
        for (int row = 0; row < board[1].length; row++) {
            if(board[row][1]==1) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) columnIsEqualToOne=true;
        return columnIsEqualToOne;
    }
    private boolean columnThreeIsEqualToOne() {
        int numberOfOnes=0;
        boolean columnIsEqualToOne = false;
        for (int row = 0; row < board[2].length; row++) {
            if(board[row][2]==1) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) columnIsEqualToOne=true;
        return columnIsEqualToOne;
    }
    public void checkIfPlayerTwoIsTheWinner() {
        if(player == Player.PLAYER2) {
            checkConditionForPlayerTwoIsWinner();
        }
    }

    private void checkConditionForPlayerTwoIsWinner() {
        if (rowOneIsEqualToOneForPlayer2() == true) winner = Winner.WON;
        else if (rowTwoIsEqualToOneForPlayer2() == true) winner = Winner.WON;
        else if (rowThreeIsEqualToOneForPlayer2() == true) winner = Winner.WON;
        else if (columnOneIsEqualToOneForPlayer2() == true) winner = Winner.WON;
        else if (columnTwoIsEqualToOneForPlayer2() == true) winner = Winner.WON;
        else if (columnThreeIsEqualToOneForPlayer2() == true) winner = Winner.WON;
        else if (diagonalOneIsEqualToOne() == true) winner = Winner.WON;
        else if (diagonalTwoIsEqualToOne() == true) winner = Winner.WON;
    }


    private boolean rowOneIsEqualToOneForPlayer2() {
        int numberOfOnes=0;
        boolean rowIsEqualToOne = false;
            for (int column = 0; column < board[0].length; column++) {
                if(board[0][column]==2) numberOfOnes+=1;
            }
            if (numberOfOnes ==3) rowIsEqualToOne=true;
            return rowIsEqualToOne;
    }

    private boolean rowTwoIsEqualToOneForPlayer2() {
        int numberOfOnes=0;
        boolean rowIsEqualToOne = false;
        for (int column = 0; column < board[1].length; column++) {
            if(board[1][column]==2) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) rowIsEqualToOne=true;
        return rowIsEqualToOne;
    }

    private boolean rowThreeIsEqualToOneForPlayer2() {
        int numberOfOnes=0;
        boolean rowIsEqualToOne = false;
        for (int column = 0; column < board[2].length; column++) {
            if(board[2][column]==2) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) rowIsEqualToOne=true;
        return rowIsEqualToOne;
    }
    private boolean columnOneIsEqualToOneForPlayer2() {
        int numberOfOnes=0;
        boolean columnIsEqualToOne = false;
        for (int row = 0; row < board[0].length; row++) {
            if(board[row][0]==2) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) columnIsEqualToOne=true;
        return columnIsEqualToOne;
    }
    private boolean columnTwoIsEqualToOneForPlayer2() {
        int numberOfOnes=0;
        boolean columnIsEqualToOne = false;
        for (int row = 0; row < board[1].length; row++) {
            if(board[row][1]==2) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) columnIsEqualToOne=true;
        return columnIsEqualToOne;
    }
    private boolean columnThreeIsEqualToOneForPlayer2() {
        int numberOfOnes=0;
        boolean columnIsEqualToOne = false;
        for (int row = 0; row < board[2].length; row++) {
            if(board[row][2]==2) numberOfOnes+=1;
        }
        if (numberOfOnes ==3) columnIsEqualToOne=true;
        return columnIsEqualToOne;
    }
    public Winner getWinner() {
        return winner;
    }

    public Player checkWinner() {
        if (winner != Winner.WON){
            checkIfPlayerOneIsTheWinner();
            return player;
        }
        else{
            checkIfPlayerTwoIsTheWinner();
        }
        return player;
    }
}