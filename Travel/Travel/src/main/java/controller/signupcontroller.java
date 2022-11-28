package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.usermodel;
import service.userservice;

//최민성
//서블렛으로 불러오기
@WebServlet("/signup")
public class signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//signuppage doget 연결
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/signuppage.jsp");
	    rq.forward(request, response);     
	}
	

	
	//db랑 연결 후 데이터 집어넣기
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
	    String date= req.getParameter("date");
		String gender = req.getParameter("gender");

		userservice service = new userservice();
		usermodel model = new usermodel();
		model.setId(id);
		model.setPwd(pwd);
		model.setName(name);
		model.setGender(gender);
        java.sql.Date date1 = java.sql.Date.valueOf(date);
        model.setDate(date1);
        
        int joinResult = service.Signup(model);
		
		if(joinResult == 1) { //성공하면 메인페이지
			req.setAttribute("joinResult", joinResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/mainpage.jsp");
			rd.forward(req, resp);
		} else {//실패하면 회원가입페이지
			req.setAttribute("joinResult", 0);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/signuppage.jsp");
			rd.forward(req, resp);
		}
		
	}

}
