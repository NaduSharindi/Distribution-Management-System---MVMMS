package com.it.piv.mms.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Speststd;
import com.it.piv.mms.domain.SpeststdPK;

public interface SpeststdDao {
	public Speststd findById(SpeststdPK pk);
}
