package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.boardmodel;
import service.userservice;

//(손유림)
@WebServlet("/mywriting")
public class mywritingcontroller extends HttpServlet{
	private static final long serialVersionUID = 1L;
    

    public mywritingcontroller() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id"); 
		String title = request.getParameter("title");
		
		//내 글 목록 중에서 글제목을 누르는지 안 누르는지 확인
		//누르지 않았다면 현재 글 목록을 보여준다.
		if(title == null || title.length() == 0)
		{
			ArrayList<boardmodel> writing = new ArrayList<boardmodel>();

			userservice service = new userservice();
			
			writing = service.mywriting(id);
			
			request.setAttribute("writing", writing);		
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/mywriting.jsp");
		    rq.forward(request, response); 
		}
		//글제목을 눌렀다면 글 내용 상세히 페이지로 이동
		else
		{
			boardmodel board = new boardmodel();
			
			userservice service = new userservice();
			
			board = service.detailborad(title);
			
			request.setAttribute("board", board); 
			
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/detailmywriting.jsp");
		    rq.forward(request, response);  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			doGet(request, response);
	}
}
