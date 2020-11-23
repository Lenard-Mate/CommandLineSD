/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.master;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Leni
 */
public interface RMIClientNodeConnector  extends Remote{
    
  String forwardCommand(String command) throws RemoteException;
    
}
