package atm;

public class CashDispenser {
	  public static double availableCashAmount=15000;
	  public void dispenseCash(double amount){
		  availableCashAmount = availableCashAmount - amount;
	    	}
}
