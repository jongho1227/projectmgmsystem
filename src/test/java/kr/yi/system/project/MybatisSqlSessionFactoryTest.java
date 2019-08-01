package kr.yi.system.project;


import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.yi.system.util.MySqlSessionFactory;


public class MybatisSqlSessionFactoryTest{
	@Test
	public void testOpenSession() {
		SqlSession session = MySqlSessionFactory.openSession();
		Assert.assertNotNull(session);
	}

}
