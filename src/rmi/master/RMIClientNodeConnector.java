/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.master;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Leni
 */
public interface RMIClientNodeConnector extends Remote {

    String forwardCommand(int nodeNr, String command) throws RemoteException;

    int getNodeCount() throws RemoteException;



}
