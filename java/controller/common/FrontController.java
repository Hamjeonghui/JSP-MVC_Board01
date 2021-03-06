package controller.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */package controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DeleteBoardAction;
import controller.action.DeleteReplyAction;
import controller.action.FavAction;
import controller.action.InsertBoardAction;
import controller.action.InsertReplyAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.SignupAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String command=uri.substring(cp.length());

		ActionForward forward=null;
		if(command.equals("/main.do")) {

			System.out.println("FC:???????????? ??????");
			try {
				forward=new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/login.do")) {

			System.out.println("FC:????????? ??????");
			try {
				forward=new LoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/logout.do")) {

			System.out.println("FC:???????????? ??????");
			try {
				forward=new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/signup.do")) {

			System.out.println("FC:???????????? ??????");
			try {
				forward=new SignupAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/fav.do")) {

			System.out.println("FC:????????? ??????");
			try {
				forward=new FavAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/insertReply.do")) {

			System.out.println("FC:???????????? ??????");
			try {
				forward=new InsertReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/insertBoard.do")) {

			System.out.println("FC:??????????????? ??????");
			try {
				forward=new InsertBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/deleteReply.do")) {

			System.out.println("FC:?????? ?????? ??????");
			try {
				forward=new DeleteReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/deleteBoard.do")) {

			System.out.println("FC:??????????????? ??????");
			try {
				forward=new DeleteBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("????????? ??????");
		}

		//?????? ???????????? ???????????? ??????
		if(forward!=null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		} // forward??? null??? ????????? ???????????? ?????????????????? else?????? ????????? ????????? ???????????? ??????.
		
		//???????????? forward??? null?????? ?????????????????? ??? ??? ????????? new?????? ???????????????
		// ????????? <script>??????
		PrintWriter out=response.getWriter();
		out.println("<script>alert('???????????? ??????');history.go(-1);</script>");
		
	}
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
