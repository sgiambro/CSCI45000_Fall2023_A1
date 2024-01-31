//BankOp.java

package common;

import java.rmi.*;

public interface BankOp extends Remote{
    
    public String getName()throws RemoteException;
    public void setName(String name)throws RemoteException;

    public double getBalance()throws RemoteException;
    public void setBalance(double newBal)throws RemoteException;

    public void withdraw(double amount)throws RemoteException;
    public void deposit(double amount)throws RemoteException;

}
