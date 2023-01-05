package com.sltc.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.HashMap;
//import java.util.Scanner;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class BankWS
{
    HashMap<String,Float> UserAccounts = new HashMap<String,Float>();

    @WebMethod
    public boolean addUser(String userAcc, float balance){
        System.out.println( "Account Creation success, "+userAcc + " current balance " + balance);
        UserAccounts.put(userAcc, balance);
        return true;
    }

    @WebMethod
    public float deposit(float amount, String acc_no){
        float balance = UserAccounts.get(acc_no);
        balance += amount;
        UserAccounts.put(acc_no, balance);
        System.out.println( "Deposit Complete, Your current balance is : " + balance);
        return balance;
    }

    @WebMethod
    public float withdraw(float amount, String acc_no){
        float balance = UserAccounts.get(acc_no);
        if(balance < amount){
            System.out.println("Insufficient Balance");
            return -1;
        }else{
            balance -= amount;
            UserAccounts.put(acc_no, balance);
            System.out.println( "Withdraw Complete, Your current balance is : " + balance);
            return balance;
        }
    }
    @WebMethod
    public float transfer(String from_acc, String to_acc, float amount){
        float balance = UserAccounts.get(from_acc);
        if (balance<amount){
            System.out.println("Your Balance is insufficient for transfer money.");
            return -1;
        }else{
            balance -= amount;
            UserAccounts.put(from_acc,balance);
            UserAccounts.put(to_acc,UserAccounts.get(to_acc)+amount);
            System.out.println( "Transfer Complete, Your current balance is : " + balance);
            return balance;
        }
    }

    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/DemoWebService", new BankWS());
        System.out.println("Bank server is running");
    }
}
