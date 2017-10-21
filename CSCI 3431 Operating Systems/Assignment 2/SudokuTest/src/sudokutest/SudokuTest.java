package sudokutest;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author kojo
 */
public class SudokuTest {

//    multidimensional array for puzzle
    static int[][] puzzle = new int[9][9];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        worker threads

Thread rowChecker;
Thread colChecker;
Thread reg1, reg2, reg3,reg4, reg5, reg6, reg9;
        
//        build puzzle from file
        buildPuzzle(args[0]);
        
        //create rowcheck thread;
        
    }

    /**
     *
     * @param fileName Name of file with the sudoku puzzle. Must be in the same
     * directory as executable file
     */
    public static void buildPuzzle(String fileName) {
        FileInputStream in;
        Scanner fileRead;

        try {
            //open the file provided as argument
            in = new FileInputStream(fileName);
            fileRead = new Scanner(in);

            int i = 0;
            String[] line;

            while (fileRead.hasNextInt() || i < 9) {
                // Read everything in the sudokutxt file
                line = fileRead.nextLine().replaceAll("\\D", "").split("");

                for (int k = 0; k < 9; k++) {
                    puzzle[i][k] = Integer.parseInt(line[k]);
                }
                i++;
//                read and discard the next empty line
                if (i < 9) {
                    fileRead.nextLine();
                }
            }

            int p = 0;

            if (p < 1) {

            }

        } catch (FileNotFoundException e) {

        }
    }

}
