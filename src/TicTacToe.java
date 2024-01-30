import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner scanner = new Scanner(System.in);
    char[][] board = {{' ', ' ', ' '},
                      {' ', ' ', ' '},
                      {' ', ' ', ' '}};
    public TicTacToe(){
        while(isFinished(board) == -1) {
            PlayerMove(scanner, board);
            if(isFinished(board) == 0){
                Printboard(board);
                System.out.println("\nPlayer wins");
                break;
            }
            else if(isFinished(board) == 2){
                Printboard(board);
                System.out.println("\nits a tie!");
            }
            ComputerMove(board);
            if(isFinished(board) == 1){
                Printboard(board);
                System.out.println("\nComputer wins");
                break;
            }
            Printboard(board);
        }
        scanner.close();
        System.exit(0);
    }

    public static void Printboard(char[][] board){
        for(int i = 0; i<3; i++){
            System.out.println();
            if(i != 0)System.out.println("_ _ _");
            for(int j = 0; j<3; j++){
                if(j == 1 || j == 2) System.out.print("|");
                System.out.print(board[i][j]);
            }
        }
    }
    public static void PlayerMove(Scanner scanner, char[][] board){
        int userMove;
        while(true) {
            System.out.println("\nPlease enter a number between (1-9)");
            userMove = scanner.nextInt();
            if (Check(board, userMove)) break;
            else System.out.print("try again, that space is already taken");

        }
        Place(board, userMove, 'X');
    }
    public static void ComputerMove(char[][] board){
        Random random = new Random();
        int computerMove = random.nextInt(9) + 1;
        while(!Check(board, computerMove)) {
            computerMove = random.nextInt(9) + 1;
        }
        Place(board, computerMove, 'O');
    }
    public static void Place(char[][] board, int input, char symbol){
        int count = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++) {
                count++;
                if (input == count){
                    board[i][j] = symbol;
                }
            }
        }
    }
    public static boolean Check(char[][] board, int input){
        int count = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++) {
                count++;
                if (input == count){
                    if(board[i][j] == ' '){
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static int isFinished(char[][] board){
        char symbol = 'X';
        for(int i = 0; i<2; i++) {
            //horizontol
            if (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) return i;
            else if (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) return i;
            else if (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) return i;
                //vertical
            else if (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) return i;
            else if (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) return i;
            else if (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) return i;
                //diagnal
            else if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return i;
            else if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return i;
            symbol = 'O';
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(board[i][j] == ' ') return -1;
            }
        }
        return 2;
    }
}
