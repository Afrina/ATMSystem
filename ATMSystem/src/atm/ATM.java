package atm;


import java.util.Scanner;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ATM {
    
    public boolean userAuthenticated;
    public int currentAccountNumber;   
    public Account currentAccount;
    Scanner input=new Scanner(System.in);
    public Account[] acc=new Account[5];
    public boolean isLocked;
    
    public ATM(){
        userAuthenticated=false;
        currentAccountNumber=0; 
        isLocked=false;
           }
    public void loadAccountInformations(){
        acc[0]=new Account(1,5,1000);
        acc[1]=new Account(2,10,2000);
        acc[2]=new Account(3,15,3000);
        acc[3]=new Account(4,20,4000);
        acc[4]=new Account(5,25,5000);
    }
    
    public void run(){
    	loadAccountInformations();
        while(true){
            while(!userAuthenticated){
            authenticateUser();
            }
            performTransaction();
            //userAuthenticated=false;
        }
    }
    public void authenticateUser(){
       System.out.println("Againa here");
        int accountNumber,pin;
        System.out.println("Enter account number:");
        accountNumber=input.nextInt();
       
        Account userAccount=getAccount(accountNumber) ;
        if(userAccount!=null){
        	while(userAccount.isLocked==false){
        	 System.out.println("Enter PIN number:");
             pin=input.nextInt();
            userAuthenticated =  userAccount.validatePin(pin);
            if(userAuthenticated) break;
        	}
        }
        else 
            userAuthenticated =  false;
         
         if(userAuthenticated){
             currentAccountNumber=accountNumber;
             currentAccount = getAccount(currentAccountNumber);
         }
        
        }
    
    public Account getAccount(int acc_num){
        for(Account i:acc){
            if(i.getAccountNumber()==acc_num) return i;
        }
        return null;
    }
     
    public void performTransaction() {
    	 while(true){
        	 System.out.println("Main Menu:\n 1-View balance\n2-Withdraw\n3-Deposite\n4-Exit\nEnter choice: ");
             int x=input.nextInt();
             if(x==1){
            	 currentAccount.checkBalance();
             }
             else if(x==2){
            	 System.out.println("Insert Ammonut");
            	 double amount=input.nextDouble();
            	 currentAccount.withdraw(amount);
             }
             else if(x==3){
            	 System.out.println("Insert Ammonut");
            	 double amount=input.nextDouble();
            	 currentAccount.deposit(amount); 
             }
             else if(x==4){
            	 userAuthenticated=false;
            	 break;
             }
             else{
            	 System.out.println("Invalid System Query");
             }
        }
    }    
}


