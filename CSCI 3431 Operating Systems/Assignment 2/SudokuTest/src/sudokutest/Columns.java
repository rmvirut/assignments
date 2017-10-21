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

    private int column;
    private int[] columnValues;

    public Columns(int colNumber, int[] colArray) {
        this.column = colNumber;
        this.columnValues = colArray;
    }

    @Override
    public void run() {

    }

    private boolean hasAllDigits() {
        boolean yesOrNo = true;

        ArrayList<Integer> set = new ArrayList(Arrays.asList(columnValues));

        for (int i = 1; i < 10; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }

        return true;
    }
}
