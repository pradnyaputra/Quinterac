public class Account {
	private String accountID;
	private int balance;
	private String accountName;

	/**
	 * No-arg constructor override to initialize values to proper format
	 */
	public Account() {
		accountID = "0000000";
		balance = 0;
		accountName = "***";
	}

	/**
	 * Constructor to create an account
	 * @param accID account ID
	 * @param bal initial balance
	 * @param accName account name
	 */
	public Account(String accID, int bal, String accName){
		accountID = accID;
		balance = bal;
		accountName = accName;
	}

	/**
	 * Get account's ID
	 * @return The account ID
	 */
	public String getAccountID() {
		return accountID;	
	}

	/**
	 * Get account's balance
	 * @return The account balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Get account's name
	 * @return The account name
	 */
	public String getAccountName() {
		return accountName;	
	}

	/**
	 * Change the account's balance
	 * @param bal The new balance
	 */
	public void setBalance(int bal) {
		balance = bal;
	}
}
