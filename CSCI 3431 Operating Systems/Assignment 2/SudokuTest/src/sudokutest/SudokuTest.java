package sudokutest;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kojo
 */
public class SudokuTest {

    //multidimensional array for puzzle
    static int[][] puzzle = new int[9][9];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //workers
        Thread rowChecker;
        Thread colChecker;
        Thread reg1, reg2, reg3, reg4, reg5, reg6, reg9;

        //build puzzle from file
        buildPuzzle(args[0]);

        //create rowcheck thread;
        rowChecker = new Thread(new Rows(puzzle));

        colChecker = new Thread(new Columns(puzzle));

        rowChecker.start();
        colChecker.start();

        int[][][] nineRegions = new int[9][3][3];
        int r = 0;
        int c = 0;
        int track = 3;

        int block = (r / 3) * 3 + (c / 3);

        for (int s = 0; s < 9; s++) {
            for (r = 0; r < 3; r++) {
                for (c = 0; c < 3; c++) {
                    nineRegions[s][r][c] = puzzle[s][r * 3 + c];

                }
            }
        }

    }

    int y = 0;

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
                // read and discard the next empty line
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
