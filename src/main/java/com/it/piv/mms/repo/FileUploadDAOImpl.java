package com.it.piv.mms.repo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.UploadFile;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO {
	
	
	public SessionFactory sessionFactory;
	
	public FileUploadDAOImpl() {
	}

	public FileUploadDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void save(UploadFile uploadFile) {
		System.out.println("test : " + sessionFactory);
		this.sessionFactory.getCurrentSession().save(uploadFile);
	}

}
