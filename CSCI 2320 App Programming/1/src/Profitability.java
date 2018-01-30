import java.util.*;
import java.lang.*;

/**
 * @author Kojo Acquah - A00384405
 */

public class Profitability {

    public static void main(String[] args) {

        // variable declaration
         ArrayList businesses = new ArrayList<>();
        float initialCapital, profitMargin, fixedOpExpenses, variableOpExpenses, roi, grossProfit;
        int numOfYears;

        Scanner in = new Scanner(System.in);

        //prompt user for initial values
        System.out.print("Please enter the number of years for analysis: ");
        numOfYears = in.nextInt();
        System.out.print("Please enter the initial investment capital: ");
        initialCapital = in.nextFloat();
        //Expected profit margin (percentage)
        System.out.print("Please enter the expected profit margin (as %): ");
        profitMargin = in.nextFloat();
        //Expected fixed operation expenses
        System.out.print("Please enter the fixed operation expenses: ");
        fixedOpExpenses = in.nextFloat();
        //Expected variable expenses
        System.out.print("Please enter the variable operating expenses (as % of the budget): ");
        variableOpExpenses = in.nextFloat();
        in.close();

        roi = initialCapital/initialCapital;

    }
}