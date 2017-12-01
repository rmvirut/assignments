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

        System.out.print("The Bank is open and running. Heres n = " + n);
    }

    /**
     * Add a customer to the bank.
     *
     * @param customerNumber The number of the customer being added.
     * @param maximumDemand  array defining max requirement of each resource
     */
    @Override
    public void addCustomer(int customerNumber, int[] maximumDemand) {
        for(int i = 0; i < m;i++){
            this.maximum[customerNumber][i] = maximumDemand[i];
        }
    }

    /**
     * Outputs the available, allocation, max, and need matrices.
     */
    @Override
    public void getState() {

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

        for(int i = 0; i < m; i++){
            allocation[customerNumber][i] += request[i];
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

    }
}
