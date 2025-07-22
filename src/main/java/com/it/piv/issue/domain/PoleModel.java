package com.it.piv.issue.domain;

import java.io.Serializable;
import java.util.List;

import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.domain.MmsAddmvpolecct;

@SuppressWarnings("serial")
public class PoleModel implements Serializable{
	
	private MmsAddmvpole mvPole;
	private List<MmsAddmvpolecct> mvPoleCctList;

	public List<MmsAddmvpolecct> getMvPoleCctList() {
		return mvPoleCctList;
	}

	public void setMvPoleCctList(List<MmsAddmvpolecct> mvPoleCctList) {
		this.mvPoleCctList = mvPoleCctList;
	}

	public MmsAddmvpole getMvPole() {
		return mvPole;
	}

	public void setMvPole(MmsAddmvpole mvPole) {
		this.mvPole = mvPole;
	}

}
