package com.yonyou.moli.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yonyou.iuap.business.exception.ExceptionHandle;
import com.yonyou.iuap.business.moli.service.UserService;
import com.yonyou.iuap.business.moli.vo.UserEntity;
import com.yonyou.iuap.business.util.ResultUtil;
import com.yonyou.iuap.meta.common.Result;
import com.yonyou.iuap.moli.controller.MoliController;
import com.yonyou.iuap.moli.model.MoliFilter;
import com.yonyou.iuap.moli.model.MoliModel;
import com.yonyou.iuap.moli.model.MoliRecord;
import com.yonyou.moli.model.UserModel;
import com.yonyou.moli.model.UserRecord;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("userlink")
public class UserController extends MoliController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ExceptionHandle exceptionHandle;

	@Override
	public int save(MoliRecord record) {
		userService.save(((UserRecord) record).toEntity());
		return 1;
	}

	@RequestMapping(value = "save", method = { RequestMethod.POST, RequestMethod.GET })
	public Result saveUser(String userJson, HttpServletRequest request) {
		UserModel model = new UserModel(super.collect(request));

		UserRecord user = (UserRecord) model.getMainViewData().getCurrentRecord();
		String name = user.getName();
		if (name == null || "".equals(name)) {
			return ResultUtil.error(0, "用户名不能为空");
		}
		String email = user.getEmail();
		if (email == null || "".equals(email)) {
			return ResultUtil.error(0, "邮箱不能为空");
		}
		int rs = save(user);
		if (rs > 0) {
			model.getMainViewData().setCurrentRecord(user);
			return ResultUtil.success(model.toJSONObject());
		} else {
			return ResultUtil.error(0, super.getErrorMessage());
		}

	}

	@RequestMapping(value = "findUser", method = { RequestMethod.POST, RequestMethod.GET })
	public Result findUser(String userJson, HttpServletRequest request) {
		UserModel model = new UserModel(this.collect(request));
		model = (UserModel) loadByCondition(model, model.getFilter());
		return ResultUtil.success(model.toJSONObject());
	}

	@Override
	public MoliModel loadByCondition(MoliModel model, MoliFilter filter) {
		String whereString = filter.getFilter();
		UserEntity user = null; // TODO query by whereString;
		UserRecord rec = UserRecord.fromEntity(UserRecord.class, user);
		rec.setName("zm");
		model.getMainViewData().add(rec);
		return model;
	}

	@RequestMapping(value = "testModel", method = { RequestMethod.POST, RequestMethod.GET })
	public Result testModel(String userJson, HttpServletRequest request) {
		UserModel model = new UserModel();
		model.loadView();
		UserRecord rec = new UserRecord();
		rec.setName("zm");
		model.getMainViewData().add(rec);
		// model = (UserModel) super.loadByCondition(model,model.getFilter());
		return ResultUtil.success(model.toJSONObject());
	}

	@RequestMapping(value = "deleteUser", method = { RequestMethod.POST, RequestMethod.GET })
	public Result deleteUser(String userJson, HttpServletRequest request) {
		UserModel model = new UserModel(this.collect(request));
		UserRecord user = (UserRecord) model.getMainViewData().getCurrentRecord();
		int rs = delete(user);
		if (rs > 0) {
			model.getMainViewData().delete(user);
			return ResultUtil.success(model.toJSONObject());
		} else {
			return ResultUtil.error(0, super.getErrorMessage());
		}
	}

	@RequestMapping(value = "update", method = { RequestMethod.POST, RequestMethod.GET })
	public String update(String userJson, HttpServletRequest request) {

		Result result = ResultUtil.success();
		try {

			UserEntity user = new Gson().fromJson(userJson, new TypeToken<UserEntity>() {
			}.getType());

			user = userService.save(user);

			result = ResultUtil.success(JSONObject.fromObject(user));

		} catch (Exception e) {
			result = exceptionHandle.exceptionGet(e);
		}

		return JSONObject.fromObject(result).toString();
	}

	@RequestMapping(value = "getMyCorpUser", method = { RequestMethod.POST, RequestMethod.GET })
	public String load(Integer pageNum, String keywords, HttpServletRequest request) {

		Result result = ResultUtil.success();
		try {

			if (pageNum == null) {
				pageNum = 1;
			}

			if (keywords == null) {
				keywords = "";
			}

			Map<String, String> map = new HashMap<String, String>();

			map.put("name", keywords);

			Page<UserEntity> list = userService.findAll(pageNum, map);

			result = ResultUtil.success(JSONArray.fromObject(list.getContent()), pageNum);

		} catch (Exception e) {
			result = exceptionHandle.exceptionGet(e);
		}

		return JSONObject.fromObject(result).toString();
	}

	@RequestMapping(value = "findUser2", method = { RequestMethod.POST, RequestMethod.GET })
	public String find(Integer id, HttpServletRequest request) {

		Result result = ResultUtil.success();
		try {
			UserEntity user = userService.findOne(id);

			result = ResultUtil.success(JSONObject.fromObject(user));

		} catch (Exception e) {
			result = exceptionHandle.exceptionGet(e);
		}

		return JSONObject.fromObject(result).toString();
	}

}
