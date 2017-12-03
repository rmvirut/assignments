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
     * @param initialResources vector with resources available at start
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
            if (customerNumber > NUMBER_OF_CUSTOMERS)
                throw new BankDenialError("You can only add up to " + NUMBER_OF_CUSTOMERS + " customers");

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
        StringBuilder line = new StringBuilder("Customer");

        //print labels
        for (int j = 0; j < 3; j++) {
            line.append(String.format("%s", tabs));
            for (int i = 0; i < m; i++) {
                line.append(String.format("%3s", Character.toString((char) (65 + i))));
            }
        }
        System.out.println(line);

        for (int j = 0; j < n; j++) {
            line = new StringBuilder(String.format("%3s%d%s", "P", j, tabs));
            //select a vector j
            line.append(String.format("%s", tabs));
            //print allocated vector
            for (int i = 0; i < m; i++) {
                line.append(String.format("%3d", allocation[j][i]));
            }
            line.append(String.format("%s", tabs));
            //print maximum vector
            for (int i = 0; i < m; i++) {
                line.append(String.format("%3d", maximum[j][i]));
            }
            //print need vector
            line.append(String.format("%s", tabs));
            for (int i = 0; i < m; i++) {
                line.append(String.format("%3d", need[j][i]));
            }
            System.out.println(line);
        }

        System.out.printf("\nMatrix order: %s%s%s%s%s\n", "Allocated", tabs, "Maximum", tabs, "Need");

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

        try {

            if (customerNumber > n) {
                throw new BankDenialError("This customer does not exist");
            }

            StringBuilder textBuilder = new StringBuilder("Customer #" + customerNumber + " is requesting ");
            for (int i : request) {
                textBuilder.append(i).append(" ");
            }
            String text = textBuilder.toString();
            text += printAvailable();

            System.out.println(text);

//            step 1
            if (!compareVectors(request, need[customerNumber])) {
                throw new BankDenialError("Request exceeds customer's maximum claim.");
            }

//            step 2
            if (!compareVectors(request, available)) {
                throw new BankDenialError("Insufficient resources.");
            }

//            step 3
            //pretend to allocate
            for (int i = 0; i < m; i++) {
                available[i] -= request[i];
                allocation[customerNumber][i] += request[i];
            }
            calNeed();

            //check state
            if (safeStateCheck())
                return true;

            //reverse the allocation otherwise
            for (int i = 0; i < m; i++) {
                available[i] += request[i];
                allocation[customerNumber][i] -= request[i];
            }
            calNeed();

            throw new BankDenialError("Sorry. Your request puts the bank at risk. Please try again later");

        } catch (BankDenialError e) {
            System.out.println(e.getMessage());

        }

        return false;
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

            if (customerNumber > n) {
                throw new BankDenialError("This customer does not exist");
            }

            StringBuilder textBuilder = new StringBuilder("Customer #" + customerNumber + " is releasing ");
            for (int i : release) {
                textBuilder.append(i).append(" ");
            }
            System.out.println(textBuilder.toString());

            //are you releasing more than you actually have?
            if (!compareVectors(release, allocation[customerNumber]))
                throw new BankDenialError("Sorry, you can't release more resources than you own");

            for (int i = 0; i < m; i++) {
                available[i] += release[i];
                allocation[customerNumber][i] -= release[i];
            }
            textBuilder = new StringBuilder("Allocated = ");
            for (int i : release) {
                textBuilder.append(-i).append(" ");
            }
            System.out.println(textBuilder.toString());

        } catch (BankDenialError e) {
            System.out.println(e.getMessage());
        } finally {
            //do nothing
        }
    }

    /**
     * Updates the Need vector of a given customer
     *
     * @param customerNumber
     */
    private void updateNeed(int customerNumber) {
        for (int i = 0; i < m; i++) {
            need[customerNumber][i] = maximum[customerNumber][i] - allocation[customerNumber][i];
        }
    }

    /**
     * Updates the whole need matrix
     */
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
     * @return true if x is lesser
     */
    private boolean compareVectors(int[] x, int[] y) {
        boolean response = true;
        for (int i = 0; i < m; i++) {
            if (x[i] > y[i]) {
                response = false;
            }
        }
        return response;
    }

    /**
     * Build a string reporting the available resources
     *
     * @return string
     */
    private String printAvailable() {
        StringBuilder text = new StringBuilder("Available = ");
        for (int i : available)
            text.append(i).append(" ");
        return text.toString();
    }

    /**
     * Checks the state of the system to see if it's safe
     *
     * @return true if state is safe and false otherwise
     */
    private boolean safeStateCheck() {
        boolean safe = true;
        int safeCust = 0;
        //step 1
        int[] work = new int[m];
        boolean[] finish = new boolean[n];
        System.arraycopy(available, 0, work, 0, m);
        for (boolean b : finish) {
            b = false;
        }
        while (safeCust < n && safe) {
            //step 2
            for (int i = 0; i < n; i++) {
                if (finish[i] == false && compareVectors(need[i], work)) {
                    //step 3
                    for (int k = 0; k < m; k++) {
                        work[k] = work[k] + allocation[i][k];
                    }
                    finish[i] = true;
                    safeCust++;
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
