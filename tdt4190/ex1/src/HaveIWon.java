import java.util.ArrayList;
import java.util.Comparator;

public class HaveIWon implements Constants{

    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public HaveIWon(){};

    public boolean check(int row, int column) {
        add(row, column);
        return result();
    }

    private void add(int row, int column) {
        board[row][column] = 1;
    }

    public void clearBoard(){
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
    }

    private boolean result() {
        if (rowCheck()) {
            return true;
        } else if (columnCheck()) {
            return true;
        } else if (diagonalCheck()) {
            return true;
        } else {
            return false;
        }
    }

    // row increase while col==0
    private boolean rowCheck() {
        int counter = 0;
        for(int row = 0; row < BOARD_SIZE; row++){
            for(int col = 0; col < BOARD_SIZE; col++){
                if(board[row][col] == 1){
                    counter++;
                }else {
                    counter=0;
                }
                if(counter == WINNER_LENGTH){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean columnCheck() {
        int counter = 0;
        for(int col = 0; col < BOARD_SIZE; col++){
            for(int row = 0; row < BOARD_SIZE; row++){
                if(board[row][col] == 1){
                    counter++;
                }else {
                    counter = 0;
                }
                if(counter == WINNER_LENGTH){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalCheck() {
        int i = 0;
        int count = 0;
        
        for(i = 0; i < WINNER_LENGTH - 1; i++){
            for(int j = 0; j <WINNER_LENGTH - 1; j++) {
                for(int k = 0; k < WINNER_LENGTH; k++) {
                    if (board[i+k][j+k] == 1) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count == WINNER_LENGTH)
                        return true;
                }
            }
        }

        count = 0;
        for(i = 0; i < WINNER_LENGTH - 1; i++) {
            for(int j = BOARD_SIZE-1; j>=WINNER_LENGTH-1; j--) {
                for(int k = 0; k < WINNER_LENGTH; k++) {
                    if(board[i+k][j-k] == 1) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if(count == WINNER_LENGTH)
                        return true;
                }
            }
        }
        return false;
    }
}        
