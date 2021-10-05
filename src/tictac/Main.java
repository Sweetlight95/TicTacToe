package tictac;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Player player1 = ticTacToe.getPlayer();
        Winner winner = ticTacToe.getWinner();

        while(winner != Winner.WON){
            System.out.println("Enter number");
            int number = scanner.nextInt();

            ticTacToe.play(number);
            System.out.println(ticTacToe.getPlayer());
            ticTacToe.checkWinner();
        }
    }
}
