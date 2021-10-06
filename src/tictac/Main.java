package tictac;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Player player = ticTacToe.getPLayer();
        Winner winner = ticTacToe.getWinner();

        while(winner != Winner.WON){
            System.out.println(player + " Enter number");
            int number = scanner.nextInt();

            ticTacToe.play(number);
            ticTacToe.switchPlayer();
            ticTacToe
            ticTacToe.displayBoard();
            ticTacToe.checkWinner();
        }


    }
}
