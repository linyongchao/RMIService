package rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.sdo.Person;

public interface PersonService extends Remote {
	public Person get() throws RemoteException;

	public Integer add(Integer a, Integer b) throws RemoteException;
}
