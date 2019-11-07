/**
 * Created by Tyler D.S. Elliott on 06-Nov-19.
 */
public class Account {
	private int accountID;
	private int balance;
	private String accountName;
	
	public Account(int accID, int bal, String accName){
		accountID = accID;
		balance = bal;
		accountName = accName;
	}
	
	public int getAccountID() {
		return accountID;	
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String getAccountName() {
		return accountName;	
	}
	
	public void setAccountID(int accID) {
		accountID = accID;
	}
	
	public void setBalance(int bal) {
		balance = bal;
	}
	
	public void setAccountName(String accName) {
		accountName = accName;
	}
	
}
