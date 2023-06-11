package com.mgt.plat;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.mgt.plat.controller.oss.OssControler;
import com.mgt.plat.controller.well.WellController;
import com.mgt.plat.entity.well.NodeInfo;
import com.mgt.plat.entity.well.WellInfo;
import com.mgt.plat.utils.ResultBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class MgtTplPlatApplicationTests {
	@Autowired
	WellController wellController;

	@Autowired
	OSS ossClient;
	@Autowired
	OssControler ossControler;

//	@Autowired
//	NodeInfo nodeInfo;

	@Test
	void contextLoads() {
		ResultBean<List> wellInfo = wellController.findWellInfo();

	}
	@Test
	void test1(){
		ossControler.policy();
	}

}
