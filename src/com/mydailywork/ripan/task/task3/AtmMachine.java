package com.mydailywork.ripan.task.task3;

import java.util.Scanner ;

public class AtmMachine {
    public static void main(String[] args) {

        Scanner scan = null;
        boolean operation = true;

        Account user1 = new Account(10000); // pass initial balance

        while(operation){
            System.out.println("~~~~~~Atm Machine~~~~~~\n");
            System.out.println("Press 1. Deposit\nPress 2. Withdraw\nPress 3. Check Balance\nPress 4. Exit");
            if(scan == null)
                scan = new Scanner(System.in);
            System.out.print("Which operation You want to perform : ");
            int option = scan.nextInt();

            if(option == 1){
                System.out.println("You have selected the Deposit option..");
                System.out.println("Enter the Amount you want to deposit : ");
                user1.deposit(scan.nextInt());

            } else if(option == 2){
                System.out.println("You have selected the Withdraw option..");
                System.out.println("Enter the Amount you want to withdraw : ");
                user1.withdraw(scan.nextInt());

            } else if(option == 3){
                System.out.println("You have selected the Check Balance option..");
                user1.checkBalance();
            } else if(option == 4){
                System.exit(0);
            } else {
                System.out.println("Invalid option, Please select correct option..");
            }

            System.out.println("Do you want to Perform More Opeartion(yes/no) : ");
            if(scan == null)
                scan = new Scanner(System.in);
            String choice = scan.next();
            operation = choice.equalsIgnoreCase("yes");
        }
        scan.close();
    }
}
