package kr.yi.system.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.system.controller.CommandHandler;
import kr.yi.system.dao.ProjectDao;
import kr.yi.system.dto.Project;
import kr.yi.system.util.MySqlSessionFactory;

public class ProjectUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int no = Integer.parseInt(req.getParameter("no"));
			SqlSession sqlSession = null;
			try {
				sqlSession = MySqlSessionFactory.openSession();

				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				Project project = dao.selectByNo(new Project(no));
								
				req.setAttribute("project", project);
				
				return "/WEB-INF/view/projectUpdate.jsp";
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
		}
		else {
			SqlSession sqlSession = null;
			int no = Integer.parseInt(req.getParameter("no"));
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String start = req.getParameter("start");
			String end = req.getParameter("end");
			String state = req.getParameter("kind");
			
			try {
				sqlSession = MySqlSessionFactory.openSession();
				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				Project project = new Project(no, name, content, start, end, state);
				
				dao.updateProject(project);
				sqlSession.commit();
				
				req.setAttribute("project", project);
				
				return "/WEB-INF/view/projectView.jsp";
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
		}
		return null;
	}

}
