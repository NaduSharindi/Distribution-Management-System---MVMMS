package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddsupporttype;

public interface MmsAddSupportTypeDao {
	public String addSupportType(MmsAddsupporttype supportType);
	public List<MmsAddsupporttype> findAll();
	public void updateSupportType(MmsAddsupporttype obj);
}
