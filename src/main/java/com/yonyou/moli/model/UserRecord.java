package com.yonyou.moli.model;

import com.yonyou.iuap.business.moli.vo.UserEntity;
import com.yonyou.iuap.moli.model.MoliRecord;

public class UserRecord extends MoliRecord{

	
	
	public String getName() {
		return (String) super.getValue("name");
	}

	public void setName(String name) {
		super.setValue("name", name);

	}

	public UserEntity toEntity() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String getEmail() {
		// TODO 自动生成的方法存根
		return (String) super.getValue("email");
	}


	
	
}
