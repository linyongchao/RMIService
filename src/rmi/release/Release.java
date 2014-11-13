package rmi.release;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi.service.PersonService;
import rmi.service.impl.PersonServiceImpl;

public class Release {
	public static void main(String[] args) {
		try {
			PersonService personService = new PersonServiceImpl();
			// 注册通讯端口
			LocateRegistry.createRegistry(6600);
			// 注册通讯路径
			Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);
			System.out.println("Service Start!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
