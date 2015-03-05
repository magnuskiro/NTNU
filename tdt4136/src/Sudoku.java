import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Magnus Kirø - magnuskiro@underdusken.no
 * Date: 11/9/11
 * Time: 1:09 PM
 */
public class Sudoku {
    public static void main(String args[]){
        ImportBoard importBoard = new ImportBoard();
        int [][] board = importBoard.importSudoku();
        JFrame window = new Window("Sudoku", board);
    }
}
