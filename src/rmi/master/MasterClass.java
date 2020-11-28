/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.master;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leni
 */
public class MasterClass {

    public static void main(String[] args) throws NotBoundException, IOException {
        List<String> addressList=new ArrayList<>();
        addressList.add("rmi://localhost:9000/fileExplorer");
        addressList.add("rmi://localhost:9001/fileExplorer");

        try {

            LocateRegistry.createRegistry(8999);
            RMIClientNodeConnector commandExecutor = new ClientNodeConnector(addressList);
            Naming.rebind("rmi://localhost:8999/master", commandExecutor);
        } catch (Exception e) {
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
