/**
 * Created by Tyler D.S. Elliott on 06-Nov-19.
 */
public class Account {
	private String accountID;
	private int balance;
	private String accountName;
	
	public Account(String accID, int bal, String accName){
		accountID = accID;
		balance = bal;
		accountName = accName;
	}
	
	public String getAccountID() {
		return accountID;	
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String getAccountName() {
		return accountName;	
	}
	
	public void setAccountID(String accID) {
		accountID = accID;
	}
	
	public void setBalance(int bal) {
		balance = bal;
	}
	
	public void setAccountName(String accName) {
		accountName = accName;
	}
	
}
