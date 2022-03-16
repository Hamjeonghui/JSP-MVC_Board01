package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.BoardSet;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward=new ActionForward();

		BoardDAO dao=new BoardDAO();
		ArrayList<BoardSet> datas=dao.selectAll(3);
		req.setAttribute("datas", datas);
		
		//datas가지고 메인으로 곧장 가
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}