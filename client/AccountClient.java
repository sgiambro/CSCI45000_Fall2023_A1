//AccountClient.java

package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import common.BankOp;

public class AccountClient {

    public static void main (String args[]){
        try{

            BankOp stub = (BankOp)Naming.lookup("//in-csci-rrpc01.cs.iupui.edu:1234/AccountImpl");
            System.out.println("---Client calling server---");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome "+ stub.getName() + ".");
            System.out.println("What whould you like to do today?");

            //Client Menu
            while(true){

                System.out.println("\n\nView balance -------- 1");
                System.out.println("Withdraw -------------2");
                System.out.println("Deposit ------------- 3");
                System.out.println("QUIT -----------------4");

                int option = scanner.nextInt();
                if(option == 1){

                    System.out.println("Balance:  " + stub.getBalance());
                }
                else if(option == 2){

                    System.out.println("Withdraw amount:   ");
                    double amount = scanner.nextDouble();
                    stub.withdraw(amount);
                }
                else if(option == 3){

                    System.out.println("Deposit amount:   ");
                    double amount = scanner.nextDouble();
                    stub.deposit(amount);
                }
                else if(option == 4){

                    break;
                }
                else{

                    System.out.println("INVALID OPTION");
                }

            }

        }
        catch(Exception e){

            System.out.println("Client err:" + e.getMessage());
            e.printStackTrace();
        }

    }
    
}
