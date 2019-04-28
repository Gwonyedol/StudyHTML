package com.bit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServletController
 */
@WebServlet(
		description = "이녀석은 controller역할을 합니다.", 
		urlPatterns = { "/Front.do" }
		)
public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//localhost:8090/WebServlet_1/Front.do
		String command = request.getParameter("cmd");
		String m = "";
		if(command.equals("greeting")) {
			//DAO,DTO 객체 생성 사용
			//객체 생성
			Message msg = new Message();
			m = msg.getMessage(command);
		}
		request.setAttribute("msg",m);
		
		RequestDispatcher dis = request.getRequestDispatcher("/greeting.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
