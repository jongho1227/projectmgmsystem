package kr.yi.system.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerUsingURI extends HttpServlet {
	
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		
		
		String configFile = getInitParameter("configFile");// /WEB-INF/commandHandler.properties
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);// 상대주소를 절대주소로 바꿈.
		
	
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
		
		Iterator keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next(); // key를 추출 / simple.do
			String handlerClassName = prop.getProperty(command); // key에 해당하는 값 : mvc.simple.SimpleHandler
			Class<?> handlerClass;
			try {
				
				handlerClass = Class.forName(handlerClassName);//String되어있는 클래스를 class화 시킴
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();// new : 메모리에 올림
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String command = req.getRequestURI();// 주소가 넘어옴 : 
		if(command.indexOf(req.getContextPath())==0) {
			command = command.substring(req.getContextPath().length());
		}
		
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		
		try {
			viewPage = handler.process(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
	}
}