import org.junit.Test;

public class BackEndTest {

    public static void main(String[] args) {
        String[] arguments = {"oldMasterAccounts.txt", "mergedTransactionSummaryFile.txt"};
        BackEnd.main(arguments);
    }

    @Test
    public void R1T1() {
        String[] arguments = {"oldMasterAccounts.txt", "mergedTransactionSummaryFile.txt"};
        BackEnd.main(arguments);
    }

}
