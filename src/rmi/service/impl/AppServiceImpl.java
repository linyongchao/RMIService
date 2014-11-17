package rmi.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.ggf.drmaa.DrmaaException;
import org.ggf.drmaa.JobTemplate;
import org.ggf.drmaa.Session;
import org.ggf.drmaa.SessionFactory;

import rmi.service.AppService;

public class AppServiceImpl extends UnicastRemoteObject implements
		AppService {

	private static final long serialVersionUID = 1L;

	public AppServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String run(String command) throws RemoteException {
		SessionFactory factory = SessionFactory.getFactory();
		Session session = factory.getSession();
		String id = null;
		try {
			session.init("");
			JobTemplate jt = session.createJobTemplate();
			jt.setRemoteCommand(command);
			id = session.runJob(jt);
			session.deleteJobTemplate(jt);
			session.exit();
		} catch (DrmaaException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return id;
	}
}