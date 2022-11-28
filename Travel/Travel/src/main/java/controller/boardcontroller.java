package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.boardmodel;

import service.boardservice;

//김진홍
@WebServlet("/board")
public class boardcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public boardcontroller() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//cmd로 넘어온 값에 따라 기능 분리
		String cmd=request.getParameter("cmd");
		
		//게시판 전체 리스트 
		if(cmd.equals("getlist")) {
			ArrayList<boardmodel> lists=new ArrayList<boardmodel>();

			boardservice service=new boardservice();
			
			lists=service.getlist();
			
			request.setAttribute("lists", lists);
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/boardpage.jsp");
		    rq.forward(request, response);  
		}//게시판 글 상세 내용
		else if(cmd.equals("getdetail")) {
			
			int listid=Integer.parseInt(request.getParameter("listid"));
			
			boardmodel detail=new boardmodel();
			
			boardservice service=new boardservice();
			detail=service.getdetail(listid);
			
			request.setAttribute("detail", detail);
			
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/detailboard.jsp");
		    rq.forward(request, response);  
		}//글쓰기(조윤주)
		else if(cmd.equals("write")) {
			
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/write.jsp");
		    rq.forward(request, response); 
		}//글삭제(조윤주)
		else if(cmd.equals("delete")) {
			int listID = Integer.parseInt(request.getParameter("listID"));
			
			
			boardservice service = new boardservice();
			service.del(listID);

			response.sendRedirect("/board?cmd=getlist");
		}//글수정시 원래 데이터 보여줌(조윤주)
		else if(cmd.equals("showupdate"))
		{
			String title=request.getParameter("title");
			
			boardmodel detail=new boardmodel();
			boardservice service=new boardservice();
			
			detail=service.showupdate(title);
			
			request.setAttribute("detail", detail);
			
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/updateboard.jsp");
		    rq.forward(request, response);  
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			request.setCharacterEncoding("utf-8");
			
			String cmd=request.getParameter("cmd");
			
			
			if(cmd.equals("search")) 
			{
				String title=request.getParameter("title");
				
			
				ArrayList<boardmodel> lists=new ArrayList<boardmodel>();

				boardservice service=new boardservice();
						
				lists=service.search(title);
						
				request.setAttribute("lists", lists);	
				
				
				RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/view/boardpage.jsp");
			    rq.forward(request, response);  
			}//글쓰기(조윤주)
			else if(cmd.equals("write")) {
				request.setCharacterEncoding("utf-8");
				
				String userID = request.getParameter("userID");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				
				
				boardmodel bm = new boardmodel();
				bm.setUserID(userID);
				bm.setTitle(title);
				bm.setContent(content);
				
				
				boardservice service = new boardservice();
				service.insert(bm);
				
				response.sendRedirect("/board?cmd=getlist");
			}//글수정(조윤주)
			else if(cmd.equals("update")) {
				String title=request.getParameter("title");
				request.setCharacterEncoding("utf-8");
				
				String userID = request.getParameter("userID");
				String content = request.getParameter("content");
				
				boardmodel bm=new boardmodel();
				boardservice service = new boardservice();
			
				bm.setUserID(userID);
				bm.setTitle(title);
				bm.setContent(content);
				
				service.update(bm);
				
				response.sendRedirect("/board?cmd=getlist");
			}

	}
	
	
	

}
