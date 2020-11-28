/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.master;

import commandexecutor.RMICommandExecutor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leni
 */
public class ClientNodeConnector extends UnicastRemoteObject implements RMIClientNodeConnector {

    
    //Use Map node1 node2 
    List<String> address;

    public ClientNodeConnector(List<String> address) throws RemoteException {
        this.address = address;
    }

    @Override
    public String selectNode(String name) throws RemoteException {

        if (name.equals("node")) {
            return "node";
        }

        if (name.equals("node2")) {
            return "node2";
        }
        return "Node " + name + " not exist!";
    }

    @Override
    public String forwardCommand(String command) throws RemoteException {
        String rmiName = "rmi://localhost:9000/fileExplorer";

        System.out.println("Connecting to: " + rmiName);
        RMICommandExecutor c = null;
        try {
            c = (RMICommandExecutor) Naming.lookup(rmiName);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientNodeConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientNodeConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c.execute(command);
    }

    @Override
    public String forwardCommandNod2(String command) throws RemoteException {
        String rmiName = "rmi://localhost:9001/fileExplorer";

        System.out.println("Connecting to: " + rmiName);
        RMICommandExecutor c = null;
        try {
            c = (RMICommandExecutor) Naming.lookup(rmiName);

        } catch (NotBoundException ex) {
            Logger.getLogger(ClientNodeConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientNodeConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c.execute(command);
    }

    @Override
    public String forwardCommand(int nodeNr, String command) throws RemoteException {

        String rmiName = this.address.get(nodeNr);
        System.out.println("Connecting to: " + rmiName);
        RMICommandExecutor c = null;
        try {
            c = (RMICommandExecutor) Naming.lookup(rmiName);
            String result = c.execute(command);
//            Naming.unbind(rmiName);
            return result;

        } catch (NotBoundException ex) {
            Logger.getLogger(ClientNodeConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientNodeConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Failed to connect to: " + rmiName;
    }

    @Override
    public int getNodeCount() throws RemoteException {
       return this.address.size();
    }

}
