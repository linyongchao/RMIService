package rmi.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.sdo.Person;
import rmi.service.PersonService;

public class PersonServiceImpl extends UnicastRemoteObject implements
		PersonService {

	private static final long serialVersionUID = 1L;

	public PersonServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public Person get() {
		System.out.println("Get Person Start!");
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Leslie");
		p1.setAge(25);
		return p1;
	}

	@Override
	public Integer add(Integer a, Integer b) throws RemoteException {
		return a + b;
	}
}