package com.yonyou.moli.model;

import com.yonyou.iuap.moli.model.MoliModel;
import com.yonyou.iuap.moli.model.MoliViewData;
import com.yonyou.iuap.moli.model.MoliViewMetaData;
import com.yonyou.iuap.moli.model.MoliViewRelation;

public class UserModel extends MoliModel {

	private static String ENTITY_NAME = "userView";

	public UserModel() {
		super(ENTITY_NAME);
	}

	public UserModel(MoliModel model) {
		super(model);
		super.setMainView(ENTITY_NAME);
	}

	public void loadView() {
		MoliViewData main = new MoliViewData(this);
		MoliViewMetaData motaData = new MoliViewMetaData();
		MoliViewRelation relation = new MoliViewRelation();
		this.viewCollections.put(ENTITY_NAME, main);
	}

	public void loadViewMeta() {
		super.loadView("childView1");
		super.loadView("userSchools");
		//
		// ViewModelRelation("user","userSchools",RelationType.ONE_TO_ONE,id,id);
	}





}
