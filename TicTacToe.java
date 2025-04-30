public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private int xWins;
    private int oWins;

    public TicTacToe() {
        board = new char[3][3];
        resetBoard();
        currentPlayer = 'X';
        xWins = 0;
        oWins = 0;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != '-') {
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                incrementWin(currentPlayer);
                return true;
            }

            if (board[0][i] != '-' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                incrementWin(currentPlayer);
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != '-' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            incrementWin(currentPlayer);
            return true;
        }

        if (board[0][2] != '-' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            incrementWin(currentPlayer);
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char[][] getBoard() {
        return board;
    }

    public int getXWins() {
        return xWins;
    }

    public int getOWins() {
        return oWins;
    }

    private void incrementWin(char player) {
        if (player == 'X') {
            xWins++;
        } else if (player == 'O') {
            oWins++;
        }
    }

    public void setBoard(char[][] newBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public void setCurrentPlayer(char player) {
        currentPlayer = player;
    }
}
