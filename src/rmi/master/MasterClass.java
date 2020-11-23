/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.master;

import commandexecutor.CLIExecutor;
import commandexecutor.RMICommandExecutor;
import fileexplorer.FileExplorerImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Leni
 */
public class MasterClass {

    public static void main(String[] args) throws NotBoundException, IOException {

        try {

            Registry registry = LocateRegistry.createRegistry(8999);

            RMIClientNodeConnector commandExecutor =  new ClientNodeConnector();
            Naming.rebind("rmi://localhost:8999/master", commandExecutor);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
            e.printStackTrace();
        }

      
        
       
        
      
//        try {
//            Registry registry = LocateRegistry.createRegistry(1099);
//            RMICommandExecutor commandExecutor = new CLIExecutor(new FileExplorerImpl());
//            Naming.rebind("rmi://127.0.0.2:1099/CalculatorService", commandExecutor);
//        } catch (Exception e) {
//            System.out.println("Trouble: " + e);
//        }
        
        
//        String serverName;
//        
//        if (args.length == 0) {
//            serverName = "127.0.0.2";
//        } else {
//            serverName = args[0];
//        }
//        String rmiName = "rmi://" + serverName + "/CalculatorService";
//
//        System.out.println("Connecting to: " + rmiName);
//        RMICommandExecutor c = (RMICommandExecutor) Naming.lookup(rmiName);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.err.print("Write your command here:");
//        String name = reader.readLine();
//        System.out.println(name);
//        System.out.println(c.execute(name));

    }
}
