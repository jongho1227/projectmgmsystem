package kr.yi.system.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.system.controller.CommandHandler;
import kr.yi.system.dao.ProjectDao;
import kr.yi.system.dto.Project;
import kr.yi.system.util.MySqlSessionFactory;

public class ProjectAddHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/projectAdd.jsp";
			
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			
			SqlSession sqlSession = null;
			
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String start = req.getParameter("start");
			String end = req.getParameter("end");
			String state = req.getParameter("kind");
			
			try {
				sqlSession = MySqlSessionFactory.openSession();
				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				Project project = new Project(name, content, start, end, state);
				
				dao.addProject(project);
				sqlSession.commit();
				
				res.sendRedirect("list.do");
				return null;
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
		}
		return null;
	}

}
