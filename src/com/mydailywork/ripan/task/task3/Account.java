package com.mydailywork.ripan.task.task3;

public class Account implements IAtm {
    private int accountBalance;

    public Account(int accountBalance){
        this.accountBalance = accountBalance;
    }

    @Override
    public void withdraw(int amount){
        if(amount < 0 || amount > accountBalance){
            System.out.println("Invalid amount, please type the actual amount");
            return;
        }
        accountBalance -= amount;
        System.out.println("Withdrawal of "+amount+" successful. Your new balance is "+accountBalance);
    }

    @Override
    public void checkBalance(){
        System.out.println();
        System.out.println("Your current balance is "+accountBalance);
    }

    @Override
    public void deposit(int amount){
        accountBalance+=amount;
        System.out.println("Deposit of "+amount+" successful. Your new balance is "+accountBalance);
    }
}
