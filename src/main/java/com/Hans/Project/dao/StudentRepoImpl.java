package com.Hans.Project.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Hans.program.bean.StudentBO;
import com.Hibernate.utility.HibernateUtilty;



public class StudentRepoImpl implements IStudentRepo {

	private static Session session = null;
	
	static {
			session = HibernateUtilty.getSession();
	}

	@Override
	public String insertRecord(StudentBO stdBo) {
		String status = "";
		Transaction transaction=null;
		boolean flag = false;
		try {
		 transaction = session.beginTransaction();
		session.save(stdBo);
		flag = true;
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(transaction != null) {
					if(flag) {
						status = "success";
						transaction.commit();
					}else {
						status = "Data Not Stored Sucessfully !";
						transaction.rollback();
					}
				}
			}catch(HibernateException he) {
					he.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
				
		}
		
		return status;
	}

	@Override
	public StudentBO readRecord(Integer sid) {
		StudentBO Student = null;
		try {
		Student = session.get(StudentBO.class, sid);
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}
		
		
		return Student;
	}

	@Override
	public String deleteRecord(Integer sid) {

		String status = "";
		Transaction transaction = null;
		boolean flag = false;
		try {
			transaction = session.beginTransaction();
		StudentBO student =readRecord(sid);
		if(student != null)
		{		
		session.delete(student);
		flag = true;
		}else {
			status = "Data Not Present ";
		}
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(transaction != null) {
					if(flag) {
						status = "success";
						transaction.commit();
					}else {
						status = "Data Not Stored Sucessfully !";
						transaction.rollback();
					}
				}
			}catch(HibernateException he) {
					he.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
				
		}
		
		
		
		return status;
	}

	@Override
	public String updateRecord(StudentBO stdBo) {
		String status = "";
		Transaction transaction=null;
		boolean flag = false;
		try {
		 transaction = session.beginTransaction();
		session.save(stdBo);
		flag = true;
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(transaction != null) {
					if(flag) {
						status = "success";
						transaction.commit();
					}else {
						status = "Data Not Stored Sucessfully !";
						transaction.rollback();
					}
				}
			}catch(HibernateException he) {
					he.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
				
		}
		
		return status;
	}

}
