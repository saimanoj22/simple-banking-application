package simpleBankingApplication;

import java.util.Scanner;

public class Account {
    private String customerName;
    private String customerId;
    private int balance;
    private int previousTransaction;
    
    public Account(String name, String id){
        this.customerName = name;
        this.customerId = id;
    }
    
    public void start(){
        showMenu();
        char option = '\0';
        do{
            System.out.println();
            System.out.println("Enter an option : ");
            Scanner scan = new Scanner(System.in);
            char option1 = scan.nextLine().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();
            
            switch(option){
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = $" + this.balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;
                
                case 'B':
                    System.out.println("Enter an amount to deposit : ");
                    int depoAmount = Integer.valueOf(scan.nextLine());
                    deposit(depoAmount);
                    System.out.println();
                    break;
                    
                case 'C':
                    System.out.println("Enter an amount to withdraw : ");
                    int withAmount = Integer.valueOf(scan.nextLine());
                    withdraw(withAmount);
                    System.out.println();
                    break;
                    
                case 'D':
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("==============================");
                    System.out.println();
                    break;
                    
                case 'E':
                    System.out.println("Enter how many years of accured interest : ");
                    int years = Integer.valueOf(scan.nextLine());
                    calculateInterest(years);
                    break;
                    
                case 'F':
                    System.out.println("==============================");
                    break;
                    
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E or F.");
                    break;
            }
            
        }while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
    
    public void deposit(int amount){
        if(amount != 0){
            this.balance += amount;
            this.previousTransaction = amount;
        }
    }
    
    public void withdraw(int amount){
        if(amount != 0){
            if(amount <= this.balance){                
                this.balance -= amount;
                this.previousTransaction = -amount;
            }
            else{
                System.out.println("Sorry! Insufficient Balance!");
            }
        }
    }
    
    public void getPreviousTransaction(){
        if(this.previousTransaction > 0){
            System.out.println("Deposited : " + this.previousTransaction);
        }
        else if(this.previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(this.previousTransaction));
        }
        else{
            System.out.println("No transaction occurred.");
        }
    }
    
    public void calculateInterest(int years){
        double interestRate = 0.0185;
        double newBalance = (this.balance * interestRate * years) + this.balance;
        System.out.println("the currrent interest rate is : " + (100 * interestRate));
        System.out.println("After " + years + " years, your balance will be : " + newBalance);
        
    }
    
    public void showMenu(){
        System.out.println("Welcome, " + this.customerName + "!");
        System.out.println("Your ID is : " + this.customerId);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawl");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
    }
}
