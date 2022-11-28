package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.userservice;

//(손유림)
@WebServlet("/deleteuser")
public class deleteusercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public deleteusercontroller() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/deleteuser.jsp");
	    rq.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");   		
		String pwd = request.getParameter("pwd");
		String pwdr = request.getParameter("pwdr");
		
		HttpSession session = request.getSession(); 
		String id = (String) session.getAttribute("id");
		
		userservice service = new userservice();
		
		//현재 비밀번호를 제대로 작성했는지 확인
		if(service.Checkpwd(pwd, id) == 1)
		{
			//비밀번호 재확인
			if(pwd.equals(pwdr))
			{
				//회원탈퇴 성공 여부 반환 ( 1:성공, 0:실패 )
				if(service.Deleteuser(pwd) == 1)
					request.setAttribute("Result", 1);
				else 
					request.setAttribute("Result", 0);
			}
			else
			{
				//비밀번호 재확인 실패 반환
				request.setAttribute("Result", 2);
			}
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/deleteresult.jsp");
		    rq.forward(request, response);
		} 
		else
		{
			//현재 비밀번호 제대로 작성 실패 반환
			request.setAttribute("Result", 3);
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/deleteuser.jsp");
		    rq.forward(request, response);
		}	
	}
}
