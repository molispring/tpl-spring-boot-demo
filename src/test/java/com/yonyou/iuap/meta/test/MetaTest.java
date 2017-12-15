package com.yonyou.iuap.meta.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yonyou.moli.ui.builder.DTOBuilder;

public class MetaTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
/*    	//String file ="E:\\Users\\lip\\git\\molimvc\\docs\\dto.json";
		
		//String file = "com.yonyou.moli.model.PersonDO";
//      String outDir = "D:\\metaData\\code\\molimodel\\src\\test\\";
    	String outDir = "E:\\Users\\lip\\git\\tpl-spring-boot-demo\\src\\main\\java\\";
        //String outDir = "D:\\github\\tpl-spring-boot-demo\\src\\main\\java\\";
      
      
      System.out.println(file + " to " + outDir);

      HashMap<String, String> params = new HashMap<>();
      params.put(DTOBuilder.PARAM_FILE, file);
      params.put(DTOBuilder.PARAM_OUT_DIR, outDir);
      params.put(DTOBuilder.FULL_DO_CLASSNAME, file);
      new DTOBuilder().build(params);
 //    new DTOBuilder().buildFromDO(params);
*/	
		
		//String file = "test.com.yonyou.moli.model.PersonDO";
//      String outDir = "D:\\metaData\\code\\molimodel\\src\\test\\";
//      String outDir = "D:\\outgit\\molimvc\\src\\test\\java\\";
		String outDir="E:\\Users\\lip\\git\\tpl-spring-boot-demo\\src\\main\\java\\";
    	//String outDir = "E:\\test\\";
      
      
     // System.out.println(file + " to " + outDir);

      HashMap<String, Object> params = new HashMap<>();
      
      params.put(DTOBuilder.PARAM_MODEL_FILE, "OrderManager");
      List<String> dofiles = new ArrayList<String>();
      dofiles.add("com.yonyou.model.OrderDO");
      dofiles.add("com.yonyou.model.OrderItemDO");
      params.put(DTOBuilder.PARAM_FILE, dofiles);
      params.put(DTOBuilder.PARAM_OUT_DIR, outDir);
  //    new DTOBuilder().build(params);
      new DTOBuilder().batchBuildFromDO(params);
	
	
	}
}
