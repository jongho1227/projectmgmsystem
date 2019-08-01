package kr.yi.system.project;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.yi.system.dao.ProjectDao;
import kr.yi.system.dto.Project;
import kr.yi.system.util.MySqlSessionFactory;


public class ProjectTest{
	SqlSession session = MySqlSessionFactory.openSession();
	ProjectDao dao = session.getMapper(ProjectDao.class);
	
	@Test
	public void test01selectListByAll() {
		List<Project> list = dao.selectListByAll();
		
		Assert.assertNotNull(list);
	}
	@Test
	public void test02addProject() {
		Project project = new Project("프로젝트", "프로젝트임", "2019-08-01" , "2019-08-30", "준비");
		int res = dao.addProject(project);
		
		Assert.assertEquals(res, 1);
	}
	@Test
	public void test03selectByNo() {
		Project project = new Project(1);
		Project project2 = dao.selectByNo(project);
		
		Assert.assertNotNull(project2);
	}
	@Test
	public void test04updateProject() {
		Project project = new Project(1,"프로젝트", "프로젝트임", "2019-08-01" , "2019-08-30", "준비");
		int res = dao.updateProject(project);
		
		Assert.assertEquals(res, 1);
	}
	@Test
	public void test05deleteProject() {
		Project project = new Project(1);
		int res = dao.deleteProject(project);
		
		Assert.assertEquals(res, 1);
	}

}
