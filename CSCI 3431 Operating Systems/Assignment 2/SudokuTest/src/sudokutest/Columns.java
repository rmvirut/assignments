/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokutest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kojo
 */
public class Columns implements Runnable {

    private int[][] columnValues;

    public Columns(int[][] colArray) {
        this.columnValues = colArray;
    }

    @Override
    public void run() {
        if(hasAllDigits()){
            System.out.println("Cols worked");
        }
    }

    private boolean hasAllDigits() {

        ArrayList<Integer> set = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> compare;
        //pick a columns
        int c = 1;

        while (c < 10) {
            compare = set;
            for (int r = 0; r < 9; r++) {
                if (compare.contains(r)) {
                    compare.remove(r);
                } else {
                    return false;//will return false in the case of duplicates on a row
                    //or if the digit was not found in the predefined set 
                }
            }
        }

        return true;
    }
}
