package com.yonyou.iuap.meta.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import com.yonyou.moli.ui.builder.DTOBuilder;

public class MetaTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
    	String file = "com.yonyou.moli.workbench.model.WidgetDO";
//      String outDir = "D:\\metaData\\code\\molimodel\\src\\test\\";
      String outDir = "D:\\github\\tpl-spring-boot-demo\\src\\main\\java\\";
      
      
      System.out.println(file + " to " + outDir);

      HashMap<String, String> params = new HashMap<>();
      params.put(DTOBuilder.PARAM_FILE, file);
      params.put(DTOBuilder.PARAM_OUT_DIR, outDir);
      params.put(DTOBuilder.FULL_DO_CLASSNAME, file);
//      new DTOBuilder().build(params);
      new DTOBuilder().buildFromDO(params);
	}
}
