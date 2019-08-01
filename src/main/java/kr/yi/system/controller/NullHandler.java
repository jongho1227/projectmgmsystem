package kr.yi.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.sendError(HttpServletResponse.SC_NOT_FOUND); // 404에러 발생시킴, 없는 커맨드가 들어올때 이 클래스가 실행.
		return null;
	}

}
