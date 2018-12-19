package com.smart.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

@SpringApplicationContext({"classpath:/xiaochun-dao.xml"})
public class BaseDaoTest extends UnitilsTestNG{
	@SpringBean("hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
}