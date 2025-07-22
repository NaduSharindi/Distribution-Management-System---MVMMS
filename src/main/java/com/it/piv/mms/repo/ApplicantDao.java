package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Applicant;

public interface ApplicantDao {
	public List<Applicant> getAllApplicantBydeptId(String deptId);
	public Applicant findById(String id);


}
