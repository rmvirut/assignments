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
public class Rows implements Runnable {

    private int row;
    private int[][] rowValues;

    public Rows(int rowNumber, int[][] rowArr) {
        this.row = rowNumber;
        this.rowValues = rowArr;
    }

    @Override
    public void run() {
        if(hasAllDigits()){
            
        }
    }

    private boolean hasAllDigits() {

        //pick a row and make it an Array
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> set = new ArrayList(Arrays.asList(rowValues[i]));
//            check each cell in the row    
            for (int k = 0; k < 9; k++) {
                if (!set.contains(k + 1)) {
//                    iterate from 0 + 1 to 8+1
                    return false; //return false if a number isn't in the list

                }
            }

        }

        return true;
    }
}
