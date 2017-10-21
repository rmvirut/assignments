package sudokutest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kojo
 */
public class Rows implements Runnable {
    
    private int[][] rowValues;

    public Rows(int[][] rowArr) {
        this.rowValues = rowArr;
    }

    @Override
    public void run() {
        if(hasAllDigits()){
            System.out.println("Rows worked");
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
