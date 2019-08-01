package kr.yi.system.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.system.controller.CommandHandler;
import kr.yi.system.dao.ProjectDao;
import kr.yi.system.dto.Project;
import kr.yi.system.util.MySqlSessionFactory;

public class ProjectDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int no = Integer.parseInt(req.getParameter("no"));
			SqlSession sqlSession = null;
			try {
				sqlSession = MySqlSessionFactory.openSession();

				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				Project project = dao.selectByNo(new Project(no));
								
				dao.deleteProject(project);
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
