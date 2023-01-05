package com.sltc.soa.client;

import com.sltc.soa.client.stub.BankWS;
import com.sltc.soa.client.stub.BankWSService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        URL url = new URL("http://demowebservice.com:8080/currencyservice?wsdl");
//        DemoWSService demoWSService = new DemoWSService(url);

        BankWSService bankWSService = new BankWSService();
        BankWS bankWSPort = bankWSService.getBankWSPort();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        bankWSPort.addUser("3356", 1500);
        bankWSPort.addUser("5678", 1000);
        bankWSPort.addUser("5050", 2000);
        bankWSPort.addUser("1150", 3000);
        bankWSPort.addUser("9970", 4500);
        bankWSPort.addUser("8712", 10000);

        while (!exit) {
            welcome();
            int num = Integer.parseInt(sc.next());
            switch (num) {
                case 1:
                    System.out.println("Enter the account no : ");
                    String acc = sc.next();
                    System.out.println("Enter the Opening Balance : ");
                    String O_Balance = sc.next();
                    bankWSPort.addUser(acc, Float.parseFloat(O_Balance));
                    System.out.println("Account Creation Successful. \n");
                    System.out.println("Do you want to go Back (Y/N)");
                    String yn = sc.next();
                    yn = yn.toLowerCase();
                    if (yn.equals("y")) {
                        welcome();
                        break;
                    } else {
//                       System.out.println("Exiting....");

                    }
                    break;

                case 2:
                    System.out.println("Please Enter your account number :");
                    String my_acc = sc.next();

                    while (!exit) {
                        trans_menu();
                        int choice = Integer.parseInt(sc.next());

                        switch (choice) {
                            case 1:
                                System.out.println("Enter the amount you want to deposit: ");
                                String amount = sc.next();
                                float currBalance = bankWSPort.deposit(Float.parseFloat(amount), my_acc);
                                System.out.println("Your balance : Rs:" + currBalance + "/=");
                                break;

                            case 2:
                                System.out.println("Enter the amount you want to withdraw: ");
                                amount = sc.next();
                                currBalance = bankWSPort.withdraw(Float.parseFloat(amount), my_acc);
                                if (currBalance != -1) {
                                    System.out.println("Your balance : Rs:" + currBalance + "/=");
                                } else {
                                    System.out.println("Sorry! Your account balance is insufficient for withdraw money");
                                }
                                break;

                            case 3:
                                System.out.println("Enter the account you want to transfer the money: ");
                                String trans_acc = sc.next();
                                System.out.println("Enter the amount you want to transfer: ");
                                amount = sc.next();
                                currBalance = bankWSPort.transfer(my_acc, trans_acc, Float.parseFloat(amount));
                                if (currBalance != -1) {
                                    System.out.println("Your balance : Rs:" + currBalance + "/=");
                                } else {
                                    System.out.println("Sorry! Your account balance is insufficient for transfer money");
                                }
                                break;

                            case 4:
                                System.out.println("Do you want to go Back (Y/N)");
                                yn = sc.next();
                                yn = yn.toLowerCase();
                                if (yn.equals("y")) {
                                    welcome();
                                } else {
//                                  System.out.println("Exiting....");

                                }
                                welcome();
                                break;

                            case 5:
                                exit = true;
                                System.out.println("Exiting....");
                                break;

                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                    }

                case 3:
                    exit = true;
                    System.out.println("Exiting....");
                    break;
            }
        }
    }

    public static void welcome() {
        System.out.println("Welcome to the Bank" + "\n" +
                "\r" + "1. Press 1 for add an account" + "\n" +
                "\r" + "2. Press 2 for transactions" + "\n" +
                "\r" + "3. Press 3 for Exit" + "\n");


    }

    public static void trans_menu() {
        System.out.println("Transaction menu" + "\n" +
                "\r" + "1. Press 1 for Deposit" + "\n" +
                "\r" + "2. Press 2 for Withdrawal" + "\n" +
                "\r" + "3. Press 3 for Transferring" + "\n" +
                "\r" + "4. Press 4 for go back" + "\n" +
                "\r" + "5. Press 5 for EXIT" + "\n");

    }
}
