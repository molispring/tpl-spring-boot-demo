package com.yonyou.moli.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yonyou.iuap.meta.MetaDataController;
import com.yonyou.iuap.meta.MetaProxy;
import com.yonyou.iuap.meta.common.Result;

@Component
public class UserMetaController implements MetaDataController{

	private String viewId = "1";
	
	@Autowired
	private MetaProxy metaProxy;
	
	@Override
	public void setMetaData(Result result) {
		result.setResult("metaData", "metaData");
		result.setResult("viewData", "viewData");
		result.setResult("relation", "relation");
	}
	
	@PostConstruct
	@Override
	public void register() {
		metaProxy.register(this, viewId);
	}

}
