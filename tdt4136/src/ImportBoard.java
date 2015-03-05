import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Magnus Kirø - magnuskiro@underdusken.no
 * Date: 11/9/11
 * Time: 12:11 PM
 */
public class ImportBoard{
    public static void main(String args[]) throws IOException{
        ImportBoard importBoard = new ImportBoard();
        int[][] board = importBoard.importSudoku();
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                System.out.print(board[i][j]);
            }
                System.out.println();
        }
    }

    public int[][] importSudoku(){
        int board[][] = new int[9][9];
        try {
            readFile(board);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Problem reading board. Fix the mistake in sudoku.txt");
        }
        return board;
    }

    public void readFile(int[][] board) throws IOException{
        FileReader fr = null;
        try {
            fr = new FileReader("sudoku.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            int i=0;
            while((s = br.readLine()) != null) {
                //System.out.println(s);
                addRow(s, i, board);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fr.close();
        }
    }

    public void addRow(String input, int row, int [][] board){
        char c[] = input.toCharArray();
        for(int i=0; i<9; i++){
            int a = c[i]-48;
            board[row][i] = a;
            //System.out.println(a);
        }
    }
}

