package atm;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class Account {
    int accountNumber,pin;
   public double presentBalance,availableCash; 
    CashDispenser dispenser;
    int attemptCount,maxAttempt=2;
    boolean isLocked;

    public Account(int acc_num,int pin_num,double present_amount){
    	accountNumber=acc_num;
    	pin=pin_num;
    	presentBalance=present_amount;
    	dispenser = new CashDispenser();
    	attemptCount = 0;
    	isLocked = false;
    }
    
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getPresentBalance(){
        return presentBalance;
    }    
    public boolean validatePin(int userPin){
    	attemptCount++;
        if(userPin==pin) 
            return true;
        else{
        	if(attemptCount>=maxAttempt){
        		isLocked = true;
        		System.out.println("Is Locked");
        	}
            return false;
        }
    	
    	
    }
    public void withdraw(double amount){
    	if(presentBalance-amount>=100 && amount<presentBalance && availableCash-amount >=100){
        presentBalance-=amount;
        updateCashDispenser(amount);
    	}
        System.out.println("Balance is" + presentBalance);
        
    }
    public void deposit(double amount){
     
        presentBalance+=amount;
        System.out.println("Balance is" + presentBalance);
    }
    public void checkBalance(){
    	System.out.println("Balance is" + presentBalance);
    }
    
    public void updateCashDispenser(double amount){
    	dispenser.dispenseCash(amount);
    	availableCash = dispenser.availableCashAmount;
    }
    
    
    
}
