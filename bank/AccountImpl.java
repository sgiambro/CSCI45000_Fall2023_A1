//AccountImpl.java

package bank;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.BankOp;

public class AccountImpl extends UnicastRemoteObject implements BankOp{

    AccountImpl()throws RemoteException{
        super();
    }

    String clientName = "John Raymond";
    double balance = 100;

    public String getName()throws RemoteException{

        return clientName;
    }

    public void setName(String name)throws RemoteException{

        clientName = name;
    }

    public double getBalance()throws RemoteException{

        return balance;
    }
    
    public void setBalance(double newBal)throws RemoteException{

        newBal = (Math.floor(newBal*100))/100;
        balance = newBal;
    }

    public void withdraw(double amount)throws RemoteException{

        if(amount >= 0 && balance >= amount){
            amount = (Math.floor(amount*100))/100;
            balance = balance - amount;
            balance = (Math.floor(balance*100))/100;
        }
        else if(balance < amount){
            System.out.println("Exceeds Balance");
        }
        else{
            System.out.println("INVALID INPUT");
        }

    }
    
    public void deposit(double amount)throws RemoteException{

        if(amount >= 0){
            balance = balance + amount;
            balance = (Math.floor(balance*100))/100;
        }
        else{
            System.out.println("INVALID INPUT");
        }
    }

}