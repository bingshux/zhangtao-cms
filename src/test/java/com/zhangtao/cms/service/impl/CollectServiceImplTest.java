package com.zhangtao.cms.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhangtao.cms.domain.Collect;
import com.zhangtao.cms.domain.User;
import com.zhangtao.cms.service.CollectService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class CollectServiceImplTest {
	@Resource
	private CollectService collectService;
	@Test
	public void testInsert() {
		User user = new User();
		user.setId(217);
		collectService.insert(new Collect(0, "text收集", "http://www.baidu.com", user, new Date()));
	}

	@Test
	public void testDelete() {
	
	}

	@Test
	public void testSelect() {
		
	}

}
