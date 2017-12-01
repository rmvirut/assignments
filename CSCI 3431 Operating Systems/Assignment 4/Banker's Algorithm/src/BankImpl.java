public class BankImpl implements Bank {

    private int n; // the number of threads in the system
    private int m; // the variety/number of resources available
    private int[] available; // the amount available of each resource
    private int[][] maximum; // the maximum demand of each thread
    private int[][] allocation; // the amount currently allocated to each thread
    private int[][] need; // the remaining needs of each thread

    /**
     * Takes resource types and creates a new instance of the BankImpl
     *
     * @param initialResources
     */
    public BankImpl(int[] initialResources) {

        this.n = Bank.NUMBER_OF_CUSTOMERS; //initialize
        this.m = initialResources.length;//specify kinds of resources
        this.available = new int[m];//set number of available resources
        this.available = initialResources;
        //initialize arrays
        this.maximum = new int[n][m];
        this.allocation = new int[n][m];
        this.need = new int[n][m];
    }

    /**
     * Add a customer to the bank.
     *
     * @param customerNumber The number of the customer being added.
     * @param maximumDemand  array defining max requirement of each resource
     */
    @Override
    public void addCustomer(int customerNumber, int[] maximumDemand) {
        //set max and initialize need to max
        try {
//            verify max is less than available
            if (compareVectors(maximumDemand, available)) {
                for (int i = 0; i < m; i++) {
                    this.maximum[customerNumber][i] = maximumDemand[i];
                    this.allocation[customerNumber][i] = 0;
                }
                //update the needs
                updateNeed(customerNumber);
            } else {
                throw new BankDenialError("Customer number " + customerNumber + "'s max need exceeds available " +
                        "resource");
            }
        } catch (BankDenialError e) {
            System.out.println(e.getMessage());
            System.out.println("Program will now exit");
            System.exit(0);
        }

    }

    /**
     * Outputs the available, allocation, max, and need matrices.
     */
    @Override
    public void getState() {
        System.out.println(printAvailable());
        String tabs = "    ";
        String line = "Customer";

        //print labels
        for (int j = 0; j < 3; j++) {
            line += String.format("%s", tabs);
            for (int i = 0; i < m; i++) {
                line += String.format("%3s", Character.toString((char) (65 + i)));
            }
        }
        System.out.println(line);

        for (int j = 0; j < n; j++) {
            line = String.format("%3s%d%s", "P", j, tabs);
            //select a vector j
            line += String.format("%s", tabs);
            //print allocated vector
            for (int i = 0; i < m; i++) {
                line += String.format("%3d", allocation[j][i]);
            }
            line += String.format("%s", tabs);
            //print maximum vector
            for (int i = 0; i < m; i++) {
                line += String.format("%3d", maximum[j][i]);
            }
            //print need vector
            line += String.format("%s", tabs);
            for (int i = 0; i < m; i++) {
                line += String.format("%3d", need[j][i]);
            }
            System.out.println(line);
            line = ""; //reset line
        }

        System.out.printf("\nMatrix order: %s%s%s%s%s", "Allocated", tabs, "Maximum", tabs, "Need");

    }

    /**
     * Make a request for resources.
     *
     * @param customerNumber The number of the customer being added.
     * @param request        The request from this customer.
     * @return false The request is not granted.
     */
    @Override
    public boolean requestResources(int customerNumber, int[] request) {
        String text = "Customer " + customerNumber + " is requesting ";
        for (int i : request) {
            text += i + " ";
        }
        text += printAvailable();

        System.out.println(text);
        try {
//            step 1
            if (!compareVectors(request, need[customerNumber])) {
                throw new BankDenialError("Requested resources exceeds customer's maximum claim.\nRequest will be denied");
            }

//            step 2
            if (!compareVectors(request, available)) {
                throw new BankDenialError("Reqeusted reserouces exceeds those available. Please wait until the resources" +
                        " have been released");
            }

//            step 3
            //pretend to allocate
            for (int i = 0; i < m; i++) {
                available[i] -= request[i];
                allocation[customerNumber][i] += request[i];
            }
            calNeed();

            //check state
            if (safetyAlgo())
                return true;

            //reverse the allocation otherwise
            for (int i = 0; i < m; i++) {
                available[i] += request[i];
                allocation[customerNumber][i] -= request[i];
            }
            calNeed();

            throw new BankDenialError("Sorry. You request puts the bank at risk. Please try again later");

        } catch (BankDenialError e) {
            System.out.print(e.getMessage());
        } finally {
            return false;
        }
    }

    /**
     * Release resources.
     *
     * @param customerNumber The number of the customer being added.
     * @param release        The resources to be released.
     */
    @Override
    public void releaseResources(int customerNumber, int[] release) {

        try {
            //are you releasing more than you actually have?
            if (!compareVectors(release, allocation[customerNumber]))
                throw new BankDenialError("Sorry, you can't release more reseources than you own");

            for (int i = 0; i < m; i++) {
                available[i] += release[i];
                allocation[customerNumber][i] -= release[i];
            }

        } catch (BankDenialError e) {
            System.out.println(e.getMessage());
        } finally {
            //do nothing
        }
    }

    private void updateNeed(int customerNumber) {
        for (int i = 0; i < m; i++) {
            need[customerNumber][i] = maximum[customerNumber][i] - allocation[customerNumber][i];
        }
    }

    private void calNeed() {
        for (int j = 0; j < n; j++) {
            updateNeed(j);
        }
    }

    /**
     * Returns the greater of two vectors X and Y which are expressed as arrays
     * Order of parameters matters!
     * evaluates the expression x[i] =< y[i]
     *
     * @return true if x is greater, false if y is greater
     */
    private boolean compareVectors(int[] x, int[] y) {
        for (int i = 0; i < m; i++) {
            if (x[i] > y[i])
                return false;
        }
        return true;
    }

    private String printAvailable() {
        String text = "Available = ";
        for (int i : available)
            text += i + " ";
        return text;
    }

    private boolean safetyAlgo() {

        //step 1
        int[] work = new int[m];
        boolean[] finish = new boolean[n];
        for (int i = 0; i < m; i++) {
            work[i] = available[i];
        }
        for (boolean b : finish) {
            b = false;
        }

        //step 2
        for (int i = 0; i < n; i++) {
            if (finish[i] == false && compareVectors(need[i], work)) {
                //step 3
                for (int k = 0; k < work.length; k++) {
                    work[k] = work[k] + allocation[i][k];
                    finish[i] = true;
                }
            }
        }

        //step 4
        for (boolean b : finish) {
            if (!b) {
                return false;
            }
        }

        return true;
    }


}
