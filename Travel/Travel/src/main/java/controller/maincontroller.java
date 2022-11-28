package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//김진홍
@WebServlet("/main")
public class maincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public maincontroller() {
        
    }

	// get 요청시 cmd 파람값에 따라 분기 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		String cmd=request.getParameter("cmd");
		
		//게시판 전체 리스트 
		if(cmd==null) {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/mainpage.jsp");
	    rq.forward(request, response); 
		}//채팅 페이지
		else if(cmd.equals("chat"))
		{
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/chat.jsp");
		    rq.forward(request, response);
		}
	
		 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
