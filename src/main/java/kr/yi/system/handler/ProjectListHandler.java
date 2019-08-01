package kr.yi.system.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.system.controller.CommandHandler;
import kr.yi.system.dao.ProjectDao;
import kr.yi.system.dto.Project;
import kr.yi.system.util.MySqlSessionFactory;

public class ProjectListHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			SqlSession sqlSession = null;
			
			try {
				sqlSession = MySqlSessionFactory.openSession();

				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				List<Project> list = dao.selectListByAll();
				
			
				
				req.setAttribute("list", list);
				
				return "/WEB-INF/view/projectList.jsp";
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
		}
		return null;
	}

}
