import java.util.*;
import java.util.Scanner;
import java.lang.*;

public class Profitability {

  //static variables
  static final String[] prompts = { "Please enter the profit margin (%) for the business #",
      "Please enter the annual fixed expenses for business #",
      "Please enter the annual variable expenses for business #" };
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {

    // initialize variables
    int numYears = 0; //number of years for analysis
    float invCap = 0; //initial investment capital
    ArrayList<float[]> busInfo = new ArrayList<float[]>(); //information on businesses

    

    // Program intro
    System.out.printf("%s\n", "Profitability has started. Enter the values and -1 when you're ready to proceed.");

    // years to analyse, initial capital & profit margin
    System.out.printf("%s", "Please enter the number of years for the financial analysis: ");
    numYears = in.nextInt();
    System.out.printf("%s", "Please enter the initial Investment Capital: ");
    invCap = in.nextFloat();

    //condition for invalid business is if the last array is {-1, -1, -1, 0}
    boolean validBusiness = true;

    // Prompt user for business info
    do {
      //[0] = profit margin
      //[1] = fixed expenses
      //[2] = variable expenses
      //[3] = endBalance after analyses
      busInfo.add(getUserInput(new float[4], busInfo.size()));
     
      validBusiness = busInfo.get(busInfo.size() - 1)[0] != -1 && busInfo.get(busInfo.size() - 1)[1] != -1 && busInfo.get(busInfo.size() - 1)[2] != -1;
    } while (validBusiness);//end do-while

    in.close();//close input stream
    busInfo.remove(busInfo.size() - 1);//remove the last/invalid business

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
    System.out.printf("%s %d %s %.2f\n", "The most profitable business is number", mostProfitable,
        "with overall profit = ", busInfo.get(mostProfitable)[3] - invCap);

    System.out.printf(
        "It will achieve/exceed 100%% ROI in Year %d, with a total ending balance at the end of Year %d = %.2f\n",
        findROIYr(busInfo.get(mostProfitable), invCap), numYears, busInfo.get(mostProfitable)[3]);
  }

  /**
   * This method prompts the user to enter information for the businesses
   * 
   * @param float [4] b reference to newly created float array of size 4 passed * by reference to the function
   * @param int   busNum represents the number of businesses;
   * @return [4] b returns the reference to the updated array     
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
   * Performs and reports the financial analysises on a business
   * achieve
   * @param float [] business array containng the information about the
   * business in this order index [0] = profit margin, [1] = fixed expense,
   * [2] = variable expense and [3] = endBalance
   * @param float cap initial investment capital of the business
   * @param int yrs the number of years to analyse the business
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
   * Takes the information for a single businesses and calculates the number of
   * years it takes to reach 100% ROI.
   * achievegist
   * @param float [] business array containng the information about the
   * business in this order index [0] = profit margin, [1] = fixed expense,
   * [2] = variable expense and [3] = endBalance
   * @param float cap initial investment capital for the business
   * @return int years number of years it took to reach 100% ROI
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
   * Finds the most profitable business amongst the given array list by
   * coparing the values in the last index, [3] = end balance i.e investment
   * capital + total net profit at the end of the given years
   * @param busInfo
   * @return int winner the index of the business with the largest end balance
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
