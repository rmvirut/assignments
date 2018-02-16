import java.util.*;
import java.util.Scanner;
import java.lang.*;

public class Profitability {

    Scanner in = new Scanner(System.in);
    public final String [] prompts = {
        "Please enter the profit margin (%%) for the business #",
        "Please enter the annual fixed expenses for business #",
        "Please enter the annual variable expenses for business #"
    };

    public static void main (String [] args) {
        
        // initialize variables
        ArrayList businesses = new ArrayList();

        float [] newBus = new float[3];

        // Program intro
        System.out.printf("%s","Profitability has started. Enter the values and -1 when you're ready to proceed.");

        // Prompt user for input values
        do {
            businesses.add(getUserInput(newBus));
        } while (newBus[0]!=-1);
        // Evaluate businesses one at a time

        // print results for most profitable

    }

    public static float [] getUserInput(float b[]){

        // iterate through prompts and return array
        for(int i = 0; i < b.length; i++){
            System.out.printf("\n %s %f", prompts[i], i);
            b[i] = in.nextFloat();
        };

        return b;
    }

    public static void calBusFinNums(){

    }

    public static void calBusYrNums(){

    }

    public static void findROIYr(){

    }

    public static void findMostProf(){

    }

    public static void printResults(){

    }
}
