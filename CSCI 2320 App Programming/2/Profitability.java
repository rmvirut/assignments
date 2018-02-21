import java.util.*;
import java.util.Scanner;
import java.lang.*;

public class Profitability {

  // static variables

  static final String[] prompts = { "Please enter the profit margin (%) for the business #",
      "Please enter the annual fixed expenses for business #",
      "Please enter the annual variable expenses for business #" };
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {

    // initialize variables
    int numYears = 0; //number of years for analysis
    float invCap = 0; //initial investment capital
    ArrayList<float[]> busInfo = new ArrayList<float[]>(); //information on businesses

    boolean validBusiness = true;

    // Program intro
    System.out.printf("%s\n", "Profitability has started. Enter the values and -1 when you're ready to proceed.");

    // years to analyse, initial capital & profit margin
    System.out.printf("%s", "Please enter the number of years for the financial analysis: ");
    numYears = in.nextInt();
    System.out.printf("%s", "Please enter the initial Investment Capital: ");
    invCap = in.nextFloat();

    // Prompt user for business info
    do {
      //[0] = profit margin
      //[1] = fixed expenses
      //[2] = variable expenses
      //[3] = endBalance after analyses
      busInfo.add(getUserInput(new float[4], busInfo.size()));
      //the last business added isn't invalid
      validBusiness = busInfo.get(busInfo.size() - 1)[0] != -1;
    } while (validBusiness);

    //remove the last busines (invalid info)
    busInfo.remove(busInfo.size() - 1);

    // Evaluate businesses one at a time
    for (int i = 0; i < busInfo.size(); i++) {
      //pass businesses one at a time
      System.out.println("--------------------");
      System.out.printf("%s%d\n", "Currently Analysing Business #", i);
      System.out.println("--------------------");
      calBusFinNums(busInfo.get(i), invCap, numYears);
    }
    // print result prompts for most profitable
    int mostProfitable = findMostProf(busInfo);
    //find the most profitable by analysing the previously generated financial information on the business
    System.out.printf("%s %d %s %f", "The most profitable business is number", mostProfitable, "with overall profit = ",
        busInfo.get(mostProfitable)[3] - invCap);

    System.out.printf(
        "It will achieve/exceed 100%% ROI in Year %d, with a total ending balance at the end of Year %d = %.2f\n",
        findROIYr(busInfo.get(mostProfitable), invCap), numYears, busInfo.get(mostProfitable)[3]);
  }

  /**
   * This method prompts the user to enter information for the businesses
   *
   * @param float b [] empty float array of size 3 passed by reference;
   * @param int   busNum represents the number of businesses;
   */
  public static float[] getUserInput(float b[], int busNum) {
    // iterate through prompts and return array
    for (int i = 0; i < b.length - 1; i++) {
      System.out.printf("\n%s%d: ", prompts[i], busNum);
      b[i] = in.nextFloat();
    }
    return b;
  }

  /**
   * 
   * 
   * @param business
   * @param cap
   * @param yrs
   */
  public static void calBusFinNums(float business[], float cap, int yrs) {
    float gross = 0;
    float net = 0;

    for (int i = 0; i < yrs; i++) {
      System.out.printf("%s%d%s\n", "Year: ", i, " analysis");
      System.out.printf("%s%.2f\n", "Gross Profit: ", gross = cap * business[0]);//update gross profit
      System.out.printf("%s%.2f\n", "Net Profit: ", net = gross - business[1] - (business[2] * cap));//update netprofit
      System.out.printf("%s%.2f\n", "End balance: ", cap += net);//endBalance  = updated investment Cap
    }

    //store ending balance
    business[3] = cap;
  }

  /**
   * @param business
   * @param cap
   */
  public static int findROIYr(float[] business, float cap) {
    float gross = 0, net = 0, sumNet = 0;
    int years = 0;

    while ((sumNet / cap) < 1) {
      gross = cap * business[0];
      net = gross - business[1] - (business[2] * cap);
      sumNet += net;
      years++;
    }

    return years;
  }

  /**
   * Finds the most profitable business amongst the given array list
   * @param busInfo
   */
  public static int findMostProf(ArrayList<float[]> busInfo) {
    int winner = 0;
    for (int i = 0; i < busInfo.size() - 1; i++) {
      if (busInfo.get(i)[3] < busInfo.get(i + 1)[3]) {
        winner = i;
      }
    }
    return winner;
  }
}
