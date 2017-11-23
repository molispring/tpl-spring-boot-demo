package com.yonyou.moli.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yonyou.iuap.business.util.ResultUtil;
import com.yonyou.iuap.meta.common.Result;
import com.yonyou.iuap.rpc.md.UIViewMetaData;
import com.yonyou.iuap.rpc.md.UIViewProperty;
import com.yonyou.iuap.rpc.service.MetaViewSevice;
import com.yonyou.moli.model.TestUserModel;
import com.yonyou.moli.model.TestUserRecord;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/15.
 */
@RestController
@RequestMapping("rest/uiView")
public class UIController {

    @Reference
    private MetaViewSevice metaViewSevice;

    String categoryCode = "demo";

    @RequestMapping(name = "",method = RequestMethod.POST)
    public Result load(@RequestBody Object object) {
        //TODO 自定义实现
        return ResultUtil.success();
    }

    @RequestMapping(name = "",method = RequestMethod.PUT)
    public Result update(@RequestBody Object object) {
        //TODO 自定义实现
        return ResultUtil.success();
    }

    @RequestMapping(name = "",method = RequestMethod.GET)
    public Result get(HttpServletRequest request, HttpServletResponse response) {
        String componentCode = request.getParameter("componentCode");
        String viewCode = request.getParameter("viewCode");
        String deviceType = request.getParameter("deviceType");
        UIViewMetaData metaData = metaViewSevice.getView(componentCode, viewCode, deviceType);
        Map<String, UIViewProperty> metas = metaData.getProperties();
        Map<String,Object> views = genViewData();
        Map<String,Object> result = new HashMap<>();
        result.put("metas",metas);
        result.put("views",views);


        return ResultUtil.success(result);
    }

    @RequestMapping(name = "",method = RequestMethod.DELETE)
    public Result delete() {
        //TODO 自定义实现
        return ResultUtil.success();
    }

    private Map<String ,Object> genViewData() {
        Map<String,Object> bizDatas = new HashMap<>();
        TestUserRecord userRecord = new TestUserRecord();
        TestUserModel userModel = new TestUserModel();
        List<TestUserRecord> records = new ArrayList<>();
        userRecord.setAvatar("https://hongbao-cdn.yonyoucloud.com//uculture/app/user-avator/account.png");
        userRecord.setDepartmentId("123");
        userRecord.setDepartmentName("移动平台部");
        userRecord.setPhone("13010205229");
        userRecord.setName("xyy");
        userRecord.setSex("0");
        records.add(userRecord);

        userRecord = new TestUserRecord();
        userRecord.setAvatar("https://hongbao-cdn.yonyoucloud.com//uculture/app/user-avator/2017/09/21/a66606f9-41d0-4321-81d9-1ea2c7a2e49a.jpg");
        userRecord.setDepartmentId("123");
        userRecord.setDepartmentName("移动平台部");
        userRecord.setPhone("13010205229");
        userRecord.setName("gct");
        userRecord.setSex("0");
        records.add(userRecord);
        userModel.setRecords(records);

        bizDatas.put("Users", userModel);
        return bizDatas;
    }
}
