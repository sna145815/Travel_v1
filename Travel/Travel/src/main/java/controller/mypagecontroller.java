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

//(손유림)
@WebServlet("/mypage")
public class mypagecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public mypagecontroller() {
        
    }
	
    //회원정보 불러오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id");
		
		usermodel user = new usermodel();
		userservice service = new userservice();
		
		user = service.Selectuser(id);
		
		//로그인 여부 확인
		//로그인 후 마이페이지 누르면 회원정보 전달
		if(user != null && user.getId() != null) 
		{
			request.setAttribute("user", user);
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/mypage.jsp");
		    rq.forward(request, response);
		}
		//로그인을 하지 않고 마이페이지 누르면 로그인페이지로 이동
		else 
		{
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/loginpage.jsp");
		    rq.forward(request, response);
		}   
	}

	//비밀번호 수정처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");   		
		String pwd = request.getParameter("pwd");
		String uppwd = request.getParameter("uppwd");
		String uppwdr = request.getParameter("pwdr");
		
		HttpSession session = request.getSession(); 
		String id = (String) session.getAttribute("id");
		
		userservice service = new userservice();
		
		//현재 비밀번호 제대로 작성했는지 확인 
		if(service.Checkpwd(pwd, id) == 1)
		{
			//변경할 비밀번호 재확인
			if(uppwd.equals(uppwdr))
			{
				//비밀번호 수정 성공 여부 반환 ( 1:성공, 0:실패 )
				if(service.Updatepwd(uppwd, id) == 1)
					request.setAttribute("Result", 1);
				else 
					request.setAttribute("Result", 0);
			}
			else 
			{
				//비밀번호 재확인 실패 반환
				request.setAttribute("Result", 2);
			}
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/updateresult.jsp");
		    rq.forward(request, response);
		} 
		else
		{
			//현재 비밀번호 제대로 작성 실패 반환
			request.setAttribute("Result", 3);
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/updateresult.jsp");
		    rq.forward(request, response);
		}	
	}
}
