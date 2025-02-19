package Ex1;

public class Board implements JGaloInterface {
    
    char player1;
    char player2;
    char[][] board;
    char actualPlayer;
    int numPlays;

    public Board() {
        player1 = 'X';
        player2 = 'O';
        board = new char[3][3];
        actualPlayer = player1;
        numPlays = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public char getActualPlayer() {
        return actualPlayer;
    }
    public boolean setJogada(int lin, int col) {
        if (board[lin-1][col-1] == ' ') {
            board[lin-1][col-1] = actualPlayer;
            numPlays++;
            if (actualPlayer == player1) {
                actualPlayer = player2;
            } else {
                actualPlayer = player1;
            }
            return true;
        }
        return false;
    }
    public boolean isFinished() {
        if (numPlays >= 9) {
            return true;
        }
        return false;
    }
    public char checkResult() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) { // Vitória na horizontal
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) { // Vitória na vertical
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) { // Vitória na diagonal 
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) { // Vitória na diagonal
            return board[0][2];
        }
        return ' ';
    }
}
