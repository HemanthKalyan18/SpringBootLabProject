package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ClientDemo 
{

	public static void main(String[] args) 
	{
		ClientDemo operation = new ClientDemo();
		//operation.addProject();
		operation.aggregatefunctions();
	}
	public void addProject()
	{
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");   
	    
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Transaction t =  session.beginTransaction();
	    
	    Project p = new Project();
	    p.setId(101);
	    p.setName("JFSD");
	    p.setDuration("2:00");
	    p.setBudget(94000.0);
	    p.setTeamlead("Hemanth");
	
	    session.persist(p);
	    t.commit();
	    
	    System.out.println("Project Added Successfully");
	    
	    session.close();
	    sf.close();
	}
	public void aggregatefunctions() 
	{
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");   
	    
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    
	    CriteriaBuilder cb1 = session.getCriteriaBuilder();
		CriteriaQuery<Long> cq1 = cb1.createQuery(Long.class);
		Root<Project> root1 = cq1.from(Project.class);
		cq1.select(cb1.count(root1.get("budget")));
		Long count = session.createQuery(cq1).getSingleResult();
		System.out.println("Total Budget Count="+count);
		
		CriteriaBuilder cb2 = session.getCriteriaBuilder();
		CriteriaQuery<Double> cq2 = cb2.createQuery(Double.class);
		Root<Project> root2 = cq2.from(Project.class);
		cq2.select(cb2.sum(root2.get("budget")));
		double totalbudget = session.createQuery(cq2).getSingleResult();
		System.out.println("Total Budget="+totalbudget);
		
		CriteriaBuilder cb3 = session.getCriteriaBuilder();
		CriteriaQuery<Double> cq3 = cb3.createQuery(Double.class);
		Root<Project> root3 = cq3.from(Project.class);
		cq3.select(cb3.avg(root3.get("budget")));
		double avgbudget = session.createQuery(cq3).getSingleResult();
		System.out.println("Average Budget="+avgbudget);
		
		CriteriaBuilder cb4 = session.getCriteriaBuilder();
		CriteriaQuery<Double> cq4 = cb4.createQuery(Double.class);
		Root<Project> root4 = cq4.from(Project.class);
		cq4.select(cb4.min(root4.get("budget")));
		double minbudget = session.createQuery(cq4).getSingleResult();
		System.out.println("Minimum Budget="+minbudget);
		
		CriteriaBuilder cb5 = session.getCriteriaBuilder();
		CriteriaQuery<Double> cq5 = cb5.createQuery(Double.class);
		Root<Project> root5 = cq5.from(Project.class);
		cq5.select(cb5.max(root5.get("budget")));
		double maxbudget = session.createQuery(cq5).getSingleResult();
		System.out.println("Minimum Budget="+maxbudget);
	
		session.close();
		sf.close();	
	}

}
