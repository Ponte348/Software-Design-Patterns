public class JGaloStatus implements JGaloInterface{
    final int PLAYER1 = 0;
    final int PLAYER2 = 1;
    final int NPLAYERS = 2;
    final int NROWS = 3;
    final int NCOLUMNS = 3;
    final char UNOCCUPIED = ' ';

    private Character[] playerList;
    private Integer currentTurn;
    private Character[][] board;
    private Character result;
    private Integer nTurns;

    /**
     * Makes class with values by default
     */
    JGaloStatus(){
        this.result = ' ';
        this.nTurns = 0;
        this.playerList = new Character[NPLAYERS];
        playerList[PLAYER1] = 'X';
        playerList[PLAYER2] = 'O';
        this.currentTurn = PLAYER1;
        this.board = new Character[NROWS][NCOLUMNS];
        for (int row = 0; row < NROWS; row++){
            for (int column = 0; column < NCOLUMNS; column++){
                board[row][column] = UNOCCUPIED;
            }
        } 
    }

    /**
     * Makes class with the starting player
     * @param startingPlayer
     */
    
    JGaloStatus(char startingPlayer) {
        this.result = ' ';
        this.nTurns = 0;
        this.playerList = new Character[NPLAYERS];
        playerList[PLAYER1] = startingPlayer;
        playerList[PLAYER2] = (startingPlayer == 'X') ? 'O' : 'X';
        this.currentTurn = PLAYER1;
        this.board = new Character[NROWS][NCOLUMNS];
        for (int row = 0; row < NROWS; row++){
            for (int column = 0; column < NCOLUMNS; column++){
                board[row][column] = UNOCCUPIED;
            }
        } 
    }
    /**
     * Gets the current player
     * @return char - current player
     */
    @Override
    public char getActualPlayer() {
        return playerList[currentTurn];
    }
    /**
     * Current player turn to play, play
     * @param lin - line
     * @param col - collum
     * @return  {@code true} if play is possible
     *          <li>
     *          {@code false} if play is not possible
     */
    @Override
    public boolean setJogada(int lin, int col) {
        if (board[lin-1][col-1] == UNOCCUPIED){
            board[lin-1][col-1] = playerList[currentTurn];
            nextTurn();
            return true;
        }
        return false;
    }

    /**
     * Update the values to be ready for the next turn
     */
    public void nextTurn(){
        this.currentTurn = (this.currentTurn + 1) % 2;
        this.nTurns++;
    }
    
    /**
     * Check if the games is finished
     * @return  {@code true} if there is no more places to play or someone won
     *          <li>
     *          {@code false} if there is still places to play and no one was won yet
     */
    @Override
    public boolean isFinished() {
        return checkDiagonals() || checkVerticals() || checkHorizontals() || this.nTurns == 9;       
    }

    /**
     * Check if someone won in the diagonals
     * @return  {@code true} if there is a winner
     *          <li>
     *          {@code false} if there is no winner
     */
    public boolean checkDiagonals(){
        // TODO turn into atomic functions aka refactor
        if (board[1][1] != UNOCCUPIED && (checkTopLeftToBottomRight() || checkBottomLeftToTopRight())) {
            this.result = board[1][1];
            return true;
        }
        return false;
    }

    /**
     * Check if someone won in the diagonal top left to bottom right
     * @return  {@code true} if there is a winner
     *          <li>
     *          {@code false} if there is no winner
     */
    public boolean checkTopLeftToBottomRight(){
        return (this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2]);
    }

    /**
     * Check if someone won in the diagonal bottom left to top right
     * @return  {@code true} if there is a winner
     *          <li>
     *          {@code false} if there is no winner
     */
    public boolean checkBottomLeftToTopRight(){
        return (this.board[0][2] == this.board[1][1] && this.board[0][2] == this.board[2][0]);
    }

    /**
     * Check if someone won in the collums
     * @return  {@code true} if there is a winner
     *          <li>
     *          {@code false} if there is no winner
     */
    public boolean checkVerticals(){
        for (int column = 0; column < NCOLUMNS; column++){
            // TODO turn into 2 atomic functions
            if (this.board[0][column] != UNOCCUPIED && checkColumn(column)) {this.result = board[0][column]; return true;}
        }
        return false;
    }
    /**
     * Check if someone won in a collum
     * @param collum - collum for the possible win
     * @return  {@code true} if there is a winner
     *          <li>
     *          {@code false} if there is no winner
     */
    public boolean checkColumn(int column){
        return this.board[0][column] == this.board[1][column] && this.board[0][column] == this.board[2][column];
    }

    /**
     * Check if someone won in the lines
     * @return  {@code true} if there is a winner
     *          <li>
     *          {@code false} if there is no winner
     */
    public boolean checkHorizontals(){
        for (int row = 0; row < NROWS; row++){
            // TODO turn into 2 atomic functions
            if (board[row][0] != UNOCCUPIED && board[row][0] == board[row][1] && board[row][0] == board[row][2]) {this.result = board[row][0]; return true;}
        }
        return false;
    }
    /**
     * Gets the result of the match
     * @return result - the player who won / draw
     */
    @Override
    public char checkResult() {
        // TODO Auto-generated method stub
        return this.result;
    }

}