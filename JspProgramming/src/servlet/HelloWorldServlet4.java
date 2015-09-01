package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorldServlet4 extends HttpServlet {
	
	private String greeting;
	
	
	public HelloWorldServlet4(){
		System.out.println("HelloWorldServlet4()");
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		greeting = config.getInitParameter("greeting");
		System.out.println("greeting: " + greeting);
	}
	
	//init: 생성자 다음에 딱 한 번 실행. 초기화를 위해 실행되는 메소드. 외부의 데이터를 받음.
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() -"+ greeting);
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy()- 나 죽어요~");
	}
}

	












