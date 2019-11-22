/**
 * This class contains individual test cases for our backend, in which the methods are run individually
 * (main is not part of the test)
 */

import org.junit.Test;

public class BackEndTest {

    public static void main(String[] args) {
        String[] arguments = {"oldMasterAccounts.txt", "mergedTransactionSummaryFile.txt"};
        BackEnd.main(arguments);
    }

    /**
     * Statement coverage testing of the createacct command
     */
    @Test
    public void createAcctStatementCoverageTest() {
        String[] arguments = {"Testing/Test Files/CreateAcctBackEnd/oldMasterAccounts.txt", "Testing/Test Files/CreateAcctBackEnd/mergedTransactionSummaryFile.txt"};
        BackEnd.main(arguments);
    }

    /**
     * Basic block coverage testing of the withdraw command
     */
    @Test
    public void withdrawCoverageTest(){ //Basic block testing
        String[] arguments = {"Testing/Test Files/WithdrawBackEnd/oldMasterAccounts.txt", "Testing/Test Files/WithdrawBackEnd/mergedTransactionSummaryFile.txt"};
        BackEnd.main(arguments);
    }

}
