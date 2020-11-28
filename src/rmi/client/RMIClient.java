package rmi.client;

import rmi.master.RMIClientNodeConnector;
import commandexecutor.RMICommandExecutor;
import fileexplorer.FileExplorer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RMIClient {

    public static void main(String[] args) throws IOException, NotBoundException {
//
//        // determine the machine of the server
//        String serverName;
//        if (args.length == 0) {
//            serverName = "127.0.0.1";
//        } else {
//            serverName = args[0];
//        }
        String rmiName = "rmi://localhost:8999/master";

        System.out.println("Connecting to: " + rmiName);
        RMIClientNodeConnector c = (RMIClientNodeConnector) Naming.lookup(rmiName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.err.print("Select Node:");
        int nodeIndex = Integer.parseInt(reader.readLine());
        
        
        
        
        
        
        while(true){
            System.err.print("Command: ");
            String command=reader.readLine();
            
            
            if("break".equals(command)){
                break;
            }
            
            System.out.println(c.forwardCommand(nodeIndex, command));
        }
        
        
//
//        while (true) {
//
//            System.out.println(c.selectNode(name));
//
//            if (c.selectNode(name).equals("node")) {
//                String node = c.selectNode(name);
//                while (true) {
//
//                    System.err.print(name+"\\ Write your command here:");
//                    String command = reader.readLine();
//                    System.out.println(command);
//                    System.out.println(c.forwardCommand(command));
//                }
//            }
//            
//             if (c.selectNode(name).equals("node2")) {
//                String node = c.selectNode(name);
//                while (true) {
//
//                    System.err.print(name+"\\ Write your command here:");
//                    String command = reader.readLine();
//                    System.out.println(command);
//                    System.out.println(c.forwardCommandNod2(command));
//                }
//             }
//             
//             
//             
//             
//             
//
////               // determine the machine of the server
////        String serverName;
////        if (args.length == 0) {
////            serverName = "127.0.0.1";
////        } else {
////            serverName = args[0];
////        }
////        String rmiName = "rmi://" + serverName + "/CalculatorService";
////
////        System.out.println("Connecting to: " + rmiName);
////         RMICommandExecutor c = (RMICommandExecutor) Naming.lookup(rmiName);
////         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////        while (true) {
////           
////            System.err.print("Write your command here:");
////            String name = reader.readLine();
////            System.out.println(name);
////            System.out.println(c.execute(name));
//        }

    }

}
