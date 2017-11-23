//package com.yonyou.moli.controller;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.yonyou.moli.ui.IUIModel;
//import com.yonyou.moli.ui.md.UIViewMetaData;
//import com.yonyou.moli.ui.service.MetaViewSevice;
//import com.yonyou.uitest.model.UserModel;
//import com.yonyou.uitest.model.UserRecord;
//import com.yonyou.uitest.model.UserView;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by Administrator on 2017/11/16.
// */
//@RequestMapping("rest/uiView")
//@RestController
//public class UserUIController {
//
//    @Reference
//    private MetaViewSevice metaViewSevice;
//    
//    @RequestMapping(name = "",method = RequestMethod.GET)
//    public String load(HttpServletRequest request) {
//        UserModel model = genData();
//        UIViewMetaData meta = genUIViewMetaData(request);
//        if(meta != null) {
//            meta.setName(meta.getCode());
//        }
//        model.setUIViewMetaData(meta);
//        return model.toJSON();
//    }
//
//    public IUIModel save(HttpServletRequest request) {
//        return null;
//    }
//
//    private UIViewMetaData genUIViewMetaData(HttpServletRequest request) {
//        String componentCode = request.getParameter("componentCode");
//        String viewCode = request.getParameter("viewCode");
//        String deviceType = request.getParameter("deviceType");
//        UIViewMetaData metaData = metaViewSevice.getView(componentCode, viewCode, deviceType);
//        return metaData;
//    }
//
//    public UserModel genData(){
//        UserModel model = new UserModel();
//        UserView userList = new UserView();
//        UserRecord rec;
//        for (int i = 0; i <20; i++) {
//            rec = (UserRecord) userList.createNewRecord();
//            rec.setId(2L);
//            rec.setName("xyy" + i);
//            rec.setDepartmentId(123L);
//            rec.setDepartmentName("移动平台部");
//            rec.setPhone("13688888888");
//            rec.setSexName("男");
//            userList.add(rec);
//
//        }
//        model.addViewData(userList);
//        return model;
//    }
//}
