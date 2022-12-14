package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.usermodel;
import service.userservice;


//최민성
@WebServlet("/login")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public logincontroller() {

    }

    //get요청시 로그인 페이지 포워딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/loginpage.jsp");
	    rq.forward(request, response);     
	}

//로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		usermodel model=new usermodel();
		model.setId(id);
		model.setPwd(pwd);	
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		
		userservice dao = new userservice();
		int result=dao.findbyuserid(model);
		
		if(result==1)
		{
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/mainpage.jsp");
		    rq.forward(request, response);     
		}
		else
		{
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/loginpage.jsp");
		    rq.forward(request, response);     
		}
		    
	
	}

}
