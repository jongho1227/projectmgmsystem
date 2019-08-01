package kr.yi.system.dao;

import java.util.List;

import kr.yi.system.dto.Project;

public interface ProjectDao {
	public List<Project> selectListByAll();
	public int addProject(Project project);
	public Project selectByNo(Project project);
	public int updateProject(Project project);
	public int deleteProject(Project project);
}
