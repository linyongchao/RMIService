package rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppService extends Remote {

	public String run(String command) throws RemoteException;
}
