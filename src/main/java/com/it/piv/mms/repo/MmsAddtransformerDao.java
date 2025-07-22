package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddtransformer;
import com.it.piv.mms.domain.MmsAddtransformerPK;


public interface MmsAddtransformerDao {
	
	public String addTransformer(MmsAddtransformer obj);
	public String updateTransformer(MmsAddtransformer obj);
	public MmsAddtransformer findById(MmsAddtransformerPK ojb);
	public List<MmsAddtransformer> findByGantryId(String gantryId);
	public String getNextTransformerId(String appIdPrefix);
	

}
