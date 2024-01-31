//RemoteAccount.java

package bank;

import java.rmi.*;
import java.rmi.registry.*;
import common.BankOp;

public class RemoteAccount {
    
    public static void main (String args[]){
        try{
            
            AccountImpl remote_obj = new AccountImpl();
            Naming.rebind("//in-csci-rrpc01.cs.iupui.edu:1234/AccountImpl", remote_obj);
            System.out.println("---Server is ready---");

        }
        catch(Exception e){

            System.out.println("Server err:" + e.getMessage());
            e.printStackTrace();
        }

    }

}
