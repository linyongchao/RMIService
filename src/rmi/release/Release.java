package rmi.release;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi.service.AppService;
import rmi.service.impl.AppServiceImpl;

public class Release {
	public static void main(String[] args) {
		try {
			AppService personService = new AppServiceImpl();
			// 注册通讯端口
			LocateRegistry.createRegistry(6600);
			// 注册通讯路径
			Naming.rebind("rmi://140.206.208.50:6600/AppService", personService);
			System.out.println("Service Start!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
