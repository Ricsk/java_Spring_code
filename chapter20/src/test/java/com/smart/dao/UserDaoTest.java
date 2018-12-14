package com.smart.dao;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import com.smart.domain.User;

@SpringApplicationContext({"smart-dao.xml"})
public class UserDaoTest extends UnitilsTestNG{
	@SpringBean("hibernateUserDao")
	private UserDao userDao;
	
	@Test
	@DataSet(value="UserDao.Users.xls")
	public void findUserByUserName() {
/*		User user = userDao.findUserByUserName("tony");
		Assert.assertNull(user, "不存在用户名为tony的用户!");
        user = userDao.findUserByUserName("tom");
        Assert.assertNotNull(user, "tom用户存在！");
        Assert.assertEquals(user.getUserName(),"tom");
        Assert.assertEquals(user.getPassword(),"123456");*/
	}
}